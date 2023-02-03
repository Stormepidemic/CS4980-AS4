/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class ABaseclassClassDecl extends PClassDecl
{
    private TClas _clas_;
    private TId _id_;
    private TLbrace _lbrace_;
    private final LinkedList<PClassVarDecl> _classVarDecl_ = new LinkedList<PClassVarDecl>();
    private final LinkedList<PMethodDecl> _methodDecl_ = new LinkedList<PMethodDecl>();
    private TRbrace _rbrace_;

    public ABaseclassClassDecl()
    {
        // Constructor
    }

    public ABaseclassClassDecl(
        @SuppressWarnings("hiding") TClas _clas_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TLbrace _lbrace_,
        @SuppressWarnings("hiding") List<?> _classVarDecl_,
        @SuppressWarnings("hiding") List<?> _methodDecl_,
        @SuppressWarnings("hiding") TRbrace _rbrace_)
    {
        // Constructor
        setClas(_clas_);

        setId(_id_);

        setLbrace(_lbrace_);

        setClassVarDecl(_classVarDecl_);

        setMethodDecl(_methodDecl_);

        setRbrace(_rbrace_);

    }

    @Override
    public Object clone()
    {
        return new ABaseclassClassDecl(
            cloneNode(this._clas_),
            cloneNode(this._id_),
            cloneNode(this._lbrace_),
            cloneList(this._classVarDecl_),
            cloneList(this._methodDecl_),
            cloneNode(this._rbrace_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABaseclassClassDecl(this);
    }

    public TClas getClas()
    {
        return this._clas_;
    }

    public void setClas(TClas node)
    {
        if(this._clas_ != null)
        {
            this._clas_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._clas_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
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

    public LinkedList<PClassVarDecl> getClassVarDecl()
    {
        return this._classVarDecl_;
    }

    public void setClassVarDecl(List<?> list)
    {
        for(PClassVarDecl e : this._classVarDecl_)
        {
            e.parent(null);
        }
        this._classVarDecl_.clear();

        for(Object obj_e : list)
        {
            PClassVarDecl e = (PClassVarDecl) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._classVarDecl_.add(e);
        }
    }

    public LinkedList<PMethodDecl> getMethodDecl()
    {
        return this._methodDecl_;
    }

    public void setMethodDecl(List<?> list)
    {
        for(PMethodDecl e : this._methodDecl_)
        {
            e.parent(null);
        }
        this._methodDecl_.clear();

        for(Object obj_e : list)
        {
            PMethodDecl e = (PMethodDecl) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._methodDecl_.add(e);
        }
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
            + toString(this._clas_)
            + toString(this._id_)
            + toString(this._lbrace_)
            + toString(this._classVarDecl_)
            + toString(this._methodDecl_)
            + toString(this._rbrace_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._clas_ == child)
        {
            this._clas_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._lbrace_ == child)
        {
            this._lbrace_ = null;
            return;
        }

        if(this._classVarDecl_.remove(child))
        {
            return;
        }

        if(this._methodDecl_.remove(child))
        {
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
        if(this._clas_ == oldChild)
        {
            setClas((TClas) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._lbrace_ == oldChild)
        {
            setLbrace((TLbrace) newChild);
            return;
        }

        for(ListIterator<PClassVarDecl> i = this._classVarDecl_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PClassVarDecl) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PMethodDecl> i = this._methodDecl_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMethodDecl) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._rbrace_ == oldChild)
        {
            setRbrace((TRbrace) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
