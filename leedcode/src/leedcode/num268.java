package leedcode;

public class num268 {
    public int missingNumber(int[] nums) {
    	int sum=0;
    	boolean zero=false;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0)
    			zero=true;
    		sum+=nums[i];
    	}
    	if(zero==false)
    		return 0;
    	int real=(0+nums.length)*(nums.length+1)/2;
        return real-sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
