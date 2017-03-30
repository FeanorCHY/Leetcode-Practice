package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {

	HashMap<Integer,Integer> map;
	ArrayList<Integer> arr;
	Random ran;
	int len;
    /** Initialize your data structure here. */
    public RandomizedSet() {
    	map=new HashMap<Integer,Integer>();
    	arr=new ArrayList<Integer>();
    	ran=new Random();
    	len=0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(map.containsKey(val))
    		return false;
    	else{
    		map.put(val,len++);
    		arr.add(val);
    		return true;
    	}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val))
    		return false;
    	else{
    		arr.set(map.get(val),arr.get(arr.size()-1));
    		map.put(arr.get(arr.size()-1), map.get(val));
    		map.remove(val);
    		arr.remove(arr.size()-1);
    		len--;
    		return true;
    	}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(ran.nextInt(len));
        
    }
}
