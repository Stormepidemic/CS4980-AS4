package Tree;

public class StmList {
  protected Stm head;
  protected StmList tail;

  public Stm getHead() {
    return head;
  }

  public StmList getTail() {
    return tail;
  }

  public Stm setHead(Stm h) {
    head = h;
    return head;
  }

  public StmList setTail(StmList t) {
    tail = t;
    return tail;
  }

  public StmList(Stm h, StmList t) {
    head = h;
    tail = t;
  }
}



