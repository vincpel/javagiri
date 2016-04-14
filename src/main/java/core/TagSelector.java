package core;

import syntax.node.AAttributes;
import syntax.node.AOpenmarker;
import syntax.node.ASingletagTags;

public class TagSelector extends Selector {

	public TagSelector(String name) {
		super(name);
	}
	
	public String type(){
		return "tag";
	}

	@Override
	public boolean matchStatisfy(AOpenmarker node) {
		return node.getTagname().toString().trim().equalsIgnoreCase(getName().trim());
	}

	@Override
	public boolean matchStatisfy(AAttributes node) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean matchStatisfy(ASingletagTags node) {
		return node.getTagname().toString().trim().equalsIgnoreCase(getName().trim());
	}
}
