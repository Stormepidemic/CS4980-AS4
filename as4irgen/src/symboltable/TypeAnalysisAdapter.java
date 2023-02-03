//
// TypeAnalysisAdapter.java: top-level class for all type analysis
//

package symboltable;

import analysis.DepthFirstAdapter;
import node.Node;
import node.Token;
import symbol.Location;
import symbol.Scope;
import symbol.Symbol;
import symbol.Type;

public abstract class TypeAnalysisAdapter extends DepthFirstAdapter {
  static protected boolean errorFound = false;
  static protected String curFile = "";
  static protected int curline, curcol;

  static protected Scope globals = new Scope(null);
  protected Scope curscope = globals;
  protected boolean debug = false;

  public TypeAnalysisAdapter(String file) {
    curFile = file;
  }

  public void setDebug() {
    debug = true;
  }

  protected void reportError(String msg) {
    errorFound = true;
    System.out.println(curFile + ":" + curline + ", column " + curcol
      + ": " + msg);
  }

  protected void expectType(Type identifiedType, Type targetType) {
    assert identifiedType != null;
    assert targetType != null;
    if (identifiedType != targetType)
      reportError("Invalid expression type: expected " + targetType
        + ", got " + identifiedType);
  }

  @Override
  public void defaultCase(Node node) {
    if (node instanceof Token) {
      Token t = (Token) node;
      curline = t.getLine();
      curcol = t.getPos();
    }
  }

  protected Symbol declare(String name, int klass, Type type) {
    assert type != null;
    assert klass != Symbol.LOCALVARID && klass != Symbol.CLASSVARID
      && klass != Symbol.PARAMID;
    if (curscope.contains(name)) {
      reportError("Redefinition of " + name);
      return curscope.lookup(name);
    } else {
      Symbol result = new Symbol(name, klass, new Location(curline, curcol),
        curscope, type);
      curscope.add(result);
      return result;
    }
  }

  protected Symbol declareVar(String name, int klass, Type type, int offset) {
    assert type != null;
    assert klass == Symbol.LOCALVARID || klass == Symbol.CLASSVARID
      || klass == Symbol.PARAMID;
    if (curscope.contains(name)) {
      reportError("Redefinition of " + name);
      return curscope.lookup(name);
    } else {
      Symbol result = new Symbol(name, klass, new Location(curline, curcol),
        curscope, type, offset);
      curscope.add(result);
      return result;
    }
  }

  public String toString() {
    return globals.toString();
  }
}
