// IntType.java: singleton for integer types

package symbol;

public class IntType extends Type {
  static protected IntType _instance;

  protected IntType() {
  }

  public static IntType instance() {
    if (_instance == null)
      _instance = new IntType();
    return _instance;
  }

  public String toString() {
    return "int";
  }
}
