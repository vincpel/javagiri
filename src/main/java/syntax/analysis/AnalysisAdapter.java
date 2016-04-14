/* This file was generated by SableCC (http://www.sablecc.org/). */

package syntax.analysis;

import java.util.*;
import syntax.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAHtmldocument(AHtmldocument node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASingletagTags(ASingletagTags node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATagTags(ATagTags node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATextTags(ATextTags node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOpenmarker(AOpenmarker node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAClosemarker(AClosemarker node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAttributes(AAttributes node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInnertext(AInnertext node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTText(TText node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCommentb(TCommentb node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCommentbodyt(TCommentbodyt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCommente(TCommente node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBiginTag(TBiginTag node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTagname(TTagname node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAttrKey(TAttrKey node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAttrValue(TAttrValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEndSinngleTag(TEndSinngleTag node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEndTag(TEndTag node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBiginClosetag(TBiginClosetag node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTClosetagname(TClosetagname node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEndClosetag(TEndClosetag node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
