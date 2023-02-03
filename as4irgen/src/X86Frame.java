/*
 * X86Frame.java: Frame for X86 series of processors (Intel)
 */

import Tree.*;
import Temp.*;
import symbol.*;
import symboltable.*;

public class X86Frame extends Frame
{
   public Exp FP() { return new NAME(new Label("%ebp")); }

   public Stm procEntryExit1(String name, Stm body, Exp return_value)
   {
      Label end = new Label();
      return new SEQ(new Code(  "\t.text\n"
                              + "\t.align 2\n"
                              + ".globl " + name + "\n"
                              + "\t.type\t" + name + ",@function\n"
                              + name + ":\n"
                              + "\tpushl\t%ebp\n"
                              + "\tmovl\t%esp, %ebp\n"
                              + "\tsubl [#LOCALS], %esp\n"),
                     body,
                     new MOVE(new NAME(new Label("%eax")), return_value),
                     new Code(  "\tleave ;; what's this do?\n"
                              + "\tret\n"
                              + end + ":\n"
                              + "\tsize\t" + name + ",." + end+"-"+name + "\n")
                     );
   }
}
