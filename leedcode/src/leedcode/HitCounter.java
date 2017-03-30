package leedcode;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class HitCounter {

	TreeSet<Integer> timeLine=new TreeSet<Integer>();
	HashMap<Integer,Integer> hit=new HashMap<Integer,Integer>();
	int cur=-1;
	int count=0;
    /** Initialize your data structure here. */
    public HitCounter() {
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(cur==-1){
        	cur=timestamp;
        	count=1;
        }
        else if(cur!=timestamp){
        	timeLine.add(cur);
        	hit.put(cur, count);
        	cur=timestamp;
        	count=1;
        }
        else{
        	count++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	int result=0;
		SortedSet<Integer> sub=timeLine.subSet(timestamp-299, timestamp+1);
    	if(timestamp-300<cur){
    		result+=count;
    	}
    	for(int time:sub){
			result+=hit.get(time);
    	}
        return result;
    }
}
