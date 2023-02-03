// Location.java: store identifier location as line + column

package symbol;

public class Location {
  protected int line, column;

  public Location(int l, int c) {
    line = l;
    column = c;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }
}
