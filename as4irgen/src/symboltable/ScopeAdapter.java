//
// ScopeAdapter.java: track scope as process tree
//      This takes care of tracking scope as we move between classes and
//        methods; derived classes should not overload any of the methods
//        in this file!
//      Precondition: globals already contains all symbols.
//

package symboltable;

import node.*;
import symbol.ClassType;
import symbol.MethodType;
import symbol.Symbol;

public abstract class ScopeAdapter extends TypeAnalysisAdapter {
  protected ClassType curclass;

  public ScopeAdapter(String file) {
    super(file);
  }

  @Override
  public final void inAMainClass(AMainClass node) {
    String id = node.getId().getText();
    Symbol typesym = curscope.lookup(id);
    assert typesym != null && typesym.isClass();
    curclass = (ClassType) typesym.getType();
    curscope = curclass.getChildScope();
    if (debug)
      System.out.println("Entering " + curclass.getName() + " scope");
  }

  @Override
  public final void outAMainClass(AMainClass node) {
    // go to global scope
    curscope = curscope.getParent();
    assert (curscope == globals);
  }

  @Override
  public final void inAMainDef(AMainDef node) {
    // look up main and use it as the scope
    Symbol main = curscope.lookup("main");
    assert main != null;
    assert main.isMethod();
    assert main.getType() != null;
    MethodType mtype = (MethodType) (main.getType());
    curscope = mtype.getChildScope();
  }

  @Override
  public final void outAMainDef(AMainDef node) {
    // go to scope of main class
    curscope = curscope.getParent();
  }

  @Override
  public final void inABaseclassClassDecl(ABaseclassClassDecl node) {
    String id = node.getId().getText();
    Symbol typesym = curscope.lookup(id);
    assert typesym != null && typesym.isClass();
    curclass = (ClassType) typesym.getType();
    curscope = curclass.getChildScope();
    if (debug)
      System.out.println("Entering " + curclass.getName() + " scope");
  }

  @Override
  public final void outABaseclassClassDecl(ABaseclassClassDecl node) {
    curscope = curscope.getParent();
  }

  @Override
  public void inAMethodDecl(AMethodDecl node) {
    String id = node.getId().getText();
    Symbol methsym = curscope.lookup(id);
    assert methsym != null && methsym.isMethod();
    MethodType mtype = (MethodType) methsym.getType();
    curscope = mtype.getChildScope();
  }

  @Override
  public final void outAMethodDecl(AMethodDecl node) {
    curscope = curscope.getParent();
  }
}
