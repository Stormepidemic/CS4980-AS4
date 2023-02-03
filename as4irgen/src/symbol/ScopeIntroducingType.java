// ScopeIntroducingType.java: superclass for types which are associated
//      with identiers which introduce a scope

package symbol;

public abstract class ScopeIntroducingType extends Type {
  protected final Scope childScope;

  public ScopeIntroducingType(Scope parent, String owner) {
    childScope = new Scope(parent, owner);
  }

  public Scope getChildScope() {
    return childScope;
  }
}
