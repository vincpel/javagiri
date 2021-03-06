/* This file was generated by SableCC (http://www.sablecc.org/). */

package syntax.analysis;

import syntax.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAHtmldocument(AHtmldocument node);
    void caseASingletagTags(ASingletagTags node);
    void caseATagTags(ATagTags node);
    void caseATextTags(ATextTags node);
    void caseAOpenmarker(AOpenmarker node);
    void caseAClosemarker(AClosemarker node);
    void caseAAttributes(AAttributes node);
    void caseAInnertext(AInnertext node);

    void caseTText(TText node);
    void caseTCommentb(TCommentb node);
    void caseTCommentbodyt(TCommentbodyt node);
    void caseTCommente(TCommente node);
    void caseTBiginTag(TBiginTag node);
    void caseTTagname(TTagname node);
    void caseTAttrKey(TAttrKey node);
    void caseTAttrValue(TAttrValue node);
    void caseTBlank(TBlank node);
    void caseTEndSinngleTag(TEndSinngleTag node);
    void caseTEndTag(TEndTag node);
    void caseTBiginClosetag(TBiginClosetag node);
    void caseTClosetagname(TClosetagname node);
    void caseTEndClosetag(TEndClosetag node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
