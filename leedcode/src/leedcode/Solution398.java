package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution398 {

	int[] nums;
	Random rn=new Random();
    public Solution398(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
    	int count=0;
    	int result=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==target){
    			if(rn.nextInt(++count)==0)
    				result=i;
    		}
    	}
    	
    	
    	return result;
    }
}
