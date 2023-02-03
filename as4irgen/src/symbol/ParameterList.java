// ParameterList.java: formal parameter list for a method

package symbol;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParameterList {
  protected List<Symbol> params = new LinkedList<Symbol>();

  public void add(Symbol new_param) {
    for(Symbol other_param : params) {
      assert !other_param.getId().equals(new_param.getId());
    }
    params.add(new_param);
  }

  public Iterator<Symbol> iterator() {
    return params.iterator();
  }

  public String toString() {
    String res = "";
    Iterator<Symbol> it = iterator();
    if (it.hasNext())
      res += it.next();
    while (it.hasNext())
      res += ", " + it.next();
    return res;
  }
}
