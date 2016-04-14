/* This file was generated by SableCC (http://www.sablecc.org/). */

package syntax.node;

import syntax.analysis.*;

@SuppressWarnings("nls")
public final class TBiginClosetag extends Token
{
    public TBiginClosetag(String text)
    {
        setText(text);
    }

    public TBiginClosetag(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TBiginClosetag(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTBiginClosetag(this);
    }
}
