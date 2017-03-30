package leedcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer>{
	
	Stack<List<NestedInteger>> stList=new Stack<List<NestedInteger>>();
	Stack<Integer> indexList=new Stack<Integer>();
	List<NestedInteger> cur;
	int index=0;
	boolean begin=false;
    public NestedIterator(List<NestedInteger> nestedList) {
    	cur=nestedList;
        while(index>=cur.size()||!cur.get(index).isInteger()){
        	if(index>=cur.size()){
    			if(stList.isEmpty())
    				return;
        		cur=stList.pop();
        		index=indexList.pop()+1;
        		continue;
        	}
        	stList.add(cur);
        	indexList.add(index);
        	cur=cur.get(index).getList();
        	index=0;
        }
    }

    @Override
    public Integer next() {
        return cur.get(index).getInteger();
    }

    @Override
    public boolean hasNext() {
		if(index>=cur.size())
			return false;
    	if(begin==false){
    		begin=true;
    		return true;
		}
    	else{
			index++;
	        while(index>=cur.size()||!cur.get(index).isInteger()){
	        	if(index>=cur.size()){
	    			if(stList.isEmpty())
	    				return false;
	        		cur=stList.pop();
	        		index=indexList.pop()+1;
	        		continue;
	        	}
	        	stList.add(cur);
	        	indexList.add(index);
	        	cur=cur.get(index).getList();
	        	index=0;//initial index for new array
	        }
	        return true;
    	}
    }
}
