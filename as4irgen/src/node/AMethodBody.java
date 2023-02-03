/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class AMethodBody extends PMethodBody
{
    private TLbrace _lbrace_;
    private final LinkedList<PLocalVarDecl> _localVarDecl_ = new LinkedList<PLocalVarDecl>();
    private final LinkedList<PStatement> _statement_ = new LinkedList<PStatement>();
    private TReturn _return_;
    private PExp _exp_;
    private TSemi _semi_;
    private TRbrace _rbrace_;

    public AMethodBody()
    {
        // Constructor
    }

    public AMethodBody(
        @SuppressWarnings("hiding") TLbrace _lbrace_,
        @SuppressWarnings("hiding") List<?> _localVarDecl_,
        @SuppressWarnings("hiding") List<?> _statement_,
        @SuppressWarnings("hiding") TReturn _return_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TSemi _semi_,
        @SuppressWarnings("hiding") TRbrace _rbrace_)
    {
        // Constructor
        setLbrace(_lbrace_);

        setLocalVarDecl(_localVarDecl_);

        setStatement(_statement_);

        setReturn(_return_);

        setExp(_exp_);

        setSemi(_semi_);

        setRbrace(_rbrace_);

    }

    @Override
    public Object clone()
    {
        return new AMethodBody(
            cloneNode(this._lbrace_),
            cloneList(this._localVarDecl_),
            cloneList(this._statement_),
            cloneNode(this._return_),
            cloneNode(this._exp_),
            cloneNode(this._semi_),
            cloneNode(this._rbrace_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodBody(this);
    }

    public TLbrace getLbrace()
    {
        return this._lbrace_;
    }

    public void setLbrace(TLbrace node)
    {
        if(this._lbrace_ != null)
        {
            this._lbrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lbrace_ = node;
    }

    public LinkedList<PLocalVarDecl> getLocalVarDecl()
    {
        return this._localVarDecl_;
    }

    public void setLocalVarDecl(List<?> list)
    {
        for(PLocalVarDecl e : this._localVarDecl_)
        {
            e.parent(null);
        }
        this._localVarDecl_.clear();

        for(Object obj_e : list)
        {
            PLocalVarDecl e = (PLocalVarDecl) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._localVarDecl_.add(e);
        }
    }

    public LinkedList<PStatement> getStatement()
    {
        return this._statement_;
    }

    public void setStatement(List<?> list)
    {
        for(PStatement e : this._statement_)
        {
            e.parent(null);
        }
        this._statement_.clear();

        for(Object obj_e : list)
        {
            PStatement e = (PStatement) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._statement_.add(e);
        }
    }

    public TReturn getReturn()
    {
        return this._return_;
    }

    public void setReturn(TReturn node)
    {
        if(this._return_ != null)
        {
            this._return_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._return_ = node;
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

    public TSemi getSemi()
    {
        return this._semi_;
    }

    public void setSemi(TSemi node)
    {
        if(this._semi_ != null)
        {
            this._semi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semi_ = node;
    }

    public TRbrace getRbrace()
    {
        return this._rbrace_;
    }

    public void setRbrace(TRbrace node)
    {
        if(this._rbrace_ != null)
        {
            this._rbrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rbrace_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lbrace_)
            + toString(this._localVarDecl_)
            + toString(this._statement_)
            + toString(this._return_)
            + toString(this._exp_)
            + toString(this._semi_)
            + toString(this._rbrace_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lbrace_ == child)
        {
            this._lbrace_ = null;
            return;
        }

        if(this._localVarDecl_.remove(child))
        {
            return;
        }

        if(this._statement_.remove(child))
        {
            return;
        }

        if(this._return_ == child)
        {
            this._return_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._semi_ == child)
        {
            this._semi_ = null;
            return;
        }

        if(this._rbrace_ == child)
        {
            this._rbrace_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lbrace_ == oldChild)
        {
            setLbrace((TLbrace) newChild);
            return;
        }

        for(ListIterator<PLocalVarDecl> i = this._localVarDecl_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PLocalVarDecl) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PStatement> i = this._statement_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStatement) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._return_ == oldChild)
        {
            setReturn((TReturn) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._semi_ == oldChild)
        {
            setSemi((TSemi) newChild);
            return;
        }

        if(this._rbrace_ == oldChild)
        {
            setRbrace((TRbrace) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}