import java.util.Arrays;

public class num377 {

    //recursive failed TLE
    // int[] nums;
    // int target;
    // int res=0;
    // boolean visit[];
    // public int combinationSum4(int[] nums, int target) {
    //     if(nums==null|nums.length==0)
    //         return 0;
    //     this.nums=nums;
    //     this.target=target;
    //     Arrays.sort(nums);
    //     search(-1,0);
    //     return res;
    // }
    // private void search(int pre,int sum){
    //     for(int i=0;i<nums.length;i++){
    //         if(pre==i)
    //             continue;
    //         int max=(target-sum)/nums[i];
    //         for(int k=1;k<=max;k++){
    //             if(sum+nums[i]*k>target)
    //                 break;
    //             if(sum+nums[i]*k==target){
    //                 res++;
    //                 break;
    //             }
    //             search(i,sum+nums[i]*k);
    //         }
            
    //     }
    // }
    
    
    
    
    // //recursive with dp failed TLE
    // int[] nums;
    // int target;
    // int res=0;
    // int[][] dp;
    // boolean visit[];
    // public int combinationSum4(int[] nums, int target) {
    //     if(nums==null|nums.length==0)
    //         return 0;
    //     this.nums=nums;
    //     this.target=target;
    //     dp=new int[nums.length+1][target+1];
    //     search(nums.length,0);
    //     return res;
    // }
    // private void search(int pre,int sum){
    //     if(dp[pre][target-sum]>0){
    //         res+=dp[pre][target-sum];
    //         return;
    //     }
    //     int tem=res;
    //     for(int i=0;i<nums.length;i++){
    //         if(pre==i)
    //             continue;
    //         int max=(target-sum)/nums[i];
    //         for(int k=1;k<=max;k++){
    //             if(sum+nums[i]*k>target)
    //                 break;
    //             if(sum+nums[i]*k==target){
    //                 res++;
    //                 continue;
    //             }
    //             search(i,sum+nums[i]*k);
    //         }
    //     }
    //     dp[pre][target-sum]=res-tem;
    // }
    
    
    
    
    //recursive with HashMap Space O(N)
    // int[] nums;
    // int res=0;
    // HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    // public int combinationSum4(int[] nums, int target) {
    //     if(nums==null|nums.length==0)
    //         return 0;
    //     this.nums=nums;
    //     search(target);
    //     return map.get(target);
    // }
    // private void search(int rem){
    //     int tem=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]==rem)
    //             tem++;
    //         else if(nums[i]<rem){
    //             if(!map.containsKey(rem-nums[i]))
    //                 search(rem-nums[i]);
    //             tem+=map.get(rem-nums[i]);
    //         }
    //     }
    //     map.put(rem,tem);
    // }
 
    //recursive with dp Time O(kN) Space O(N)
    // int[] nums;
    // int res=0;
    // int[] dp;
    // public int combinationSum4(int[] nums, int target) {
    //     if(nums==null|nums.length==0)
    //         return 0;
    //     this.nums=nums;
    //     this.dp=new int[target+1];
    //     Arrays.fill(dp,-1);
    //     search(target);
    //     return dp[target];
    // }
    // private void search(int rem){
    //     int tem=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]==rem)
    //             tem++;
    //         else if(nums[i]<rem){
    //             if(dp[rem-nums[i]]<0)
    //                 search(rem-nums[i]);
    //             tem+=dp[rem-nums[i]];
    //         }
    //     }
    //     dp[rem]=tem;
    // }   
    
    
    
    
    
    //recursive with dp bottom up Time O(kN) Space O(N)
    public int combinationSum4(int[] nums, int target) {
        if(nums==null|nums.length==0)
            return 0;
        int[] dp=new int[target+1];
        Arrays.sort(nums);
        Arrays.fill(dp,-1);
        for(int i=1;i<=target;i++){
            dp[i]=0;
            for(int each:nums){
                if(each==i)
                    dp[i]++;
                else if(each<i){
                    if(dp[i-each]>0)
                        dp[i]+=dp[i-each];
                }
                else
                    break;
            }
        }
        return dp[target];
    }
	public static void main(String[] args) {
		int[] test={1,2,3};
		num377 sol=new num377();
		sol.combinationSum4(test, 4);
	}

}
