package leedcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class num349 {
    public int[] intersection(int[] nums1, int[] nums2) {
    	List<Integer> list=new ArrayList<Integer>();
    	HashSet<Integer> set=new HashSet<Integer>();
    	for(int each:nums1){
    		set.add(each);
    	}
    	for(int i=0;i<nums2.length;i++){
    		if(set.contains(nums2[i])){
    			set.remove(nums2[i]);
    			list.add(nums2[i]);
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
