//
// ToTreeList.java: generates IR trees for expressions in parameter lists
//

import Tree.ExpList;
import node.AExpsExpList;
import node.AExpsExpRest;
import symbol.ClassType;
import symbol.Scope;
import symboltable.TypeAnalysisAdapter;

public class ToTreeList extends TypeAnalysisAdapter {
  protected ClassType curclass;
  protected Frame curframe;
  protected ExpList results = null;

  public ToTreeList(String file, Frame frame, ClassType clas, Scope sc) {
    super(file);
    curframe = frame;
    curclass = clas;
    curscope = sc;
  }

  public ExpList getResults() {
    return results;
  }

  public void caseAExpsExpList(AExpsExpList node) {
    ToTree et = new ToTree(curFile, curframe, curclass, curscope);
    node.getExp().apply(et);
    results = new ExpList(et.getResult(), results);
  }

  public void caseAExpsExpRest(AExpsExpRest node) {
    ToTree et = new ToTree(curFile, curframe, curclass, curscope);
    node.getExp().apply(et);
    results = new ExpList(et.getResult(), results);
  }
}
