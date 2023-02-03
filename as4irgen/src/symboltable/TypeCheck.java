//
// TypeCheck.java: typecheck MiniJava programs
//      Precondition: globals already contains all symbols, just
//      need to check they're valid.
//

package symboltable;

import lexer.Lexer;
import node.*;
import parser.Parser;
import symbol.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PushbackReader;

public class TypeCheck extends ScopeAdapter {
  protected Type methodReturnType; // used to typecheck the return type

  public TypeCheck(String file) {
    super(file);
  }

  public static void main(String[] args) {
    boolean debug = false;
    boolean dump = false;

    if (args.length < 1) {
      System.out.println("Usage: java TypeCheck <filename>");
      System.exit(1);
    }
    try {
      String file = args[0];
      if (args.length > 1) {
        if (args[0].equals("-d"))
          debug = true;
        else if (args[0].equals("-s"))
          dump = true;
        else if (args[0].equals("-ds") || args[0].equals("-sd"))
          debug = dump = true;
        file = args[1];
      }

      // create lexer
      Lexer lexer = new Lexer(new PushbackReader
        (new BufferedReader(new FileReader(file)),
          1024));

      // parser program
      Parser parser = new Parser(lexer);

      Start ast = parser.parse();

      // identify all types
      if (debug)
        System.out.println("Declaring user-defined types.");
      DeclTypes dt_visitor = new DeclTypes(file);
      ast.apply(dt_visitor);

      // declare all symbols
      if (debug)
        System.out.println("Declaring all symbols.");
      DeclSyms ds_visitor = new DeclSyms(file);
      ast.apply(ds_visitor);

      // TypeCheck nodes
      if (debug)
        System.out.println("Checking all expressions.");
      TypeCheck tc_visitor = new TypeCheck(file);
      if (debug)
        tc_visitor.setDebug();
      ast.apply(tc_visitor);

      if (!errorFound && dump) {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Symbols:");
        System.out.println(ds_visitor);
      }
    } catch (Exception e) {
      if (debug)
        e.printStackTrace();
      else
        System.out.println(e);
    }
  }

  @Override
  public void inAMethodDecl(AMethodDecl node) {
    super.inAMethodDecl(node);
    String id = node.getId().getText();
    Symbol sym = curscope.lookup(id);
    assert sym != null;
    assert sym.isMethod();
    MethodType mtype = (MethodType) sym.getType();
    methodReturnType = mtype.getReturnType();
  }

  // would like to remove this, but this would require changing the grammar
  //   so the return is in a separate production
  @Override
  public void caseAMethodBody(AMethodBody node) {
    node.getLbrace().apply(this);
    {
      Object temp[] = node.getLocalVarDecl().toArray();
      for (int i = 0; i < temp.length; i++)
        ((PLocalVarDecl) temp[i]).apply(this);
    }
    {
      Object temp[] = node.getStatement().toArray();
      for (int i = 0; i < temp.length; i++)
        ((PStatement) temp[i]).apply(this);
    }
    node.getReturn().apply(this);
    ExprTyper et = new ExprTyper(curFile, curclass, curscope);
    node.getExp().apply(et);
    expectType(et.getResultType(), methodReturnType);
    node.getSemi().apply(this);
    node.getRbrace().apply(this);
  }

  @Override
  public void caseAIfoneStatement(AIfoneStatement node) {
    node.getIf().apply(this);
    node.getLparen().apply(this);
    ExprTyper et = new ExprTyper(curFile, curclass, curscope);
    node.getExp().apply(et);
    expectType(et.getResultType(), BoolType.instance());
    node.getRparen().apply(this);
    node.getStatement().apply(this);
  }

  @Override
  public void caseAIfStatement(AIfStatement node) {
    node.getIf().apply(this);
    node.getLparen().apply(this);
    ExprTyper et = new ExprTyper(curFile, curclass, curscope);
    node.getExp().apply(et);
    expectType(et.getResultType(), BoolType.instance());
    node.getRparen().apply(this);
    node.getTruepart().apply(this);
    node.getElse().apply(this);
    node.getFalsepart().apply(this);
  }

  @Override
  public void caseAWhileStatement(AWhileStatement node) {
    node.getWhile().apply(this);
    node.getLparen().apply(this);
    ExprTyper et = new ExprTyper(curFile, curclass, curscope);
    node.getExp().apply(et);
    expectType(et.getResultType(), BoolType.instance());
    node.getRparen().apply(this);
    node.getStatement().apply(this);
  }

  @Override
  public void caseAPrintSimpleStmt(APrintSimpleStmt node) {
    node.getPrintln().apply(this);
    node.getLparen().apply(this);
    ExprTyper et = new ExprTyper(curFile, curclass, curscope);
    node.getExp().apply(et);
    expectType(et.getResultType(), IntType.instance());
    node.getRparen().apply(this);
    node.getSemi().apply(this);
  }

  @Override
  public void caseAAssignSimpleStmt(AAssignSimpleStmt node) {
    node.getId().apply(this);
    String id = node.getId().getText();
    Symbol sym = curscope.lookup(id);
    if (sym == null)
      reportError("Unknown identifier: " + id);
    else if (!sym.isVariable())
      reportError("Not a variable: " + id);
    else {
      node.getEqual().apply(this);
      ExprTyper et = new ExprTyper(curFile, curclass, curscope);
      node.getExp().apply(et);
      expectType(et.getResultType(), sym.getType());
      node.getSemi().apply(this);
    }
  }

  @Override
  public void caseAArraySimpleStmt(AArraySimpleStmt node) {
    node.getId().apply(this);
    String id = node.getId().getText();
    Symbol sym = curscope.lookup(id);
    if (sym == null)
      reportError("Unknown identifier: " + id);
    else if (!sym.isVariable())
      reportError("Not a variable: " + id);
    else {
      expectType(sym.getType(), IntArrayType.instance());
      node.getLbracket().apply(this);
      ExprTyper et = new ExprTyper(curFile, curclass, curscope);
      node.getIndex().apply(et);
      expectType(et.getResultType(), IntType.instance());
      node.getRbracket().apply(this);
      node.getEqual().apply(this);
      node.getExp().apply(et);
      expectType(et.getResultType(), IntType.instance());
      node.getSemi().apply(this);
    }
  }

  @Override
  public void caseAWhileStmtAllPaired(AWhileStmtAllPaired node) {
    node.getWhile().apply(this);
    node.getLparen().apply(this);
    ExprTyper et = new ExprTyper(curFile, curclass, curscope);
    node.getExp().apply(et);
    expectType(et.getResultType(), BoolType.instance());
    node.getRparen().apply(this);
    node.getStmtAllPaired().apply(this);
  }

  @Override
  public void caseAIfStmtAllPaired(AIfStmtAllPaired node) {
    node.getIf().apply(this);
    node.getLparen().apply(this);
    ExprTyper et = new ExprTyper(curFile, curclass, curscope);
    node.getExp().apply(et);
    expectType(et.getResultType(), BoolType.instance());
    node.getRparen().apply(this);
    node.getTruepart().apply(this);
    node.getElse().apply(this);
    node.getFalsepart().apply(this);
  }

  @Override
  public void caseAExp(AExp node) {
    assert false;
  }

  @Override
  public void caseASimpleAndExp(ASimpleAndExp node) {
    assert false;
  }

  @Override
  public void caseAAndAndExp(AAndAndExp node) {
    assert false;
  }

  @Override
  public void caseASimpleBoolExp(ASimpleBoolExp node) {
    assert false;
  }

  @Override
  public void caseANotBoolExp(ANotBoolExp node) {
    assert false;
  }

  @Override
  public void caseASimpleComparison(ASimpleComparison node) {
    assert false;
  }

  @Override
  public void caseACompareComparison(ACompareComparison node) {
    assert false;
  }

  @Override
  public void caseASimpleArithExp(ASimpleArithExp node) {
    assert false;
  }

  @Override
  public void caseAAddArithExp(AAddArithExp node) {
    assert false;
  }

  @Override
  public void caseASubtArithExp(ASubtArithExp node) {
    assert false;
  }

  @Override
  public void caseASimpleTerm(ASimpleTerm node) {
    assert false;
  }

  @Override
  public void caseATimesTerm(ATimesTerm node) {
    assert false;
  }

  @Override
  public void caseAArrayFactor(AArrayFactor node) {
    assert false;
  }

  @Override
  public void caseACallFactor(ACallFactor node) {
    assert false;
  }

  @Override
  public void caseANumFactor(ANumFactor node) {
    assert false;
  }

  @Override
  public void caseATrueFactor(ATrueFactor node) {
    assert false;
  }

  @Override
  public void caseAFalseFactor(AFalseFactor node) {
    assert false;
  }

  @Override
  public void caseAIdFactor(AIdFactor node) {
    assert false;
  }

  @Override
  public void caseAThisFactor(AThisFactor node) {
    assert false;
  }

  @Override
  public void caseANewarrayFactor(ANewarrayFactor node) {
    assert false;
  }

  @Override
  public void caseANewobjFactor(ANewobjFactor node) {
    assert false;
  }

  @Override
  public void caseANestedFactor(ANestedFactor node) {
    assert false;
  }

  @Override
  public void caseAEmptyExpList(AEmptyExpList node) {
    assert false;
  }

  @Override
  public void caseAExpsExpList(AExpsExpList node) {
    assert false;
  }

  @Override
  public void caseAEmptyExpRest(AEmptyExpRest node) {
    assert false;
  }

  @Override
  public void caseAExpsExpRest(AExpsExpRest node) {
    assert false;
  }
}
