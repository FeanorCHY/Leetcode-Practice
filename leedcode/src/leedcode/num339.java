package leedcode;

import java.util.List;
import java.util.Stack;

public class num339 {
    public int depthSum(List<NestedInteger> list) {
    	int sum=0;
    	int level=1;
    	Stack<List<NestedInteger>> st=new Stack<List<NestedInteger>>();
    	st.add(list);
    	while(!st.isEmpty()){
    		Stack<List<NestedInteger>> tem=new Stack<List<NestedInteger>>();
    		while(!st.isEmpty()){
        		list=st.pop();
	        	for(int i=0;i<list.size();i++){
	        		if(list.get(i).isInteger()){
	        			sum+=list.get(i).getInteger()*level;
	        		}
	        		else
	        			tem.add(list.get(i).getList());
	        	}
    		}
    		level++;
    		st=tem;
    	}
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedInteger node=new NestedInteger(1);
		NestedInteger list=new NestedInteger();
		list.add(node);
		node=new NestedInteger(1);
		list.add(node);
		NestedInteger listNode1=list;
		list=new NestedInteger();
		node=new NestedInteger(1);
		list.add(node);
		node=new NestedInteger(1);
		list.add(node);
		
		NestedInteger biglist=new NestedInteger();
		biglist.add(listNode1);
		biglist.add(new NestedInteger(2));
		listNode1=list;
		biglist.add(listNode1);
		NestedInteger bigNode=biglist;
	}

}
