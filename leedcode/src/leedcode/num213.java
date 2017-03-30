package leedcode;

public class num213 {
    public int rob(int[] nums) {
    	if(nums.length==0)
    		return 0;
    	if(nums.length==1)
    		return nums[0];
    	if(nums.length==2)
    		return Math.max(nums[0],nums[1]);
    	int dp[]=new int[nums.length];
    	dp[0]=nums[0];
    	dp[1]=nums[1];
    	for(int i=2;i<nums.length-1;i++){
    		if(i==2){
    			dp[i]=nums[i]+dp[i-2];
    		}
    		else{
    			dp[i]=nums[i]+Math.max(dp[i-2], dp[i-3]);
    		}
    	}
    	int result1=Math.max(dp[dp.length-3], dp[dp.length-2]);
    	dp[1]=nums[1];
    	dp[2]=nums[2];
    	for(int i=3;i<nums.length;i++){
    		if(i==3){
    			dp[i]=nums[i]+dp[1];
    		}
    		else{
    			dp[i]=nums[i]+Math.max(dp[i-2], dp[i-3]);
    		}
    	}
    	int result2=Math.max(dp[dp.length-2], dp[dp.length-1]);
    	return Math.max(result1, result2);
    }
	public static void main(String[] args) {
//		System.out.println(-5%4);
		num213 sol=new num213();
		int[] test={1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		System.out.println(sol.rob(test));
	}
	

}

//if(nums.length==0)
//	return 0;
//if(nums.length==1)
//	return nums[0];
//if(nums.length==2)
//	return Math.max(nums[0], nums[1]);
//if(nums.length==3){
//	return Math.max(Math.max(nums[0], nums[1]), nums[2]);
//}
//for(int i=0;i<nums.length-2;i++){
//	if(Math.abs((i-3+nums.length)%nums.length-i)>1){
//		nums[i]=nums[i]+Math.max(nums[(i-2+nums.length)%nums.length], nums[(i-3+nums.length)%nums.length]);
//		if(Math.abs((i-3+nums.length)%nums.length-i)==2){
//			nums[(i-3+nums.length)%nums.length]=0;
//		}
//	}
//	else if(Math.abs((i-3+nums.length)%nums.length-i)==1)
//		nums[i]=nums[i]+nums[(i-2+nums.length)%nums.length];
//		
//}
//
//return Math.max(nums[(2*nums.length-3)%nums.length], nums[(2*nums.length-4)%nums.length]);