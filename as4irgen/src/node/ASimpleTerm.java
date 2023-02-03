/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ASimpleTerm extends PTerm
{
    private PBoolExp _boolExp_;

    public ASimpleTerm()
    {
        // Constructor
    }

    public ASimpleTerm(
        @SuppressWarnings("hiding") PBoolExp _boolExp_)
    {
        // Constructor
        setBoolExp(_boolExp_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleTerm(
            cloneNode(this._boolExp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleTerm(this);
    }

    public PBoolExp getBoolExp()
    {
        return this._boolExp_;
    }

    public void setBoolExp(PBoolExp node)
    {
        if(this._boolExp_ != null)
        {
            this._boolExp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._boolExp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._boolExp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._boolExp_ == child)
        {
            this._boolExp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._boolExp_ == oldChild)
        {
            setBoolExp((PBoolExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
