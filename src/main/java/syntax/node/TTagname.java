/* This file was generated by SableCC (http://www.sablecc.org/). */

package syntax.node;

import syntax.analysis.*;

@SuppressWarnings("nls")
public final class TTagname extends Token
{
    public TTagname(String text)
    {
        setText(text);
    }

    public TTagname(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTagname(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTagname(this);
    }
}
