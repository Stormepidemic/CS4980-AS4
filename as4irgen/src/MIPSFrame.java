/*
 * MIPSFrame.java: Frame for MIPS
 */

import Tree.*;
import Temp.*;
import symbol.*;
import symboltable.*;

public class MIPSFrame extends Frame
{
   public Exp FP() { return new NAME(new Label("$fp")); }

   public Stm procEntryExit1(String name, Stm body, Exp return_value)
   {
      Label end = new Label();
      return new SEQ(new Code(";; start of " + name + " function"),
                     body,
                     new MOVE(new NAME(new Label("$v0")), return_value),
                     new Code(";; exit " + name + ":\n"
                     + "jr $ra")
                     );
   }
}
