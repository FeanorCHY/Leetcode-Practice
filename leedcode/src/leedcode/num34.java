package leedcode;

import java.util.Arrays;

public class num34 {

    public int[] searchRange(int[] nums, int target) {
		int result[]={-1,-1};
    	int low=0;
    	int high=nums.length-1;
    	int mid=(low+high)/2;
    	int value=nums[mid];
    	while(low<high&&value!=target)
    	{
    		if(value>target)
    			high=mid-1;
    		else
    			low=mid+1;
    		mid=(low+high)/2;
    		value=nums[mid];
    	}
    	if(value!=target)
    	{
    		return result;
    	}
    	int middle=mid;
    	low=mid;
    	high=nums.length-1;
    	mid=(low+high)/2;
    	value=nums[mid];
    	if(mid==nums.length-1)
    	{
    		if(value==target)
    			result[1]=nums.length-1;
    	}
    	else
    	{
    		if(nums[nums.length-1]==target){
	    		result[1]=nums.length-1;
	    	}
	    	else{
	//    		int last=nums[mid-1];
	    		int next=nums[mid+1];
	        	while(!(value==target&&next>target)&&low<high){
	        		if(value==target){
	        			low=mid+1;
	        		}
	        		else if(value>target){
	        			high=mid-1;
	        		}
	        		mid=(low+high)/2;
	        		value=nums[mid];
	//        		last=nums[mid-1];
	        		next=nums[mid+1];
	        	}
	        	result[1]=mid;
	    	}
    	}
//    	if(mid==0){
//    		result[0]=mid;
//    		result[1]=mid;
//    		return result;
//    	}
    	high=middle;
    	low=0;
    	mid=(low+high)/2;
    	value=nums[mid];
    	if(mid==0)
    	{
    		if(value==target)
    			result[0]=0;
    		else if(high==1)
    			result[0]=1;
    	}
    	else{
	    	if(nums[0]==target){
	    		result[0]=0;
	    	}
	    	else{
	    		int last=nums[mid-1];
	        	while(!(value==target&&last<target)&&low<high){
	        		if(value==target){
	        			high=mid-1;
	        		}
	        		else if(value<target){
	        			low=mid+1;
	        		}
	        		mid=(low+high)/2;
	        		value=nums[mid];
	        		last=nums[mid-1];
	//        		next=nums[mid+1];
	        	}
	        	result[0]=mid;
	    		
	    	}
    	}
        return result;
    }
	public static void main(String[] args) {
		num34 sol=new num34();
		int[] test={1,4};
		int result[]=sol.searchRange(test, 4);
		System.out.println(Arrays.toString(result));
	}

}
