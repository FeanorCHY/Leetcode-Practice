package leedcode;

public class num414 {
    public int thirdMax(int[] nums) {
    	long fake=0;
    	long last=(long)Integer.MAX_VALUE+1;
    	long max=(long)Integer.MIN_VALUE-1;
    	for(int k=0;k<3;k++){
    		max=(long)Integer.MIN_VALUE-1;
    		for(int i=0;i<nums.length;i++){
    			if(nums[i]<last)
    				max=Math.max(max, nums[i]);
    		}
    		if(max<Integer.MIN_VALUE)
    			return (int)fake;
    		last=max;
    		if(k==0)
    			fake=max;
    	}
    	
        return (int)max;
    }
	public static void main(String[] args) {
	}

}
