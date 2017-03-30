package leedcode;

import java.util.LinkedList;

public class MovingAverage {

	int size;
	double sum=0;
	LinkedList<Integer> list=new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
    	if(size==0)
    		return 0;
    	if(list.size()==size){
    		sum-=list.removeFirst();
    	}
    	sum+=val;
    	list.addLast(val);
        return sum/(double)list.size();
    }
}
