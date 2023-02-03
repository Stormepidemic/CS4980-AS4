// Scope.java: collection of symbols which share a scope

package symbol;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;

public class Scope {
  protected Map<String, Symbol> symbols = new TreeMap<String, Symbol>();
  protected int numVariables;  // how many variables declared in scope
  // not number of parameters,
  // just locals or class variables
  protected Scope parent;      // scope containing this scope
  protected String owner;      // object "owning" this scope (if applicable)

  public Scope(Scope p, String o) {
    parent = p;
    owner = o;
  }

  public Scope(Scope p) {
    this(p, null);
  }

  public Scope getParent() {
    return parent;
  }

  public int size() {
    return symbols.size();
  }

  public String getOwner() {
    return owner;
  }

  public void add(Symbol s) {
    assert s.getScope() == this;
    assert !symbols.containsKey(s.getId());
    symbols.put(s.getId(), s);
    if (s.isLocalVariable() || s.isClassVariable())
      ++numVariables;
  }

  public Collection<Symbol> allSymbols() { return symbols.values(); }

  public int getNumVariables() {
    return numVariables;
  }

  // is name at *this* scope (as opposed to in parent scopes)
  public boolean contains(String name) {
    return symbols.containsKey(name);
  }

  // is name declared here or an any parent scope?
  public boolean declares(String name) {
    if (contains(name))
      return true;
    else
      return parent != null && parent.declares(name);
  }

  // find entry for name
  public Symbol lookup(String name) {
    Symbol entryobj = symbols.get(name);
    if (entryobj != null)
      return entryobj;
    else if (parent == null)
      return null;
    else
      return parent.lookup(name);
  }

  public String toString() {
    String res = "\n";
    for(Symbol sym : symbols.values()) {
      res += sym.toString() + "\n";
    }
    return res;
  }

  public Iterator<Symbol> iterator() {
    return symbols.values().iterator();
  }
}
