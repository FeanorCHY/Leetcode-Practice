package leedcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PhoneDirectory {

	int maxNumbers;
	Queue<Integer> pool=new LinkedList<Integer>();
	boolean used[];
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers=maxNumbers;
        for(int i=0;i<maxNumbers;i++){
        	pool.add(i);
        }
        used=new boolean[maxNumbers];
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
    	if(pool.isEmpty())
    		return -1;
    	int tel=pool.remove();
    	used[tel]=true;
        return tel;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
    	
    	
        return !used[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
    	if(used[number]){
	        pool.add(number);
	        used[number]=false;
    	}
    }
}
