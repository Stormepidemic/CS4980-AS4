package Tree;

public class ESEQ extends Exp {
  protected Stm stm;
  protected Exp exp;

  public ESEQ(Stm s, Exp e) {
    stm = s;
    exp = e;
  }

  public Stm getStm() {
    return stm;
  }

  public Exp getExp() {
    return exp;
  }

  public ExpList kids() {
    throw new Error("kids() not applicable to ESEQ");
  }

  public Exp build(ExpList kids) {
    throw new Error("build() not applicable to ESEQ");
  }
}

