package core;

import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import syntax.node.*;

@SuppressWarnings("serial")
public class Selectors extends ArrayList<Selector>{

	//private List<Selector> currentSelectors;
	public Selectors(){		
	}
	public Selector pop(){
		Selector sle  = get(0);
		remove(0);
		return sle;	
	}
	public void push(Selector sl){
		this.add(sl);
	}
	
	public Selectors(List<Selector> lss){
		for (Selector selector : lss) {
			push(selector);
		}		
	}
	
	public Selector popNextSelector(){		
		int numberOfImeToPop = getNextSelector().size();
		for(int i = 0 ; i < numberOfImeToPop; i++){
			pop();
		}
		if (!this.isEmpty() && get(0).type() == "<"){
			pop();
		}
		return null;	
	}
	
	public Selectors getNextSelector(){
		Selectors currentSelectors = new  Selectors();
        for(int i = 0 ; i < size() ; i++){
        	if(this.get(i).type() == "<"){
        		break;
        	}
        	currentSelectors.add(this.get(i));
        }
		return currentSelectors;
	}
	
	public int size(){
		return super.size();
	}
	public boolean empty() {
		// TODO Auto-generated method stub
		return super.size() == 0;
	}
	public int getNextSelectorNumOfAttr() {
		
		int res = 0;
		Selectors currentSelectors = new  Selectors();
        for(int i = 0 ; i < size() ; i++){
        	if(this.get(i).type() == "<"){
        		break;
        	}
        	else if(this.get(i).type() == "class" || this.get(i).type() == "id"){
        		res++;
        	}
        	//currentSelectors.add(this.get(i));
        }
		return res;
		
		
		// TODO Auto-generated method stub
		
	}
}
