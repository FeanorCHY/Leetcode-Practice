package leedcode;

public class num41 {
    public int firstMissingPositive(int[] nums) {
    	if(nums.length==0)
    		return 1;
    	if(nums.length==1)
    	{
    		if(nums[0]==1)
    			return 2;
    		else
    			return 1;
    	}
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]>0){
    			if(nums[i]!=i+1){
    				if(nums[i]<nums.length)
    				if(nums[nums[i]-1]!=nums[i]){
		    			int tem=nums[nums[i]-1];
		    			nums[nums[i]-1]=nums[i];
		    			nums[i]=tem;
		    			i--;
    				}
    			}
    		}
    	}
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]!=i+1)
    			return i+1;
    	}
    	return nums.length+1;
    }
	public static void main(String[] args) {
		int[] test={2,1};
		System.out.println((new num41()).firstMissingPositive(test));
	}

}
