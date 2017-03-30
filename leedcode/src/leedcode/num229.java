package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num229 {
	public List<Integer> majorityElement(int[] nums) {
	    List<Integer> result = new ArrayList<Integer>();
	    if(nums.length==0){
	    	return result;
	    }
	    int n1=nums[0];
	    int n2=-1;
	    int count1=1;
	    int count2=0;
	    if(nums.length==1){
	    	result.add(n1);
	    	return result;
	    }
	    for(int i=1;i<nums.length;i++){
	    	if(n1==nums[i]){
	    		count1++;
	    	}
	    	else if(n2==nums[i])
	    		count2++;
	    	else if(count1==0){
	    		count1=1;
	    		n1=nums[i];
	    	}
	    	else if(count2==0){
	    		count2=1;
	    		n2=nums[i];
	    	}
	    	else{
	    		count1--;
	    		count2--;
	    	}
	    }
	    count1=0;
	    count2=0;
	    for(int each:nums){
	    	if(each==n1)
	    		count1++;
	    	if(each==n2)
	    		count2++;
	    }
	    if(count1>nums.length/3)
	    	result.add(n1);
	    if(count2>nums.length/3)
	    	result.add(n2);
	 
	    return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
