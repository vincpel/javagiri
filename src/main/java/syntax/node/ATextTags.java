/* This file was generated by SableCC (http://www.sablecc.org/). */

package syntax.node;

import syntax.analysis.*;

@SuppressWarnings("nls")
public final class ATextTags extends PTags
{
    private TText _text_;

    public ATextTags()
    {
        // Constructor
    }

    public ATextTags(
        @SuppressWarnings("hiding") TText _text_)
    {
        // Constructor
        setText(_text_);

    }

    @Override
    public Object clone()
    {
        return new ATextTags(
            cloneNode(this._text_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATextTags(this);
    }

    public TText getText()
    {
        return this._text_;
    }

    public void setText(TText node)
    {
        if(this._text_ != null)
        {
            this._text_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._text_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._text_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._text_ == child)
        {
            this._text_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._text_ == oldChild)
        {
            setText((TText) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
