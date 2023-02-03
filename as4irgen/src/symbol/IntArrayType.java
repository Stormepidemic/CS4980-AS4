// IntArrayType.java: singleton for integer array types

package symbol;

public class IntArrayType extends Type {
  static protected IntArrayType instance;

  protected IntArrayType() {
  }

  public static IntArrayType instance() {
    if (instance == null)
      instance = new IntArrayType();
    return instance;
  }

  public String toString() {
    return "int[]";
  }
}
