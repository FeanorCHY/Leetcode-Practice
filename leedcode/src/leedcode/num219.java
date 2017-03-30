package leedcode;

import java.util.HashSet;

public class num219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashSet<Integer> set=new HashSet<Integer>();
    	k++;
    	for(int i=0;i<Math.min(k, nums.length);i++){
    		if(set.contains(nums[i]))
    			return true;
    		else
    			set.add(nums[i]);
    	}
    	if(nums.length<=k)
    		return false;
    	for(int i=k;i<nums.length;i++){
    		set.remove(new Integer(nums[i-k]));
    		if(set.contains(nums[i]))
    			return true;
    		else
    			set.add(nums[i]);
    	}
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
