package Tree;

public class CALL extends Exp {
  protected Exp func;
  protected ExpList args;

  public CALL(Exp f, ExpList a) {
    func = f;
    args = a;
  }

  public Exp getFunc() {
    return func;
  }

  public ExpList getArgs() {
    return args;
  }

  public ExpList kids() {
    return new ExpList(func, args);
  }

  public Exp build(ExpList kids) {
    return new CALL(kids.head, kids.tail);
  }
}

