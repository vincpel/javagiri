package core;

//import syntax.node.AOneAttributes;
import syntax.node.AAttributes;
import syntax.node.AOpenmarker;
import syntax.node.ASingletagTags;
import syntax.node.PAttributes;

public class ClassSelector extends Selector {

	public ClassSelector(String name) {
		super(name);
	}
	
	public String type(){
		return "class";
	}

	@Override
	public boolean matchStatisfy(AOpenmarker node) {

		return true;
	}

	@Override
	public boolean matchStatisfy(AAttributes node) {
		String ttype = "."+node.getAttrValue().getText().substring(1, node.getAttrValue().getText().length()-1);
		
		boolean res  = ttype.equalsIgnoreCase(getName().trim());
		return res;
	}

	@Override
	public boolean matchStatisfy(ASingletagTags node) {
		// TODO Auto-generated method stub
		return true;
	}

}
