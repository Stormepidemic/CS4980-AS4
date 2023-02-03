package Tree;

public class ExpList {
  protected Exp head;
  protected ExpList tail;

  public ExpList(Exp h, ExpList t) {
    head = h;
    tail = t;
  }

  public Exp getHead() {
    return head;
  }

  public ExpList getTail() {
    return tail;
  }
}



