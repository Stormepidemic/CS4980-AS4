package Tree;

public class EXPS extends Stm {
  protected Exp exp;

  public EXPS(Exp e) {
    exp = e;
  }

  public Exp getExp() {
    return exp;
  }

  public ExpList kids() {
    return new ExpList(exp, null);
  }

  public Stm build(ExpList kids) {
    return new EXPS(kids.head);
  }
}
