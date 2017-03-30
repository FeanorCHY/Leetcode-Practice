package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num364 {
	ArrayList<Integer> list=new ArrayList<Integer>();
    public int depthSumInverse(List<NestedInteger> nestedList) {
    	depsum(nestedList,0);
    	int sum=0;
    	for(int i=list.size()-1;i>=0;i++){
    		sum+=list.get(i)*(list.size()-i);
    	}
    	
        return sum;
    }
    public void depsum(List<NestedInteger> nestedList,int level){
    	int sum=0;
    	if(level>list.size()){
    		list.add(0);
    	}
    	for(NestedInteger each:nestedList){
    		if(each.isInteger())
    			sum+=each.getInteger();
    		else{
    			depsum(each.getList(),level);
    		}
    	}
		list.set(level, list.get(level)+sum);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
