//
// DeclTypes.java: identify and record all user-defined types
//

package symboltable;

import node.ABaseclassClassDecl;
import node.AMainClass;
import node.TId;
import symbol.ClassType;
import symbol.Symbol;

public class DeclTypes extends TypeAnalysisAdapter {
  ClassType curclass;

  public DeclTypes(String file) {
    super(file);
  }

  protected void addClass(TId idnode) {
    String id = idnode.getText();
    curclass = ClassType.declare(id, curscope);
    declare(id, Symbol.TYPEID, curclass);
  }

  @Override
  public void caseAMainClass(AMainClass node) {
    addClass(node.getId());
    // skip child parse trees: children cannot define types in MiniJava
  }

  @Override
  public void caseABaseclassClassDecl(ABaseclassClassDecl node) {
    addClass(node.getId());
    // skip child parse trees: children cannot define types in MiniJava
  }
}
