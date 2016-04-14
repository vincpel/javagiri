package core;

import syntax.node.AAttributes;
import syntax.node.AOpenmarker;
import syntax.node.ASingletagTags;

public class SeparatorSelector extends Selector {

	public SeparatorSelector() {
		super("separator");
	}
	
	public String type(){
		return "<";
	}

	@Override
	public boolean matchStatisfy(AOpenmarker node) {
		return false;
	}

	@Override
	public boolean matchStatisfy(AAttributes node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matchStatisfy(ASingletagTags node) {
		// TODO Auto-generated method stub
		return false;
	}



}
