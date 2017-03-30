package leedcode;

public class num33 {

    public int search(int[] nums, int target) {
//    	int pivot;
    	int high=nums.length-1;
    	int low=0;
    	int mid=(low+high)/2;
    	int value=nums[mid];
    	boolean ordered=false;
    	while(!(low>=high&&target==value)){
    		if(low>=high)
    			return -1;
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
	    					return low;
	    			}
	    			else if(target>value){
	    				low=mid+1;
	    			}
	    			else
	    				return mid;
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
	    					return high;
	    			}
	    			else if(target<value){
	    				high=mid-1;
	    			}
	    			else
	    				return mid;
	    		}
	    		else{
	    			if(nums[low]==target)
	    				return low;
	    			else if(nums[high]==target)
	    				return high;
	    			else
	    				return -1;
	    		}
    		}
    		else{
    			if(value>target)
    				high=mid-1;
    			else if(value<target)
    				low=mid+1;
    			else
    				return mid;
    		}
        	mid=(low+high)/2;
        	value=nums[mid];
    	}
    	if(target==nums[mid])
    		return mid;
    	else
    		return -1;
    }
	public static void main(String[] args) {
		int[] test1={4,5,6,7,8,0,1,2};
		int[] test2={7,8,0,1,2,4,5,6};
		int[] test3={5,1,3};
		num33 sol=new num33();
		System.out.println(sol.search(test3, 1));
	}

}
