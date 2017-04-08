import java.util.Arrays;
import java.util.HashSet;

public class num416 {
	//brute force search with caching. lucky to acc
    // int sum=0;
    // int[] nums;
    // HashSet<Integer> set=new HashSet<Integer>();
    // public boolean canPartition(int[] nums) {
    //     for(int num:nums)
    //         sum+=num;
    //     if(sum%2==1)
    //         return false;
    //     sum/=2;
    //     for(int num:nums){
    //         if(num==sum)
    //             return true;
    //         else if(num>sum)
    //             return false;
    //     }
    //     Arrays.sort(nums);
    //     this.nums=nums;
    //     return search(0,0);
    // }
    // private boolean search(int idx,int cur){
    //     set.add(cur);
    //     for(int i=idx;i<nums.length;i++){
    //         if(nums[i]+cur>sum){
    //             if(set.contains(nums[i]+cur-sum))
    //                 return true;
    //             break;
    //         }
    //         else if(nums[i]+cur==sum)
    //             return true;
    //         else if(search(i+1,cur+nums[i]))
    //             return true;
    //     }
    //     set.remove(cur);
    //     return false;
    // }
    
    
    //dynamic programming Time O(n*sum) Space(n*sum)
    // public boolean canPartition(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return true;
    //     int sum=0;
    //     for(int num:nums)
    //         sum+=num;
    //     if(sum%2==1)
    //         return false;
    //     sum/=2;
    //     for(int num:nums){
    //         if(num==sum)
    //             return true;
    //         else if(num>sum)
    //             return false;
    //     }
    //     boolean dp[][]=new boolean[nums.length][sum+1];
    //     int cur=nums[0];
    //     dp[0][0]=true;
    //     dp[0][nums[0]]=true;
    //     for(int i=1;i<nums.length;i++){
    //         cur+=nums[i];
    //         dp[i][0]=true;
    //         for(int j=1;j<=Math.min(sum,cur);j++){
    //             if(dp[i-1][j])
    //                 dp[i][j]=true;
    //             else if(j>=nums[i]&&dp[i-1][j-nums[i]])
    //                 dp[i][j]=true;
    //         }
    //     }
    //     return dp[dp.length-1][sum];
    // }
    
    
    
    //optimized dynamic programming Time O(n*sum) Space(sum)
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0)
            return true;
        int sum=0;
        for(int num:nums)
            sum+=num;
        if(sum%2==1)
            return false;
        sum/=2;
        for(int num:nums){
            if(num==sum)
                return true;
            else if(num>sum)
                return false;
        }
        boolean dp[]=new boolean[sum+1];
        int cur=0;
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            for(int j=Math.min(sum,cur);j>=1;j--){//remember to go from the end of array
                if(j>=nums[i]&&dp[j-nums[i]])
                    dp[j]=true;
            }
        }
        return dp[sum];
    }
	public static void main(String[] args) {
		int[] test=
			{2,2,3,5};
//			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,97,95};
		num416 sol=new num416();
		System.out.println(sol.canPartition(test));
	}

}
