package Tree;

public class CONST extends Exp {
  protected int value;

  public CONST(int v) {
    value = v;
  }

  public int getValue() {
    return value;
  }

  public ExpList kids() {
    return null;
  }

  public Exp build(ExpList kids) {
    return this;
  }
}

