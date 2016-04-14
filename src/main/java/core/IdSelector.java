package core;

import syntax.node.AAttributes;
import syntax.node.AOpenmarker;
import syntax.node.ASingletagTags;

public class IdSelector extends Selector {

	public IdSelector(String name) {
		super(name);
	}
	
	public String type(){
		return "id";
	}

	@Override
	public boolean matchStatisfy(AOpenmarker node) {
		//node.getAttributes()
		return true;
	}

	@Override
	public boolean matchStatisfy(AAttributes node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matchStatisfy(ASingletagTags node) {
		//node.getAttributes()
		return true;
	}

}
