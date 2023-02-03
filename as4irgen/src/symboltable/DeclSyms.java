//
// DeclSyms.java: declare all symbols in MiniJava programs,
//      checking for duplicated items
//

/* Warning: must invoke *after* DeclTypes */

package symboltable;

import node.*;
import symbol.*;

public class DeclSyms extends TypeAnalysisAdapter {
  protected ClassType curclass;
  protected Type lastSimpleType; // last type encountered
  protected ParameterList curparams;
  protected int num_local_vars = 0;
  protected int num_class_vars = 0;
  protected int num_params = 0;

  public DeclSyms(String file) {
    super(file);
    assert globals.size() > 0; // must have declared at least one type
  }

  @Override
  public void inAMainClass(AMainClass node) {
    String id = node.getId().getText();
    Symbol typesym = curscope.lookup(id);
    assert typesym != null && typesym.isClass();
    curclass = (ClassType) typesym.getType();
    curscope = curclass.getChildScope();
    // define main as a function, but ignore the parameters since we can't
    //  represent them (no String type) and we don't call main anyways
    MethodType main_type = new MethodType("main", curscope,
      StaticVoidType.instance());
    Symbol main_name = declare("main", Symbol.METHODID, main_type);
    curscope = main_type.getChildScope();
    // will then visit method body
  }

  @Override
  public void outAMainClass(AMainClass node) {
    // go to scope of main class
    curscope = curscope.getParent();
    // go to global scope
    curscope = curscope.getParent();
    assert (curscope == globals);
  }

  @Override
  public void inABaseclassClassDecl(ABaseclassClassDecl node) {
    String id = node.getId().getText();
    Symbol typesym = curscope.lookup(id);
    assert typesym != null && typesym.isClass();
    curclass = (ClassType) typesym.getType();
    curscope = curclass.getChildScope();
    num_class_vars = 0;
    // will then visit the class to declare members, etc
  }

  @Override
  public void outABaseclassClassDecl(ABaseclassClassDecl node) {
    curscope = curscope.getParent();
  }

  @Override
  public void outAClassVarDecl(AClassVarDecl node) {
    String id = node.getId().getText();
    declareVar(id, Symbol.CLASSVARID, lastSimpleType, num_class_vars);
    ++num_class_vars;
  }

  @Override
  public void outALocalVarDecl(ALocalVarDecl node) {
    String id = node.getId().getText();
    declareVar(id, Symbol.LOCALVARID, lastSimpleType, num_local_vars);
    ++num_local_vars;
  }

  @Override
  public void caseAMethodDecl(AMethodDecl node) {
    node.getPublic().apply(this);
    node.getType().apply(this);
    node.getId().apply(this);
    String id = node.getId().getText();
    MethodType mtype = new MethodType(id, curscope, lastSimpleType);
    declare(id, Symbol.METHODID, mtype);
    curscope = mtype.getChildScope();
    curparams = mtype.getParameters();
    node.getLparen().apply(this);
    num_params = 0;       // reset for parameter list
    node.getFormalList().apply(this);
    node.getRparen().apply(this);
    curparams = null;         // feeble attempt at catching errors
    num_local_vars = 0;       // reset for method body
    node.getMethodBody().apply(this);
    curscope = curscope.getParent();
  }

  // utility for adding parameters in different contexts
  protected void addParameter(String id) {
    Symbol par = declareVar(id, Symbol.PARAMID, lastSimpleType,
      num_params);
    ++num_params;
    curparams.add(par);
  }

  @Override
  public void caseANonemptyFormalList(ANonemptyFormalList node) {
    node.getType().apply(this);
    node.getId().apply(this);
    addParameter(node.getId().getText());
    node.getFormalRest().apply(this);
  }

  @Override
  public void caseANonemptyFormalRest(ANonemptyFormalRest node) {
    node.getComma().apply(this);
    node.getType().apply(this);
    node.getId().apply(this);
    addParameter(node.getId().getText());
    node.getFormalRest().apply(this);
  }

  @Override
  public void outAArrayType(AArrayType node) {
    lastSimpleType = IntArrayType.instance();
  }

  @Override
  public void outABoolType(ABoolType node) {
    lastSimpleType = BoolType.instance();
  }

  @Override
  public void outAIntType(AIntType node) {
    lastSimpleType = IntType.instance();
  }

  @Override
  public void outAClassType(AClassType node) {
    String id = node.getId().getText();
    Symbol typesym = curscope.lookup(id);
    if (!typesym.isClass())
      reportError("Expecting a type identifier, got " + id);
    lastSimpleType = typesym.getType();
  }
}
