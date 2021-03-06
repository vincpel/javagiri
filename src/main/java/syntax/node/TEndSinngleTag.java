/* This file was generated by SableCC (http://www.sablecc.org/). */

package syntax.node;

import syntax.analysis.*;

@SuppressWarnings("nls")
public final class TEndSinngleTag extends Token
{
    public TEndSinngleTag()
    {
        super.setText("/>");
    }

    public TEndSinngleTag(int line, int pos)
    {
        super.setText("/>");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TEndSinngleTag(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEndSinngleTag(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TEndSinngleTag text.");
    }
}
