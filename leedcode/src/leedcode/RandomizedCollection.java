package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedCollection {

	HashMap<Integer,HashSet<Integer>> map;
//	HashMap<Integer,HashMap<Integer,Integer>> map2;
	ArrayList<Integer> arr;
	Random ran;
	int len;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
    	map=new HashMap<Integer,HashSet<Integer>>();
//    	map2=new HashMap<Integer,HashMap<Integer,Integer>>();
    	arr=new ArrayList<Integer>();
    	ran=new Random();
    	len=0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(map.containsKey(val)){
    		map.get(val).add(len++);
//    		map2.get(val).put(map2.get(val).size(),len );
    		arr.add(val);
    		return false;
    	}
    	else{
    		HashSet<Integer> tem=new HashSet<Integer>();
//    		HashMap<Integer,Integer> tem2=new HashMap<Integer,Integer>();
    		tem.add(len++);
//    		tem2.put(0,len++);
    		map.put(val,tem);
//    		map2.put(val,tem2);
    		arr.add(val);
    		return true;
    	}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val))
    		return false;
    	else if(arr.get(arr.size()-1)==val){
    		if(map.get(val).size()==1)
    			map.remove(val);
    		else
        		map.get(val).remove(arr.size()-1);
    		
    		arr.remove(arr.size()-1);
    		len--;
    		return true;
    	}
    	else{
    		int index=map.get(val).iterator().next();
    		arr.set(index,arr.get(arr.size()-1));
    		map.get(arr.get(arr.size()-1)).add(index);
    		map.get(arr.get(arr.size()-1)).remove(arr.size()-1);
    		if(map.get(val).size()==1)
    			map.remove(val);
    		else{
    			map.get(val).remove(index);
    		}
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
