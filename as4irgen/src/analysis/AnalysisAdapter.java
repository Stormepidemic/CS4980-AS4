/* This file was generated by SableCC (http://www.sablecc.org/). */

package analysis;

import java.util.*;
import node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAProgram(AProgram node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMainClass(AMainClass node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMainDef(AMainDef node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABaseclassClassDecl(ABaseclassClassDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAClassVarDecl(AClassVarDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALocalVarDecl(ALocalVarDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethodDecl(AMethodDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethodBody(AMethodBody node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEmptyFormalList(AEmptyFormalList node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANonemptyFormalList(ANonemptyFormalList node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEmptyFormalRest(AEmptyFormalRest node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANonemptyFormalRest(ANonemptyFormalRest node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayType(AArrayType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABoolType(ABoolType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntType(AIntType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAClassType(AClassType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfoneStatement(AIfoneStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileStatement(AWhileStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleStatement(ASimpleStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPrintSimpleStmt(APrintSimpleStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignSimpleStmt(AAssignSimpleStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArraySimpleStmt(AArraySimpleStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANestedSimpleStmt(ANestedSimpleStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASansTrailerStmtAllPaired(ASansTrailerStmtAllPaired node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileStmtAllPaired(AWhileStmtAllPaired node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfStmtAllPaired(AIfStmtAllPaired node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExp(AExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleAndExp(ASimpleAndExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndAndExp(AAndAndExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleComparison(ASimpleComparison node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACompareComparison(ACompareComparison node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleArithExp(ASimpleArithExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddArithExp(AAddArithExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASubtArithExp(ASubtArithExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleTerm(ASimpleTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATimesTerm(ATimesTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleBoolExp(ASimpleBoolExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotBoolExp(ANotBoolExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayFactor(AArrayFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallFactor(ACallFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumFactor(ANumFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATrueFactor(ATrueFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFalseFactor(AFalseFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdFactor(AIdFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAThisFactor(AThisFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANewarrayFactor(ANewarrayFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANewobjFactor(ANewobjFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANestedFactor(ANestedFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEmptyExpList(AEmptyExpList node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpsExpList(AExpsExpList node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEmptyExpRest(AEmptyExpRest node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpsExpRest(AExpsExpRest node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBoolean(TBoolean node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTClas(TClas node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMain(TMain node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNew(TNew node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPrintln(TPrintln node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPublic(TPublic node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStatic(TStatic node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTThis(TThis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVoid(TVoid node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLbracket(TLbracket node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRbracket(TRbracket node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSemi(TSemi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLparen(TLparen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRparen(TRparen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLbrace(TLbrace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRbrace(TRbrace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEqual(TEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDot(TDot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBang(TBang node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLess(TLess node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStar(TStar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNumber(TNumber node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhitespace(TWhitespace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLineComment(TLineComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSlashstarComment(TSlashstarComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
