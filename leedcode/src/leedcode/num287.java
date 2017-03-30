package leedcode;

public class num287 {
    public int findDuplicate(int[] nums) {
    	for(int i=0;i<nums.length-1;i++){
			while(nums[i]-1!=i){
				if(nums[nums[i]-1]==nums[i])
    				return nums[i];
				int tem=nums[i];
				nums[i]=nums[nums[i]-1];
				nums[tem-1]=tem;
    		}
    	}
    	
        return nums[nums.length-1];
    }
	public static void main(String[] args) {
		int[] test={3,2,2,2,4};
		num287 sol=new num287();
		System.out.println(sol.findDuplicate(test));
	}

}
