// StaticVoidType.java: singleton for static void types
//      Void isn't really a type in Java (unlike C++!), but this class is
//      useful as a placeholder for the return type for main() (which is
//      treated specially in MiniJava)

package symbol;

public class StaticVoidType extends Type {
  static protected StaticVoidType _instance;

  protected StaticVoidType() {
  }

  public static StaticVoidType instance() {
    if (_instance == null)
      _instance = new StaticVoidType();
    return _instance;
  }

  public String toString() {
    return "static void";
  }
}
