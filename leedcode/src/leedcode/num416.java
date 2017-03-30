package leedcode;

import java.util.Arrays;

public class num416 {
	public boolean canPartition(int[] nums) {
		int sum=0;
		for(int each:nums){
			sum+=each;
		}
		if(sum%2==1)
			return false;
		sum=sum/2;
		boolean[] dp=new boolean[sum+1];
		dp[0]=true;
		for(int i=0;i<nums.length;i++){
			for(int j=sum;j>=nums[i];j--){
				dp[j]=dp[j]||dp[j-nums[i]];
			}
			if(dp[sum])
				return true;
		}
		return dp[sum];
    }
	public static void main(String[] args) {
		int test[]={3,3,3,4,5};
		num416 sol=new num416();
		System.out.println(sol.canPartition(test));
	}

}




//int[] nums;
//int target;
//public boolean canPartition(int[] nums) {
//	int sum=0;
//	for(int each:nums){
//		sum+=each;
//	}
//	if(sum%2==1)
//		return false;
//	sum=sum/2;
//	Arrays.sort(nums);
//	this.nums=nums;
//	target=sum;
//	if(nums[nums.length-1]==target)
//		return true;
//	else if(nums[nums.length-1]>target)
//		return false;
//	return sumSearch(0,0);
//}
//private boolean sumSearch(int begin,int cur){
//	for(int i=begin;i<nums.length;i++){
//		if(cur+nums[i]==target)
//			return true;
//		else if(cur+nums[i]>target)
//			return false;
//		else if(sumSearch(i+1,cur+nums[i]))
//			return true;
//			
//	}
//	return false;
//}