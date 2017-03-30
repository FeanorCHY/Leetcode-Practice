package leedcode;

import java.util.Arrays;

public class num462 {
    public int minMoves2(int[] nums) {
    	Arrays.sort(nums);
    	int res=0;
    	for(int each:nums){
    		res+=Math.abs(each-nums[nums.length/2]);
    	}
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
