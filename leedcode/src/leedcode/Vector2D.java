package leedcode;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	List<List<Integer>> listlist;
	List<Integer> list;
	int index1=0;
	int index2=0;
	Integer val;
    public Vector2D(List<List<Integer>> vec2d) {
        listlist=vec2d;
        if(listlist.size()>0)
        	list=listlist.get(index1++);
        else
        	list=null;
    }

    @Override
    public Integer next() {
    	return val;
    }

    @Override
    public boolean hasNext() {
        if(list!=null){
        	if(index2!=list.size()){
        		val=list.get(index2++);
        		return true;
        	}
    		else{
    			if(index1==listlist.size())
    				return false;
        		list=listlist.get(index1++);
	        	while(list.isEmpty()){
	        		if(index1==listlist.size()){
	        			val=null;
	        			return false;
	        		}
	        		list=listlist.get(index1++);
	        	}
	        	index2=0;
	        	val=list.get(index2++);
	        	return true;
    		}
        }
        else{
        	val=null;
        	return false;
        }
    }

}
