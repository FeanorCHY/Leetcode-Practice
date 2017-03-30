package leedcode;

public class num35 {
    public int searchInsert(int[] nums, int target) {
    	int low=0;
    	int high=nums.length-1;
    	int mid=(low+high)/2;
    	int value=nums[mid];
    	while(low<=high&&value!=target){
    		if(value<target)
    		{
    			low=mid+1;
    		}
    		else{
    			high=mid-1;
    		}
    		mid=(low+high)/2;
    		value=nums[mid];
    	}
    	if(value==target)
    		return mid;
    	else
    		return low;
    	
    	
    }

	public static void main(String[] args) {
		num35 sol=new num35();
		int[] test={1};
		sol.searchInsert(test, 2);
	}

}
