package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class num347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> list=new ArrayList<Integer>();
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int each:nums){
    		if(map.containsKey(each)){
    			map.replace(each, map.get(each)+1);
    		}
    		else{
    			map.put(each, 1);
    		}
    	}
    	List<Integer> val=new ArrayList(map.values());
    	Collections.sort(val);
//    	int high=val.get(val.size()-1);
    	int low=val.get(val.size()-k);
    	for(int each:map.keySet()){
    		if(map.get(each)>=low)
    			list.add(each);
    	}
    	
        return list;
    }
	public static void main(String[] args) {
		int[] test={1,1,1,2,2,3,3};
		num347 sol=new num347();
		System.out.println(sol.topKFrequent(test, 2));
	}

}
