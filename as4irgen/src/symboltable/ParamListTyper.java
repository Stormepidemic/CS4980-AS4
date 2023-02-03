//
// ParamListTyper.java: determines expression types in a parameter list,
//      reporting errors
//      Precondition: all variables have been declared in current scope
//                    (and given types)
//

package symboltable;

import node.AEmptyExpList;
import node.AEmptyExpRest;
import node.AExpsExpList;
import node.AExpsExpRest;
import symbol.ClassType;
import symbol.Scope;
import symbol.Symbol;
import symbol.Type;

import java.util.Iterator;

public class ParamListTyper extends TypeAnalysisAdapter {
  protected ClassType curclass;
  protected Iterator<Symbol> paramsIterator;
  protected Type resultType;

  public ParamListTyper(String file, ClassType clas, Scope sc,
                        Iterator<Symbol> pit) {
    super(file);
    curclass = clas;
    curscope = sc;
    paramsIterator = pit;
  }

  public Type getResultType() {
    return resultType;
  }

  @Override
  public void caseAEmptyExpList(AEmptyExpList node) {
    if (paramsIterator.hasNext())
      reportError("Too few parameters in call");
  }

  @Override
  public void caseAExpsExpList(AExpsExpList node) {
    if (!paramsIterator.hasNext())
      reportError("Too many parameters in call");
    else {
      ExprTyper et = new ExprTyper(curFile, curclass, curscope);
      node.getExp().apply(et);
      Symbol param = paramsIterator.next();
      expectType(et.getResultType(), param.getType());
      // now process next parameter
      node.getExpRest().apply(this);
    }
  }

  @Override
  public void caseAEmptyExpRest(AEmptyExpRest node) {
    if (paramsIterator.hasNext())
      reportError("Too few parameters in call");
  }

  @Override
  public void caseAExpsExpRest(AExpsExpRest node) {
    if (!paramsIterator.hasNext())
      reportError("Too many parameters in call");
    else {
      node.getComma().apply(this);
      ExprTyper et = new ExprTyper(curFile, curclass, curscope);
      node.getExp().apply(et);
      Symbol param = paramsIterator.next();
      expectType(et.getResultType(), param.getType());
      // now process next parameter
      node.getExpRest().apply(this);
    }
  }
}
