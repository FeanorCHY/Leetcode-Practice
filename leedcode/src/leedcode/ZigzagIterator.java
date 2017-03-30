package leedcode;

import java.util.List;

public class ZigzagIterator {
	List<Integer> list1;
	List<Integer> list2;
	int row=0;
	int col=-1;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list1=v1;
        list2=v2;
    }

    public int next() {
    	if(row==0){
    		return list1.get(col);
    	}
    	else
    		return list2.get(col);
    }

    public boolean hasNext() {
    	if(col==-1){
    		col=0;
    		if(list1==null||list1.size()==0){
    			if(list2==null||list2.size()==0){
	    			col=-1;
	    			return false;
    			}
    			else{
    				row=1;
    				return true;
    			}
    		}
    	}
    	else if(row==0){
    		if(list2==null||list2.size()<col+1){
    			if(list1==null||list1.size()<=col+1)
    				return false;
    			else
    				col++;
    		}
    		else
    			row=1;
    	}
    	else{
    		col++;
    		if(list1==null||list1.size()<col+1){
    			if(list2==null||list2.size()<col+1)
    				return false;
    		}
    		else
    			row=0;
    	}
    	
        return true;
    }
}
