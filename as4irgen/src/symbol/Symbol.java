// Symbol.java: an identifer with scope, location, and type
//      parameters, varaiables: track offset
//      methods: track bodies: store as object to avoid dependencies

package symbol;

public class Symbol implements Comparable {
  public static final int TYPEID = 0;
  public static final int METHODID = 1;
  public static final int CLASSVARID = 2;
  public static final int LOCALVARID = 3;
  public static final int PARAMID = 4;
  protected String id;
  protected Scope scope;
  protected Location sourceLocation;
  protected Type type;
  protected int offset;        // parameters, variables only
  protected Object methodBody;
  protected int klass;

  public Symbol(String i, int _klass, Location loc, Scope s, Type t) {
    id = i;
    klass = _klass;
    sourceLocation = loc;
    scope = s;
    type = t;
    offset = -99999;
  }

  public Symbol(String i, int _klass, Location loc, Scope s, Type t,
                int _offset) {
    id = i;
    klass = _klass;
    sourceLocation = loc;
    scope = s;
    type = t;
    offset = _offset;
  }

  public int getKlass() {
    return klass;
  }

  public boolean isClass() {
    return klass == TYPEID;
  }

  public boolean isMethod() {
    return klass == METHODID;
  }

  public boolean isVariable() {
    return klass == CLASSVARID || klass == LOCALVARID || klass == PARAMID;
  }

  public boolean isLocalVariable() {
    return klass == LOCALVARID;
  }

  public boolean isClassVariable() {
    return klass == CLASSVARID;
  }

  public boolean isParam() {
    return klass == PARAMID;
  }

  public Type getType() {
    return type;
  }

  public String getId() {
    return id;
  }

  public Location getSourceLocation() {
    return sourceLocation;
  }

  public Scope getScope() {
    return scope;
  }

  public int getOffset() {
    return offset;
  }

  public Object getMethodBody() {
    return methodBody;
  }

  public void setMethodBody(Object mb) {
    if (!isMethod())
      throw new Error("Setting method body for non-method ident");
    methodBody = mb;
  }

  public boolean less(Object o) {
    return compareTo(o) < 0;
  }

  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (!(o instanceof Symbol))
      return false;
    Symbol os = (Symbol) o;
    return id.equals(os.getId());
  }

  public int compareTo(Object o) {
    if (o == null)
      throw new NullPointerException();
    else if (!(o instanceof Symbol))
      throw new ClassCastException();
    Symbol os = (Symbol) o;
    return id.compareTo(os.getId());
  }

  public int hashCode() {
    return id.hashCode();
  }

  public String toString() {
    //System.out.println("Printing entry for " + id + ", type " + type);
    if (isVariable())
      return type.toString() + " " + id + " /*offset " + offset + "*/;";
    else if (isMethod()) {
      MethodType mtype = (MethodType) type;
      String res = mtype.returnType.toString() + " " + id + "(" +
        mtype.getParameters().toString() + ")";
      res += "\n[params and locals:";
      res += mtype.getChildScope();
      res += "]";
      return res;
    } else {
      assert isClass();
      String res = "class " + id + "\n{";
      ClassType ctype = (ClassType) type;
      res += ctype.getChildScope();
      res += "}";
      return res;
    }
  }
}
