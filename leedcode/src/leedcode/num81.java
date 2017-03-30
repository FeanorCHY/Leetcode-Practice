package leedcode;

public class num81 {
    public boolean search(int[] nums, int target) {

//    	int pivot;
    	int high=nums.length-1;
    	int low=0;
    	int mid=(low+high)/2;
    	int value=nums[mid];
    	boolean ordered=false;
    	if(nums[high]==nums[low]&&nums[low]==value){
    		for(int i=0;i<nums.length;i++){
    			if(nums[i]==target)
    				return true;
    		}
    		return false;
    	}
    	
    	while(!(low>=high&&target==value)){
    		if(low>=high)
    			return false;
    		if(!ordered){
	    		if(value>nums[low]){
	    			if(target<value){
	    				if(target>nums[low]){
		    				ordered=true;
		    				high=mid-1;
	    				}
	    				else if(target<nums[low]){
	    					low=mid+1;
	    				}
	    				else
	    					return true;
	    			}
	    			else if(target>value){
	    				low=mid+1;
	    			}
	    			else
	    				return true;
	    		}
	    		else if(value<nums[low]){
	    			if(target>value){
	    				if(target<nums[high]){
		    				ordered=true;
		    				low=mid+1;
	    				}
	    				else if(target>nums[high]){
//	    	    			if(mid==low)
//	    	    				low=mid+1;
//	    	    			else
	    	    				high=mid-1;
	    				}
	    				else
	    					return true;
	    			}
	    			else if(target<value){
	    				high=mid-1;
	    			}
	    			else
	    				return true;
	    		}
	    		else{
	    			if(low==mid){
		    			if(nums[low]==target)
		    				return true;
		    			else if(nums[high]==target)
		    				return true;
		    			else
		    				return false;
	    			}
	    			else{
	    				if(nums[high]!=nums[low]){
		    				if(value==target)
		    					return true;
		    				else
		    					low=mid+1;
	    				}
	    				else{
	    					low++;
	    				}
	    			}
	    		}
    		}
    		else{
    			if(value>target)
    				high=mid-1;
    			else if(value<target)
    				low=mid+1;
    			else
    				return true;
    		}
        	mid=(low+high)/2;
        	value=nums[mid];
    	}
    	if(target==nums[mid])
    		return true;
    	else
    		return false;
    }
	public static void main(String[] args) {
		int[] test1={4,5,6,7,8,0,1,2};
		int[] test2={7,8,0,1,2,4,5,6};
		int[] test3={1,3,1,1,1};
		num81 sol=new num81();
		System.out.println(sol.search(test3, 3));
	}

}
