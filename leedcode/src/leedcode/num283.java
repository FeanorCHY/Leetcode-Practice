package leedcode;

public class num283 {
    public void moveZeroes(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=0)
        		nums[idx++]=nums[i];
        }
        while(idx<nums.length)
        	nums[idx++]=0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
