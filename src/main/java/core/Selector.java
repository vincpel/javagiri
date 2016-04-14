package core;

import syntax.node.AAttributes;
import syntax.node.AOpenmarker;
import syntax.node.ASingletagTags;

public abstract class Selector {
	private String name;
	
	public Selector(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String type() {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract boolean matchStatisfy(AOpenmarker node);

	public abstract boolean matchStatisfy(AAttributes node);

	public abstract boolean matchStatisfy(ASingletagTags node);
	
}
