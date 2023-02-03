// BoolType.java: singleton for boolean types

package symbol;

public class BoolType extends Type {
  static protected BoolType _instance;

  protected BoolType() {
  }

  public static BoolType instance() {
    if (_instance == null)
      _instance = new BoolType();
    return _instance;
  }

  public String toString() {
    return "boolean";
  }
}
