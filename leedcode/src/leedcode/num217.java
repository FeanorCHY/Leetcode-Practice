package leedcode;

import java.util.HashSet;

public class num217 {
    public boolean containsDuplicate(int[] nums) {
    	HashSet<Integer> set=new HashSet<Integer>();
    	for(int i=0;i<nums.length;i++){
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
