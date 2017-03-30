package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num350 {
    public int[] intersect(int[] nums1, int[] nums2) {
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int i=0;i<nums1.length;i++){
    		map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
    	}
    	List<Integer> list=new ArrayList<Integer>();
    	for(int each:nums2){
    		if(map.getOrDefault(each, 0)>0){
    			list.add(each);
    			map.put(each, map.get(each)-1);
    		}
    	}
    	int[] res=new int[list.size()];
    	for(int i=0;i<list.size();i++){
    		res[i]=list.get(i);
    	}
    	
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
