package leedcode;

public class num153 {
    public int findMin(int[] nums) {
    	int high=nums.length-1;
    	int low=0;
    	int mid=(low+high)/2;
    	while(low<high){
    		if(nums[mid]>=nums[low]){
    			if(nums[mid]>nums[high]){
    				low=mid+1;
    			}
    			else{
    				return nums[low];
    			}
    		}
    		else{
				high=mid;
    		}
    		mid=(low+high)/2;
    	}
    	return nums[low];
    }
	public static void main(String[] args) {
		int test[]={3,1,2};
		num153 sol=new num153();
		sol.findMin(test);
	}

}
