// VoidType.java: singleton for void types
//      Void isn't really a type in Java (unlike C++!), but this class is
//      useful as a placeholder for things with no return type.
//      Note this class is *not* related to StaticVoidType (even though
//      it probably should be).

package symbol;

public class VoidType extends Type {
  static protected VoidType _instance;

  protected VoidType() {
  }

  public static VoidType instance() {
    if (_instance == null)
      _instance = new VoidType();
    return _instance;
  }

  public String toString() {
    return "void";
  }
}
