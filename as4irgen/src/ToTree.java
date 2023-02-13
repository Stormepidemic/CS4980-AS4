//
// ToTree.java: convert MiniJava programs to IR Tree
//      Based on material in Ch. 7 of the textbook.
//      Assumes type checking already done.
//

import Temp.Label;
import Temp.Temp;
import Tree.*;
import lexer.Lexer;
import lexer.LexerException;
import node.*;
import parser.Parser;
import parser.ParserException;
import symbol.ClassType;
import symbol.Scope;
import symbol.Symbol;
import symbol.Type;
import symboltable.DeclSyms;
import symboltable.DeclTypes;
import symboltable.ScopeAdapter;
import symboltable.TypeCheck;

import java.io.*;
import java.util.Iterator;

public class ToTree extends ScopeAdapter {
    static protected Print tree_printer = new Print(System.out);
    public final int WORD_SIZE = 4;
    // not implemented: method calls
    protected Exp result;
    protected ClassType lastClassType; // last class type encountered; used
    protected Frame frame;             // frame for current method

    public ToTree(String file) {
        super(file);
        frame = new MIPSFrame();
    }

    public ToTree(String file, Frame f, ClassType classt, Scope sc) {
        super(file);
        frame = f;
        curclass = classt;
        curscope = sc;
    }

    protected static void dumpCode() {
        for (Symbol klas : globals.allSymbols()) {
            //System.out.println("Checking class " + klas.getId());
            if (!klas.isClass())
                throw new Error(klas.getId() + " in globals not a class");
            ClassType ctype = (ClassType) klas.getType();
            //System.out.println("<< processing " + ctype.getChildScope() + ">>");
            Iterator<Symbol> kit = ctype.getChildScope().iterator();
            while (kit.hasNext()) {
                Symbol sym = kit.next();
                //System.out.println("  Checking symbol " + sym.getId() + ", klas: " + sym.getKlass());
                if (sym.isMethod()) {
                    Object o = sym.getMethodBody();
                    if (!(o instanceof Stm))
                        throw new Error("Expected statement in method body");
                    tree_printer.prStm((Stm) o);
                    System.out.println("\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean debug = false;

        int filename_arg = 0;
        if (filename_arg < args.length && args[0].equals("-d")) {
            debug = true;
            ++filename_arg;
        }
        String filename = "[unknown]";
        try {
            Reader reader;
            if (args.length >= 1) {
                reader = new FileReader(args[filename_arg]);
                String[] path_elements = args[filename_arg].split("[/\\\\]");
                filename = path_elements[path_elements.length - 1];
            } else {
                reader = new InputStreamReader(System.in);
                filename = "stdin";
            }
            // create lexer, parser, and abstract syntax tree
            Lexer lexer =
                    new Lexer(new PushbackReader(new BufferedReader(reader), 1024));
            Parser parser = new Parser(lexer);
            Start ast = parser.parse();
            reader.close();

            // identify all types
            if (debug)
                System.out.println("Declaring user-defined types.");
            DeclTypes dt_visitor = new DeclTypes(filename);
            ast.apply(dt_visitor);

            // declare all symbols - assumes types have been declared
            if (debug)
                System.out.println("Declaring all symbols.");
            DeclSyms ds_visitor = new DeclSyms(filename);
            ast.apply(ds_visitor);

            // TypeCheck nodes - could skip, but checking type correct reduces errors
            if (debug)
                System.out.println("Checking all expressions.");
            TypeCheck tc_visitor = new TypeCheck(filename);
            if (debug)
                tc_visitor.setDebug();
            ast.apply(tc_visitor);

            if (debug) {
                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("Symbols:");
                System.out.println(ds_visitor);
                System.out.println("----------------------------------------");
            }

            // Converting to IR tree
            if (debug)
                System.out.println("Converting to IR tree.");
            ToTree tt_visitor = new ToTree(filename);
            if (debug)
                tt_visitor.setDebug();
            ast.apply(tt_visitor);
            System.out.println("-----------");
            dumpCode();
            System.out.println("-----------");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (LexerException e) {
            System.out.println("Lexical token error: " + e);
        } catch (ParserException e) {
            System.out.println("Parse error: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Exp getResult() {
        return result;
    }

    // code for processing main in main class; illustrates how to use some of the bits and pieces
    @Override
    public void caseAMainDef(AMainDef node) {
        inAMainDef(node); // needed to establish scope
        node.getStatement().apply(this);
        if (!curscope.getOwner().equals("main"))
            throw new Error("Owner of main, " + curscope.getOwner()
                    + ", not main");
        Symbol funsym = curscope.lookup("main");
        if (funsym == null)
            throw new Error("Could not find method in which to store body");
        funsym.setMethodBody(frame.procEntryExit1("main",
                new EXPS(result),
                new CONST(0)));
        outAMainDef(node);
    }

    @Override
    public void caseAMethodBody(AMethodBody node) {
        // process body of a method: create a series of sequences followed by a return
        SEQ body_seq = new SEQ(new EXPS(new CONST(0)), new EXPS(new CONST(0)));
        for (PStatement pstmt : node.getStatement()) {
            // note don't care what was in result before
            pstmt.apply(this);
            // push next statement on front of result list
            body_seq = new SEQ(body_seq, new EXPS(result));
        }
        // process return statement
        node.getExp().apply(this);
        // store the resulting function body
        Symbol funsym = curscope.lookup(curscope.getOwner());
        if (funsym == null)
            throw new Error("Could not find method in which to store body");
        funsym.setMethodBody(frame.procEntryExit1(curscope.getOwner(), body_seq, result));
    }

    // processes if statements
    protected void processIf(Exp test, Exp true_part, Exp false_part, String test_text) {
        Label true_label = new Label(), false_label = new Label(), end_label = new Label();
        if (false_part == null) {
            result = new ESEQ(new SEQ(new Code("\t\t;;if " + test_text),
                    new CJUMP(CJUMP.NE, new CONST(0), test, true_label, end_label),
                    new LABEL(true_label),
                    new EXPS(true_part),
                    new Code("\t\t;;End if"),
                    new LABEL(end_label)),
                    new CONST(0));
        } else {
            result = new ESEQ(new SEQ(new Code("\t\t;;if2 " + test_text),
                    new CJUMP(CJUMP.NE, new CONST(0), test, true_label, false_label),
                    new LABEL(true_label),
                    new EXPS(true_part),
                    new JUMP(end_label),
                    new Code("\t\t;;else"),
                    new LABEL(false_label),
                    new EXPS(false_part),
                    new Code("\t\t;;end if"),
                    new LABEL(end_label)),
                    new CONST(0));
        }
    }

    @Override
    public void caseAIfoneStatement(AIfoneStatement node) {
        ToTree test_visitor = new ToTree(curFile, frame, curclass, curscope);
        node.getExp().apply(test_visitor);
        ToTree true_part_visitor = new ToTree(curFile, frame, curclass, curscope);
        node.getStatement().apply(true_part_visitor);
        processIf(test_visitor.getResult(), true_part_visitor.getResult(), null,
                node.getExp().toString());
    }

    @Override
    public void caseAIfStatement(AIfStatement node) {
        // TODO: write; similar to caseAIfoneStatement but add false part; use processIf
        ToTree test_visitor = new ToTree(curFile, frame, curclass, curscope);
        node.getExp().apply(test_visitor);
        ToTree true_part_visitor = new ToTree(curFile, frame, curclass, curscope); //True part tree
        node.getTruepart().apply(true_part_visitor);
        ToTree false_part_visitor = new ToTree(curFile, frame, curclass, curscope); //False part tree
        node.getFalsepart().apply(false_part_visitor);
        processIf(test_visitor.getResult(), true_part_visitor.getResult(), false_part_visitor.getResult(),
                node.getExp().toString()); //Send the TruePart tree & FalsePart tree to ProcessIf

    }

    // utility to handle while from multiple places; test_text used for documentation
    protected void processWhile(Exp test, Exp body, String test_text) {
        // TODO: write
        Label startPoint = new Label();
        Label L9 = new Label();
        Label exitPoint = new Label();
        Temp t2 = new Temp();
        result = new ESEQ(
                new SEQ(
                        new Code(";;while " + test_text),
                        new SEQ(
                                new LABEL(startPoint),
                                new SEQ(
                                        new CJUMP(CJUMP.NE, new CONST(0),
                                                test, L9, exitPoint),
                                        new SEQ(
                                                new LABEL(L9),
                                                new SEQ(new EXPS(body),
                                                        new SEQ(
                                                                new JUMP(startPoint),
                                                                new SEQ(
                                                                        new Code(";;end while"),
                                                                        new LABEL(exitPoint)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
                , new CONST(0));
    }

    @Override
    public void caseAWhileStatement(AWhileStatement node) {
        // TODO: write; will call processWhile to generate the code
        ToTree test_visitor = new ToTree(curFile, frame, curclass, curscope);
        node.getExp().apply(test_visitor);
        ToTree whileBodyVisitor = new ToTree(curFile, frame, curclass, curscope);
        node.getStatement().apply(whileBodyVisitor);
        System.out.println("WHILE: " + node.getExp());
        processWhile(test_visitor.getResult(), whileBodyVisitor.getResult(), node.getExp().toString());

    }

    @Override
    public void caseAPrintSimpleStmt(APrintSimpleStmt node) {
        // known: expression is an int
        node.getExp().apply(this);
        result =
                new ESEQ(new Code("\t\t;;print " + node.getExp().toString()),
                        frame.externalCall("printInt", new ExpList(result, null)));
    }

    @Override
    public void caseAAssignSimpleStmt(AAssignSimpleStmt node) {
        String id = node.getId().getText();
        Symbol sym = curscope.lookup(id);
        node.getExp().apply(this);
        // can assume sym not null, is a variable, and types match
        // TODO: set result to the ESEQ to assign the value
        System.out.println(id + " HERE " + node.getExp());
        result = new ESEQ(
                new SEQ(
                        new Code(";; " + node.getId().getText() + " " + node.getEqual() + " " + node.getExp()),
                        new MOVE(
                                frame.access(sym),
                                new CONST(1)
                        )
                ), new CONST(0));
    }

    @Override
    public void caseAAndAndExp(AAndAndExp node) {
        // TODO: write - see addition and subtraction below
        node.getLeft().apply(this);
        ToTree rt = new ToTree(curFile, frame, curclass, curscope);
        node.getRight().apply(rt);
        result = new BINOP(BINOP.AND, result, rt.getResult());
        // This method is apparently not tested, not required
    }

    @Override
    public void caseANotBoolExp(ANotBoolExp node) {
        // XOR used to compute not (since no negation operator)
        node.getBoolExp().apply(this);
        result = new BINOP(BINOP.XOR, new CONST(1), result);
    }

    @Override
    public void caseACompareComparison(ACompareComparison node) {
        // TODO: write; see notes and textbook for the need to return 0 if comparison
        //       is false, 1 if true
        ToTree test_visitor = new ToTree(curFile, frame, curclass, curscope);
        node.getLeft().apply(test_visitor);
        ToTree right_visitor = new ToTree(curFile, frame, curclass, curscope);
        node.getRight().apply(right_visitor);
        Temp t2 = new Temp();
        Label L1 = new Label();
        Label L2 = new Label();
        result = new ESEQ(
                new SEQ(
                        new MOVE(
                                new TEMP(t2),
                                new CONST(0)
                        ),
                        new SEQ(
                                new CJUMP(CJUMP.LT, test_visitor.getResult(), right_visitor.getResult(),
                                        L1, L2),
                                new SEQ(
                                        new LABEL(L1),
                                        new SEQ(
                                                new MOVE(new TEMP(t2), new CONST(1)),
                                                new LABEL(L2))
                                )
                        )
                ), new TEMP(t2)
        );
    }

    @Override
    public void caseAAddArithExp(AAddArithExp node) {
        // Implementation provided as an example.  You can change this if you like.
        node.getLeft().apply(this);
        ToTree rt = new ToTree(curFile, frame, curclass, curscope);
        node.getRight().apply(rt);
        result = new BINOP(BINOP.PLUS, result, rt.getResult());
    }

    @Override
    public void caseASubtArithExp(ASubtArithExp node) {
        node.getLeft().apply(this);
        ToTree rt = new ToTree(curFile, frame, curclass, curscope);
        node.getRight().apply(rt);
        result = new BINOP(BINOP.MINUS, result, rt.getResult());
    }

    @Override
    public void caseATimesTerm(ATimesTerm node) {
        node.getLeft().apply(this);
        ToTree rt = new ToTree(curFile, frame, curclass, curscope);
        node.getRight().apply(rt);
        result = new BINOP(BINOP.MUL, result, rt.getResult());
    }

    @Override
    public void caseAArrayFactor(AArrayFactor node) {
        // TODO: write; see book for hints
    }

    @Override
    public void caseACallFactor(ACallFactor node) {
        node.getFactor().apply(this);
        assert lastClassType != null;
        String method = node.getId().getText();
        ToTreeList ttl = new ToTreeList(curFile, frame, curclass, curscope);
        node.getExpList().apply(ttl);
        result = frame.methodCall(lastClassType, method,
                new ExpList(result, ttl.getResults()));
    }

    @Override
    public void caseANumFactor(ANumFactor node) {
        String nums = node.getNumber().getText();
        int val = -9999;
        try {
            val = Integer.parseInt(nums);
        } catch (NumberFormatException e) {
            System.err.println("Illegal number in code: " + nums);
        }
        // TODO: write code to set result to a constant capturing the value
        result = new CONST(val);
    }

    @Override
    public void caseATrueFactor(ATrueFactor node) {
        result = new CONST(1);
    }

    @Override
    public void caseAFalseFactor(AFalseFactor node) {
        result = new CONST(0);
    }

    @Override
    public void caseAIdFactor(AIdFactor node) {
        String id = node.getId().getText();
        // TODO: write; will call frame.access to get the code to reference the data
        result = frame.access(curscope.lookup(id));
    }

    @Override
    public void caseAThisFactor(AThisFactor node) {
        lastClassType = curclass;
        result = frame.getThis();
    }

    @Override
    public void caseANewarrayFactor(ANewarrayFactor node) {
        node.getExp().apply(this);
        Exp size = result;
        Temp len = new Temp();
        Temp addr = new Temp();
        Label init_top = new Label();
        Label init_bot = new Label();
        Label init_cont = new Label();
        result =
                new ESEQ(new SEQ(new Code("\t\t;;new int [" + node.getExp() + "]"),
                        new MOVE(new TEMP(len), size),
                        new MOVE(new TEMP(addr),
                                frame.externalCall(
                                        "malloc",
                                        new ExpList(new BINOP(BINOP.MUL,
                                                new BINOP(BINOP.PLUS,
                                                        new TEMP(len),
                                                        new CONST(1)),
                                                new CONST(4)),
                                                null))),
                        new MOVE(new MEM(new BINOP(BINOP.PLUS,
                                new TEMP(addr),
                                new CONST(-4))),
                                new TEMP(len)),
                        new LABEL(init_top),
                        new MOVE(new TEMP(len),
                                new BINOP(BINOP.PLUS, new TEMP(len),
                                        new CONST(-1))),
                        new CJUMP(CJUMP.LE, new TEMP(len), new CONST(0),
                                init_bot, init_cont),
                        new LABEL(init_cont),
                        new MOVE(new MEM(new BINOP(BINOP.MUL,
                                new TEMP(addr),
                                new BINOP(BINOP.MUL,
                                        new TEMP(len),
                                        new CONST(4)))),
                                new CONST(0)),
                        new JUMP(init_top),
                        new Code("\t\t;;end new int [" + node.getExp() + "]"),
                        new LABEL(init_bot)),
                        new TEMP(addr));
    }

    @Override
    public void caseANewobjFactor(ANewobjFactor node) {
        // TODO: write - will determine number of words to malloc (with a minimum of
        //       one word), and set result to an ESEQ that allocates the space and then
        //       returns the address as the result of the expression. Also sets
        //       lastClassType to the class being processed in the new expression.
        Temp t0 = new Temp();
        Temp t1 = new Temp();
        result = new ESEQ(
                new SEQ(
                        new Code("\t\t;;new " + node.getId().getText() + "()"),
                        new SEQ(
                                new MOVE(
                                        new TEMP(t0),
                                        new CONST(WORD_SIZE)
                                ),
                                new MOVE(
                                        new TEMP(t1),
                                        frame.externalCall("malloc",
                                                new ExpList(new TEMP(t0), null))
                                )
                        )
                ), new TEMP(t1));
        lastClassType = ClassType.instance(curclass.getName()); //Get the last class type
    }

    @Override
    public void caseAEmptyExpList(AEmptyExpList node) {
        throw new Error("This method should not be called.");
    }

    @Override
    public void caseAExpsExpList(AExpsExpList node) {
        throw new Error("This method should not be called.");
    }

    @Override
    public void caseAEmptyExpRest(AEmptyExpRest node) {
        throw new Error("This method should not be called.");
    }

    @Override
    public void caseAExpsExpRest(AExpsExpRest node) {
        throw new Error("This method should not be called.");
    }
}
