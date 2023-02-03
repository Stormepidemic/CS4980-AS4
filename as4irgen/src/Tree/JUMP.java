package Tree;

// import Temp.Temp;
//import Temp.Label;

import Temp.Label;
import Temp.LabelList;

public class JUMP extends Stm {
  protected Exp exp;
  protected LabelList targets;

  public JUMP(Exp e, LabelList t) {
    exp = e;
    targets = t;
  }

  public JUMP(Label target) {
    this(new NAME(target), new LabelList(target, null));
  }

  public Exp getExp() {
    return exp;
  }

  public LabelList getTargets() {
    return targets;
  }

  public ExpList kids() {
    return new ExpList(exp, null);
  }

  public Stm build(ExpList kids) {
    return new JUMP(kids.head, targets);
  }
}

