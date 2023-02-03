/* This file was generated by SableCC (http://www.sablecc.org/). */

package parser;

import node.*;
import analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTBoolean(@SuppressWarnings("unused") TBoolean node)
    {
        this.index = 0;
    }

    @Override
    public void caseTClas(@SuppressWarnings("unused") TClas node)
    {
        this.index = 1;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 2;
    }

    @Override
    public void caseTFalse(@SuppressWarnings("unused") TFalse node)
    {
        this.index = 3;
    }

    @Override
    public void caseTIf(@SuppressWarnings("unused") TIf node)
    {
        this.index = 4;
    }

    @Override
    public void caseTInt(@SuppressWarnings("unused") TInt node)
    {
        this.index = 5;
    }

    @Override
    public void caseTMain(@SuppressWarnings("unused") TMain node)
    {
        this.index = 6;
    }

    @Override
    public void caseTNew(@SuppressWarnings("unused") TNew node)
    {
        this.index = 7;
    }

    @Override
    public void caseTPrintln(@SuppressWarnings("unused") TPrintln node)
    {
        this.index = 8;
    }

    @Override
    public void caseTPublic(@SuppressWarnings("unused") TPublic node)
    {
        this.index = 9;
    }

    @Override
    public void caseTReturn(@SuppressWarnings("unused") TReturn node)
    {
        this.index = 10;
    }

    @Override
    public void caseTStatic(@SuppressWarnings("unused") TStatic node)
    {
        this.index = 11;
    }

    @Override
    public void caseTString(@SuppressWarnings("unused") TString node)
    {
        this.index = 12;
    }

    @Override
    public void caseTThis(@SuppressWarnings("unused") TThis node)
    {
        this.index = 13;
    }

    @Override
    public void caseTTrue(@SuppressWarnings("unused") TTrue node)
    {
        this.index = 14;
    }

    @Override
    public void caseTVoid(@SuppressWarnings("unused") TVoid node)
    {
        this.index = 15;
    }

    @Override
    public void caseTWhile(@SuppressWarnings("unused") TWhile node)
    {
        this.index = 16;
    }

    @Override
    public void caseTLbracket(@SuppressWarnings("unused") TLbracket node)
    {
        this.index = 17;
    }

    @Override
    public void caseTRbracket(@SuppressWarnings("unused") TRbracket node)
    {
        this.index = 18;
    }

    @Override
    public void caseTSemi(@SuppressWarnings("unused") TSemi node)
    {
        this.index = 19;
    }

    @Override
    public void caseTLparen(@SuppressWarnings("unused") TLparen node)
    {
        this.index = 20;
    }

    @Override
    public void caseTRparen(@SuppressWarnings("unused") TRparen node)
    {
        this.index = 21;
    }

    @Override
    public void caseTLbrace(@SuppressWarnings("unused") TLbrace node)
    {
        this.index = 22;
    }

    @Override
    public void caseTRbrace(@SuppressWarnings("unused") TRbrace node)
    {
        this.index = 23;
    }

    @Override
    public void caseTEqual(@SuppressWarnings("unused") TEqual node)
    {
        this.index = 24;
    }

    @Override
    public void caseTDot(@SuppressWarnings("unused") TDot node)
    {
        this.index = 25;
    }

    @Override
    public void caseTBang(@SuppressWarnings("unused") TBang node)
    {
        this.index = 26;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 27;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 28;
    }

    @Override
    public void caseTAnd(@SuppressWarnings("unused") TAnd node)
    {
        this.index = 29;
    }

    @Override
    public void caseTLess(@SuppressWarnings("unused") TLess node)
    {
        this.index = 30;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 31;
    }

    @Override
    public void caseTStar(@SuppressWarnings("unused") TStar node)
    {
        this.index = 32;
    }

    @Override
    public void caseTId(@SuppressWarnings("unused") TId node)
    {
        this.index = 33;
    }

    @Override
    public void caseTNumber(@SuppressWarnings("unused") TNumber node)
    {
        this.index = 34;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 35;
    }
}
