/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AArrayFactor extends PFactor
{
    private PFactor _factor_;
    private TLbracket _lbracket_;
    private PExp _index_;
    private TRbracket _rbracket_;

    public AArrayFactor()
    {
        // Constructor
    }

    public AArrayFactor(
        @SuppressWarnings("hiding") PFactor _factor_,
        @SuppressWarnings("hiding") TLbracket _lbracket_,
        @SuppressWarnings("hiding") PExp _index_,
        @SuppressWarnings("hiding") TRbracket _rbracket_)
    {
        // Constructor
        setFactor(_factor_);

        setLbracket(_lbracket_);

        setIndex(_index_);

        setRbracket(_rbracket_);

    }

    @Override
    public Object clone()
    {
        return new AArrayFactor(
            cloneNode(this._factor_),
            cloneNode(this._lbracket_),
            cloneNode(this._index_),
            cloneNode(this._rbracket_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayFactor(this);
    }

    public PFactor getFactor()
    {
        return this._factor_;
    }

    public void setFactor(PFactor node)
    {
        if(this._factor_ != null)
        {
            this._factor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._factor_ = node;
    }

    public TLbracket getLbracket()
    {
        return this._lbracket_;
    }

    public void setLbracket(TLbracket node)
    {
        if(this._lbracket_ != null)
        {
            this._lbracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lbracket_ = node;
    }

    public PExp getIndex()
    {
        return this._index_;
    }

    public void setIndex(PExp node)
    {
        if(this._index_ != null)
        {
            this._index_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._index_ = node;
    }

    public TRbracket getRbracket()
    {
        return this._rbracket_;
    }

    public void setRbracket(TRbracket node)
    {
        if(this._rbracket_ != null)
        {
            this._rbracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rbracket_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._factor_)
            + toString(this._lbracket_)
            + toString(this._index_)
            + toString(this._rbracket_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._factor_ == child)
        {
            this._factor_ = null;
            return;
        }

        if(this._lbracket_ == child)
        {
            this._lbracket_ = null;
            return;
        }

        if(this._index_ == child)
        {
            this._index_ = null;
            return;
        }

        if(this._rbracket_ == child)
        {
            this._rbracket_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._factor_ == oldChild)
        {
            setFactor((PFactor) newChild);
            return;
        }

        if(this._lbracket_ == oldChild)
        {
            setLbracket((TLbracket) newChild);
            return;
        }

        if(this._index_ == oldChild)
        {
            setIndex((PExp) newChild);
            return;
        }

        if(this._rbracket_ == oldChild)
        {
            setRbracket((TRbracket) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
