package Tree;

import Temp.Label;

public class LABEL extends Stm {
  protected Label label;

  public LABEL(Label l) {
    label = l;
  }

  public Label getLabel() {
    return label;
  }

  public ExpList kids() {
    return null;
  }

  public Stm build(ExpList kids) {
    return this;
  }
}

