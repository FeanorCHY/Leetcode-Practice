package leedcode;

public class num162 {
    public int findPeakElement(int[] nums) {
    	if(nums.length==0||nums.length==1)
    		return 0;
    	int low=0;
    	int high=nums.length-1;
    	int mid=(low+high)/2;
    	while(low<=high){
    		if(mid==low){
    			if(nums[high]>nums[mid])
    				return high;
    			else
    				return mid;
    		}
    		else{
    			if(nums[mid]>nums[mid-1]){
    				if(nums[mid]>nums[mid+1])
    					return mid;
    				else
    					low=mid+1;
    			}
    			else{
    				high=mid-1;
    			}
    		}
    		mid=(low+high)/2;
    	}
    	
        return 0;
    }
	public static void main(String[] args) {
		int[] test={0,1,3,2,1,4};
		num162 sol=new num162();
		System.out.println(sol.findPeakElement(test));
	}

}
