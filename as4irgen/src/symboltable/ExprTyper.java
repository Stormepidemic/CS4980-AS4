//
// ExprTyper.java: determines expression types, reporting errors if
//      expression is ill-formed.
//      Precondition: all variables have been declared in current scope
//                    (and given types).
//

package symboltable;

import node.*;
import symbol.*;

public class ExprTyper extends TypeAnalysisAdapter {
  protected ClassType curclass;
  protected Type resultType;

  public ExprTyper(String file, ClassType clas, Scope sc) {
    super(file);
    curclass = clas;
    curscope = sc;
  }

  public ExprTyper(ExprTyper parent) {
    this(parent.curFile, parent.curclass, parent.curscope);
  }

  public Type getResultType() {
    return resultType;
  }

  //
  // methods that aren't legal to process (since we're handling just exprs)
  //
  @Override
  public void caseStart(Start node) {
    assert false;
  }

  @Override
  public void caseAProgram(AProgram node) {
    assert false;
  }

  @Override
  public void caseAMainClass(AMainClass node) {
    assert false;
  }

  @Override
  public void caseAMainDef(AMainDef node) {
    assert false;
  }

  @Override
  public void caseABaseclassClassDecl(ABaseclassClassDecl node) {
    assert false;
  }

  @Override
  public void caseAClassVarDecl(AClassVarDecl node) {
    assert false;
  }

  @Override
  public void caseALocalVarDecl(ALocalVarDecl node) {
    assert false;
  }

  @Override
  public void caseAMethodDecl(AMethodDecl node) {
    assert false;
  }

  @Override
  public void caseAMethodBody(AMethodBody node) {
    assert false;
  }

  @Override
  public void caseAEmptyFormalList(AEmptyFormalList node) {
    assert false;
  }

  @Override
  public void caseANonemptyFormalList(ANonemptyFormalList node) {
    assert false;
  }

  @Override
  public void caseAEmptyFormalRest(AEmptyFormalRest node) {
    assert false;
  }

  @Override
  public void caseANonemptyFormalRest(ANonemptyFormalRest node) {
    assert false;
  }

  @Override
  public void caseAArrayType(AArrayType node) {
    assert false;
  }

  @Override
  public void caseABoolType(ABoolType node) {
    assert false;
  }

  @Override
  public void caseAIntType(AIntType node) {
    assert false;
  }

  @Override
  public void caseAClassType(AClassType node) {
    assert false;
  }

  @Override
  public void caseAIfoneStatement(AIfoneStatement node) {
    assert false;
  }

  @Override
  public void caseAIfStatement(AIfStatement node) {
    assert false;
  }

  @Override
  public void caseAWhileStatement(AWhileStatement node) {
    assert false;
  }

  @Override
  public void caseASimpleStatement(ASimpleStatement node) {
    assert false;
  }

  @Override
  public void caseAPrintSimpleStmt(APrintSimpleStmt node) {
    assert false;
  }

  @Override
  public void caseAAssignSimpleStmt(AAssignSimpleStmt node) {
    assert false;
  }

  @Override
  public void caseAArraySimpleStmt(AArraySimpleStmt node) {
    assert false;
  }

  @Override
  public void caseANestedSimpleStmt(ANestedSimpleStmt node) {
    assert false;
  }

  @Override
  public void caseASansTrailerStmtAllPaired(ASansTrailerStmtAllPaired node) {
    assert false;
  }

  @Override
  public void caseAWhileStmtAllPaired(AWhileStmtAllPaired node) {
    assert false;
  }

  @Override
  public void caseAIfStmtAllPaired(AIfStmtAllPaired node) {
    assert false;
  }

  protected void expectType(Type targetType) {
    expectType(resultType, targetType);
  }

  @Override
  public void caseAAndAndExp(AAndAndExp node) {
    node.getLeft().apply(this);
    expectType(BoolType.instance());
    node.getAnd().apply(this);
    node.getRight().apply(this);
    expectType(BoolType.instance());
  }

  @Override
  public void caseANotBoolExp(ANotBoolExp node) {
    node.getBang().apply(this);
    node.getBoolExp().apply(this);
    expectType(BoolType.instance());
  }

  @Override
  public void caseACompareComparison(ACompareComparison node) {
    node.getLeft().apply(this);
    expectType(IntType.instance());
    node.getLess().apply(this);
    node.getRight().apply(this);
    expectType(IntType.instance());
    resultType = BoolType.instance();
  }

  @Override
  public void caseAAddArithExp(AAddArithExp node) {
    node.getLeft().apply(this);
    expectType(IntType.instance());
    node.getPlus().apply(this);
    node.getRight().apply(this);
    expectType(IntType.instance());
    // this leaves the result type as int
  }

  @Override
  public void caseASubtArithExp(ASubtArithExp node) {
    node.getLeft().apply(this);
    expectType(IntType.instance());
    node.getMinus().apply(this);
    node.getRight().apply(this);
    expectType(IntType.instance());
    // this leaves the result type as int
  }

  @Override
  public void caseATimesTerm(ATimesTerm node) {
    node.getLeft().apply(this);
    expectType(IntType.instance());
    node.getStar().apply(this);
    node.getRight().apply(this);
    expectType(IntType.instance());
    // this leaves the result type as int
  }

  @Override
  public void caseAArrayFactor(AArrayFactor node) {
    node.getFactor().apply(this);
    expectType(IntArrayType.instance());
    node.getLbracket().apply(this);
    node.getIndex().apply(this);
    expectType(IntType.instance());
    node.getRbracket().apply(this);
    // this leaves the result type as int
  }

  @Override
  public void caseACallFactor(ACallFactor node) {
    node.getFactor().apply(this);
    if (!resultType.isClass()) {
      reportError("Expecting class expression, got " + resultType);
      resultType = IntType.instance();
      return;
    }
    ClassType factorType = (ClassType) resultType;
    Scope scope_for_call = factorType.getChildScope();

    node.getDot().apply(this);
    node.getId().apply(this);
    String id = node.getId().getText();
    Symbol sym = scope_for_call.lookup(id);
    if (sym == null) {
      reportError("Unknown method name: " + id);
      resultType = IntType.instance();
      return;
    }
    if (!sym.isMethod()) {
      reportError("Not a method: " + id);
      resultType = IntType.instance();
      return;
    }

    MethodType mtype = (MethodType) sym.getType();
    node.getLparen().apply(this);
    // note: use *current* scope, not scope for call, because still
    //       parsing actual parameters
    ParamListTyper listtyper
      = new ParamListTyper(curFile, factorType, curscope,
      mtype.getParameters().iterator());
    node.getExpList().apply(listtyper);
    node.getRparen().apply(this);
    resultType = mtype.getReturnType();
  }

  @Override
  public void caseANumFactor(ANumFactor node) {
    node.getNumber().apply(this);
    resultType = IntType.instance();
  }

  @Override
  public void caseATrueFactor(ATrueFactor node) {
    node.getTrue().apply(this);
    resultType = BoolType.instance();
  }

  @Override
  public void caseAFalseFactor(AFalseFactor node) {
    node.getFalse().apply(this);
    resultType = BoolType.instance();
  }

  @Override
  public void caseAIdFactor(AIdFactor node) {
    node.getId().apply(this);
    String id = node.getId().getText();
    Symbol sym = curscope.lookup(id);
    if (sym == null) {
      reportError("Unknown identifier: " + id);
      resultType = IntType.instance();
    } else if (!sym.isVariable()) {
      reportError("Not a variable: " + id);
      resultType = IntType.instance();
    } else
      resultType = sym.getType();
  }

  @Override
  public void caseAThisFactor(AThisFactor node) {
    node.getThis().apply(this);
    resultType = curclass;
  }

  @Override
  public void caseANewarrayFactor(ANewarrayFactor node) {
    node.getNew().apply(this);
    node.getInt().apply(this);
    node.getLbracket().apply(this);
    node.getExp().apply(this);
    expectType(IntType.instance());
    node.getRbracket().apply(this);
    resultType = IntArrayType.instance();
  }

  @Override
  public void caseANewobjFactor(ANewobjFactor node) {
    node.getNew().apply(this);
    node.getId().apply(this);
    String id = node.getId().getText();
    Symbol sym = curscope.lookup(id);
    if (sym == null) {
      reportError("Unknown type: " + id);
      resultType = curclass; // probably a bad guess, but allows catching
      //   further errors
    } else if (!sym.isClass()) {
      reportError("Not a class type: " + id);
      resultType = curclass; // probably a bad guess, but allows catching
      //   further errors
    } else
      resultType = sym.getType();
    node.getLparen().apply(this);
    node.getRparen().apply(this);
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
