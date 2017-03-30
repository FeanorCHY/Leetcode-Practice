package leedcode;

public class num485 {
    public int findMaxConsecutiveOnes(int[] nums) {
    	int count=0;
    	int max=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0){
    			max=Math.max(count, max);
    			count=0;
    		}
    		else
    			count++;
    	}
    	
        return Math.max(count, max);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
