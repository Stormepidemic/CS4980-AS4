// Type.java: abstract base class for all types
//      It is anticipated that all base classes from this will be singletons
//      (though in the case of user-defined types, the singletons are stored
//      in pools with accessors based on the type name)

package symbol;

public abstract class Type {
  public boolean isClass() {
    return false;
  }

  public boolean isMethod() {
    return false;
  }
}
