// MethodType.java: type of a function/method
//      This is *not* a singleton because multiple functions can share
//      the same return type and parameter list without worries
//      (and there currently is no need to compare function types).

package symbol;

public class MethodType extends ScopeIntroducingType {
  protected Type returnType;
  protected ParameterList parameters = new ParameterList();

  public MethodType(String method_name, Scope parent, Type ret) {
    super(parent, method_name);
    returnType = ret;
  }

  public MethodType(Scope parent, Type ret) // deprecated
  {
    super(parent, null);
    returnType = ret;
  }

  public boolean isMethod() {
    return true;
  }

  public Type getReturnType() {
    return returnType;
  }

  public ParameterList getParameters() {
    return parameters;
  }

  public void setParameters(ParameterList new_params) {
    parameters = new_params;
  }
}
