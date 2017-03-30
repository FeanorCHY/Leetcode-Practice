	
public class num213 {

    //two pass dynamic programming O(N), Space O(N)
    // public int rob(int[] nums) {
    //     int max=0;
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int[] dp=new int[nums.length];
    //     for(int i=0;i<nums.length-1;i++){
    //         if(i<=1){
    //             dp[i]=nums[i];
    //         }
    //         else if(i==2)
    //             dp[i]=nums[i]+dp[i-2];
    //         else{
    //             dp[i]=nums[i]+Math.max(dp[i-2],dp[i-3]);
    //         }
    //         max=Math.max(dp[i],max);
    //     }
    //     dp=new int[nums.length];
    //     for(int i=0;i<nums.length;i++){
    //         if(i<=2){
    //             dp[i]=nums[i];
    //         }
    //         else if(i==3)
    //             dp[i]=nums[i]+dp[i-2];
    //         else{
    //             dp[i]=nums[i]+Math.max(dp[i-2],dp[i-3]);
    //         }
    //         max=Math.max(dp[i],max);
    //     }
    //     return max;
    // }
    
    
    
    
    //two pass dynamic programming O(N), Space O(1)
    public int rob(int[] nums) {
        int max=0;
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int inc=0,ex=0;
        for(int i=0;i<nums.length-1;i++){
            int in=inc,e=ex;
            inc=e+nums[i];
            ex=Math.max(e,in);
        }
        max=Math.max(inc,ex);
        inc=0;
        ex=0;
        for(int i=1;i<nums.length;i++){
            int in=inc,e=ex;
            inc=e+nums[i];
            ex=Math.max(e,in);
        }
        max=Math.max(max,Math.max(inc,ex));
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
