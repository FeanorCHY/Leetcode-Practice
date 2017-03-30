package leedcode;

public class num334 {
    public boolean increasingTriplet(int[] nums) {
    	if(nums.length<=2)
    		return false;
    	int first=Integer.MIN_VALUE;
    	int second=Integer.MIN_VALUE;
    	for(int i=1;i<nums.length;i++){
    		if(first==Integer.MIN_VALUE){
				if(nums[i]>nums[i-1]){
					first=nums[i-1];
					second=nums[i];
				}
    		}
    		else{
    			if(nums[i]<first){
    				first=nums[i];
    			}
    			else if(nums[i]>first&&nums[i]<second)
    				second=nums[i];
    			else if(nums[i]>second)
    				return true;
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
		int[] test={0,4,2,1,0,-1,-3};
		num334 sol=new num334();
		System.out.println(sol.increasingTriplet(test));
	}

}
