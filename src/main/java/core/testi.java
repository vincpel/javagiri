package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import syntax.analysis.DepthFirstAdapter;
import syntax.node.*;


public class testi  extends DepthFirstAdapter {

	private Selectors selectors;
	ArrayList<Node> candidates ;
	ArrayList<Node> currentCandidates ;
	private String currentTagName;
	private boolean tagmatch;
	private boolean attribmatch = false;
	private boolean parentsmatch = false;


	public testi(){
		tagmatch = true;
		//this.selectors = selelectors;
		this.candidates = new ArrayList<Node>();
	}

	public  testi verify(Start tree) {	
		testi interpreter = new testi();
		tree.apply(interpreter);
		return null;
	}

	

	@Override
	public void inAOpenmarker(AOpenmarker node) {
		
   
			//candidates.add(node);
			System.out.println(node.getTagname().getText());
		

		
	}



	public void setCandidates(ArrayList<Node> can) {
		this.candidates = can ;
		
	}

}
