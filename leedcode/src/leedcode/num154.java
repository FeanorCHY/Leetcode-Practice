package leedcode;

public class num154 {

    public int findMin(int[] nums) {
    	int high=nums.length-1;
    	int low=0;
    	int mid=(low+high)/2;
    	while(low<high){
    		if(nums[mid]>nums[low]||low==mid){
    			if(nums[mid]>nums[high]){
    				low=mid+1;
    			}
    			else{
    				return nums[low];
    			}
    		}
    		else{
    			if(nums[low]==nums[high]){
    				int lowest=nums[low];
    				for(int j =low+1;j<high;j++){
    					if(lowest>nums[j])
    						lowest=nums[j];
    					
    				}
    				return lowest;
    			}
    			else if(nums[mid]==nums[low]){
    				if(nums[mid]<nums[high])
    					return nums[low];
    				else
    					low=mid+1;
    			}
    			else
    				high=mid;
    		}
    		mid=(low+high)/2;
    	}
    	return nums[low];
    }
	public static void main(String[] args) {
		int test[]={3,1,3};
		num154 sol=new num154();
		sol.findMin(test);

	}

}
