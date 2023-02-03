package Tree;

public class MEM extends Exp {
  protected Exp exp;

  public MEM(Exp e) {
    exp = e;
  }

  public Exp getExp() {
    return exp;
  }

  public ExpList kids() {
    return new ExpList(exp, null);
  }

  public Exp build(ExpList kids) {
    return new MEM(kids.head);
  }
}

