// Code: stuff to print as-is to output assembly file

package Tree;

public class Code extends Stm {
  protected String code;

  public Code(String c) {
    code = c;
  }

  public ExpList kids() {
    return null;
  }

  public Stm build(ExpList kids) {
    return this;
  }

  public String toString() {
    return code;
  }
}

