/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AIfStmtAllPaired extends PStmtAllPaired
{
    private TIf _if_;
    private TLparen _lparen_;
    private PExp _exp_;
    private TRparen _rparen_;
    private PStmtAllPaired _truepart_;
    private TElse _else_;
    private PStmtAllPaired _falsepart_;

    public AIfStmtAllPaired()
    {
        // Constructor
    }

    public AIfStmtAllPaired(
        @SuppressWarnings("hiding") TIf _if_,
        @SuppressWarnings("hiding") TLparen _lparen_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TRparen _rparen_,
        @SuppressWarnings("hiding") PStmtAllPaired _truepart_,
        @SuppressWarnings("hiding") TElse _else_,
        @SuppressWarnings("hiding") PStmtAllPaired _falsepart_)
    {
        // Constructor
        setIf(_if_);

        setLparen(_lparen_);

        setExp(_exp_);

        setRparen(_rparen_);

        setTruepart(_truepart_);

        setElse(_else_);

        setFalsepart(_falsepart_);

    }

    @Override
    public Object clone()
    {
        return new AIfStmtAllPaired(
            cloneNode(this._if_),
            cloneNode(this._lparen_),
            cloneNode(this._exp_),
            cloneNode(this._rparen_),
            cloneNode(this._truepart_),
            cloneNode(this._else_),
            cloneNode(this._falsepart_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfStmtAllPaired(this);
    }

    public TIf getIf()
    {
        return this._if_;
    }

    public void setIf(TIf node)
    {
        if(this._if_ != null)
        {
            this._if_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._if_ = node;
    }

    public TLparen getLparen()
    {
        return this._lparen_;
    }

    public void setLparen(TLparen node)
    {
        if(this._lparen_ != null)
        {
            this._lparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lparen_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TRparen getRparen()
    {
        return this._rparen_;
    }

    public void setRparen(TRparen node)
    {
        if(this._rparen_ != null)
        {
            this._rparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rparen_ = node;
    }

    public PStmtAllPaired getTruepart()
    {
        return this._truepart_;
    }

    public void setTruepart(PStmtAllPaired node)
    {
        if(this._truepart_ != null)
        {
            this._truepart_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._truepart_ = node;
    }

    public TElse getElse()
    {
        return this._else_;
    }

    public void setElse(TElse node)
    {
        if(this._else_ != null)
        {
            this._else_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._else_ = node;
    }

    public PStmtAllPaired getFalsepart()
    {
        return this._falsepart_;
    }

    public void setFalsepart(PStmtAllPaired node)
    {
        if(this._falsepart_ != null)
        {
            this._falsepart_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._falsepart_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._if_)
            + toString(this._lparen_)
            + toString(this._exp_)
            + toString(this._rparen_)
            + toString(this._truepart_)
            + toString(this._else_)
            + toString(this._falsepart_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._if_ == child)
        {
            this._if_ = null;
            return;
        }

        if(this._lparen_ == child)
        {
            this._lparen_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._rparen_ == child)
        {
            this._rparen_ = null;
            return;
        }

        if(this._truepart_ == child)
        {
            this._truepart_ = null;
            return;
        }

        if(this._else_ == child)
        {
            this._else_ = null;
            return;
        }

        if(this._falsepart_ == child)
        {
            this._falsepart_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._if_ == oldChild)
        {
            setIf((TIf) newChild);
            return;
        }

        if(this._lparen_ == oldChild)
        {
            setLparen((TLparen) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._rparen_ == oldChild)
        {
            setRparen((TRparen) newChild);
            return;
        }

        if(this._truepart_ == oldChild)
        {
            setTruepart((PStmtAllPaired) newChild);
            return;
        }

        if(this._else_ == oldChild)
        {
            setElse((TElse) newChild);
            return;
        }

        if(this._falsepart_ == oldChild)
        {
            setFalsepart((PStmtAllPaired) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
