package leedcode;

public class num312 {
    public int maxCoins(int[] input) {
    	if(input.length==0)
    		return 0;
    	int[] nums=new int[input.length+2];
    	nums[0]=1;
    	nums[nums.length-1]=1;
    	for(int i=0;i<input.length;i++)
    		nums[i+1]=input[i];
    	int[][] dp=new int[nums.length][nums.length];
    	for(int gap=1;gap<=input.length+1;gap++){
    		for(int lo=0;lo<nums.length-gap;lo++){
    			int hi=lo+gap;
    			for(int k=lo+1;k<hi;k++){
    				dp[lo][hi]=Math.max(dp[lo][hi], nums[lo]*nums[k]*nums[hi]+dp[lo][k]+dp[k][hi]);
    			}
    		}
    	}
        return dp[0][dp.length-1];
    }
	public static void main(String[] args) {
		int test[]={3,1,5,8};
		num312 sol=new num312();
		System.out.println(sol.maxCoins(test));
	}

}
