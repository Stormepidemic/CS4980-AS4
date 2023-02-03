// ClassType.java: singleton "pool" for class types

package symbol;

import java.util.Map;
import java.util.TreeMap;

public class ClassType extends ScopeIntroducingType {
  static protected Map<String, ClassType> pool = new TreeMap<String, ClassType>();
  protected String name;

  protected ClassType(String n, Scope parent) {
    super(parent, n);
    name = n;
  }

  public static boolean declared(String name) {
    ClassType found_item = pool.get(name);
    return found_item != null;
  }

  public static ClassType declare(String name, Scope parent) {
    assert parent != null;
    assert pool.get(name) == null;
    ClassType clas = new ClassType(name, parent);
    pool.put(name, clas);
    return clas;
  }

  public static ClassType instance(String name) {
    ClassType found_item = pool.get(name);
    return found_item;
  }

  public boolean isClass() {
    return true;
  }

  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }

  public int memberCount() {
    return childScope.getNumVariables();
  }
}
