package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import syntax.analysis.DepthFirstAdapter;
import syntax.node.*;


public class Interpreter  extends DepthFirstAdapter {

	private Selectors selectors;

	ArrayList<Node> candidates;
	private Selectors fullSelectorslist;  // keeps track of the full set , and if need to be RESETED 

	private Selectors selToVerity;
	boolean openTagWasMath;
	boolean atttributeWasMatch;

	public ArrayList<Node> getCandidates() {
		return candidates;
	}

	public void setCandidates(ArrayList<Node> candidates) {
		this.candidates = candidates;

	}

	private String currentTagName;
	private boolean tagmatch;
	private boolean attribmatch = false;

	public Interpreter(Selectors selelectors){
		fullSelectorslist = new Selectors(selelectors);
		selToVerity = new Selectors(selelectors);

		openTagWasMath = false;
		atttributeWasMatch = false;

		this.candidates = new ArrayList<Node>();
	}



	public  Interpreter verify(Start tree,Selectors selelectors) {	
		tree.apply(this);
		return null;
	}

	@Override
	public void caseStart(Start node) {
		// TODO Auto-generated method stub
		super.caseStart(node);
	}

	@Override
	public void caseATagTags(ATagTags node) {
		//Iterator<PTags> inerIter =  node.getTags().iterator();

		// put back those 2 t default
		openTagWasMath = false;
		atttributeWasMatch = false;


		node.getOpenmarker().apply(this);  // will check if ta//atrib matches

		if(openTagWasMath && atttributeWasMatch){
			selToVerity.popNextSelector();
			//selToVerity = selToVerity.getNextSelector();
			if(selToVerity.empty()){
				//System.out.println(node);
				// found one need to continue
				candidates.add(node);
				selToVerity = new Selectors(fullSelectorslist);

			}
		}else{
			selToVerity = new Selectors(fullSelectorslist);
		}

		Selectors selToVerityInStackCopy = new Selectors(selToVerity);
		for(PTags e : node.getTags()){
			//Selectors selToVerityInStackCopy = selToVerity;
			e.apply(this);
			selToVerity = new Selectors(selToVerityInStackCopy);
		}




		//selToVerity = selToVerityInStackCopy;


	}
	@Override
	public void caseAAttributes(AAttributes node){
		// ok now we suposed to verify if all those attribute are appliable

		Selectors  seltocheckOnThisLink = selToVerity.getNextSelector();


		for (Selector aSelector : seltocheckOnThisLink) {

			if(aSelector.matchStatisfy(node)){
				atttributeWasMatch = true;
				
			}else{
				atttributeWasMatch = false;
				//reset the whole css list
				break;

			}
		}

		super.caseAAttributes(node);
	}



	@Override
	public void  caseASingletagTags(ASingletagTags node){
		List<PAttributes> copy = new ArrayList<PAttributes>(node.getAttributes());
		int numOfAttribute = copy.size();
		if(numOfAttribute > 0){
			for(PAttributes e : copy){
				e.apply(this);
			}
		}else{
			attribmatch = true;
		}

		Selectors seltocheckOnThisLink = selToVerity.getNextSelector();

		currentTagName = node.getTagname().getText();
		
		boolean satysfy = false;
		for (Selector aSelector : seltocheckOnThisLink) {

			if(aSelector.matchStatisfy(node)){
				satysfy = true;

			}else{
				satysfy = false;
				break;
			}
		}
		if(satysfy && (copy.size() == 0 || atttributeWasMatch)){
			openTagWasMath = true;
			atttributeWasMatch = true;
			//candidates.add(node);
			//System.out.println(currentTagName);
		}
		// visit childs
		super.caseASingletagTags(node);

	}

	@Override
	public void caseAOpenmarker(AOpenmarker node) {

		List<PAttributes> copy = new ArrayList<PAttributes>(node.getAttributes());

		int numOfAttribute = copy.size();
		int numberOAttribunteTofind = selToVerity.getNextSelectorNumOfAttr();
		if(numOfAttribute > 0){
			for(PAttributes e : copy){
				e.apply(this);
			}
		}else if(numberOAttribunteTofind ==0){
			atttributeWasMatch = true;
		}

		Selectors seltocheckOnThisLink = selToVerity.getNextSelector();

		currentTagName = node.getTagname().getText();
		//System.out.println(currentTagName);

		for (Selector aSelector : seltocheckOnThisLink) {

			if(aSelector.matchStatisfy(node)){
				openTagWasMath = true;

			}else{
				openTagWasMath = false;
				break;
			}
		}
		if(openTagWasMath && atttributeWasMatch){
			//openTagWasMath = true;
			atttributeWasMatch = true;
			//candidates.add(node);
			//System.out.println(currentTagName);
		}
		// visit childs
		super.caseAOpenmarker(node);
	}

}
