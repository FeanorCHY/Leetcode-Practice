import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num368 {

    //O(N^2) Space O(N)
    // public List<Integer> largestDivisibleSubset(int[] nums) {
    //     List<Integer> res=new LinkedList<Integer>();
    //     if(nums==null||nums.length==0)
    //         return res;
    //     Arrays.sort(nums);
    //     int max=1;
    //     int pos=0;
    //     int[] dp=new int[nums.length];
    //     dp[0]=1;
    //     for(int i=1;i<nums.length;i++){
    //         dp[i]=1;
    //         for(int j=i-1;j>=0;j--){
    //             if(nums[i]%nums[j]==0)
    //                 dp[i]=Math.max(dp[i],dp[j]+1);
    //         }
    //         if(dp[i]>max){
    //             max=dp[i];
    //             pos=i;
    //         }
    //     }
    //     max--;
    //     int last=nums[pos];
    //     res.add(nums[pos]);
    //     for(int i=pos-1;i>=0;i--){
    //         if(last%nums[i]==0&&dp[i]==max){
    //             max--;
    //             res.add(nums[i]);
    //             last=nums[i];
    //         }
    //     }
    //     return res;
    // }
    
    
    
    
    
    
    //with another array O(N^2) Space O(N)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new LinkedList<Integer>();
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        int max=1;
        int pos=0;
        int[] dp=new int[nums.length];
        int[] pre=new int[nums.length];
        dp[0]=1;
        pre[0]=-1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            pre[i]=-1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0&&dp[j]+1>dp[i]){
                    pre[i]=j;
                    dp[i]=dp[j]+1;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                pos=i;
            }
        }
        while(pos!=-1){
            res.add(nums[pos]);
            pos=pre[pos];
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
