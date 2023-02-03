import Tree.*;
import Temp.*;
import symbol.*;
import symboltable.*;

public abstract class Frame
{
   // these first two involve platform-specific assembly code
   public abstract Exp FP();
   public abstract Stm procEntryExit1(String name, Stm body, Exp return_value);

   public Temp RV() { return new Temp(); }

   public Exp externalCall(String func, ExpList args)
   {
      return new CALL(new NAME(new Label(func)), args);
   }

   public Exp methodCall(ClassType ct, String func, ExpList args)
   {
      return new CALL(new NAME(new Label(ct.getName() + "$" + func)), args);
   }

   public MEM getThis()         // assumes 'this' is always parameter 1
   {
      return new MEM(new BINOP(BINOP.PLUS, FP(), new CONST(8)));
   }

   public MEM access(Symbol sym)
   {
      if ( !sym.isVariable() )
         throw new Error("Attempt to access non-variable.");
      if ( sym.isLocalVariable() )
         return new MEM(new BINOP(BINOP.PLUS, FP(),
                                  new CONST(-4 * (1 + sym.getOffset()))));
      else if ( sym.isParam() )
         return new MEM(new BINOP(BINOP.PLUS, FP(),
                                  new CONST(4 * (3 + sym.getOffset()))));
      else
      {
         if ( !sym.isClassVariable() )
            throw new Error("Expected class variable");
         return new MEM(new BINOP(BINOP.PLUS, getThis(),
                                  new CONST(4 * sym.getOffset())));
      }
   }
}
