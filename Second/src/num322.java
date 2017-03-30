import java.util.Arrays;

public class num322 {
    
    //dynamic programming with another approach
    //O(NK)
    // public int coinChange(int[] coins, int amount) {
    //     if(amount==0)
    //         return 0;
    //     if(coins==null||coins.length==0)
    //         return -1;
    //     int[] dp=new int[amount+1];
    //     for(int i=1;i<=amount;i++){
    //         int min=Integer.MAX_VALUE;
    //         for(int coin:coins){
    //             if(coin>i||dp[i-coin]==-1)
    //                 continue;
    //             min=Math.min(min,dp[i-coin]+1);
    //         }
    //         if(min==Integer.MAX_VALUE)
    //             min=-1;
    //         dp[i]=min;
    //     }
    //     // System.out.println(Arrays.toString(dp));
    // 	return dp[amount];
    // }
    
    
    
    
    //backtracking
    int[] dp;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        if(coins==null||coins.length==0)
            return -1;
        // Arrays.sort(coins);
        this.coins=coins;
        dp=new int[amount+1];
        search(amount);
        return dp[amount];
    }
    private int search(int left){
        if(left==0)
            return 0;
        if(dp[left]!=0)
            return dp[left];
        int res=Integer.MAX_VALUE;
        for(int each:coins){
            if(each>left)
                continue;
            int tem=search(left-each);
            if(tem>=0)
                res=Math.min(res,tem+1);
        }
        if(res==Integer.MAX_VALUE)
            res=-1;
        dp[left]=res;
        return res;
    }
    
    
    
    //Brute force with dynamic programming
    //O(N^2+K) failed TLE
    // public int coinChange(int[] coins, int amount) {
    //     if(amount==0)
    //         return 0;
    //     if(coins==null||coins.length==0)
    //         return -1;
    //     int[] dp=new int[amount+1];
    //     for(int i=0;i<coins.length;i++){
    //         if(coins[i]==amount)
    //             return 1;
    //         else if(coins[i]>amount)
    //             continue;
    //         dp[coins[i]]=1;
    //     }
    //     // System.out.println(Arrays.toString(dp));
    //     for(int i=1;i<=amount;i++){
    //         int min=Integer.MAX_VALUE;
    //         if(dp[i]==1)
    //             continue;
    //         for(int j=1;j<=i/2;j++){
    //             if(dp[j]<=0||dp[i-j]<=0)
    //                 continue;
    //             min=Math.min(min,dp[j]+dp[i-j]);
    //             if(min==2)
    //                 break;
    //         }
    //         if(min!=Integer.MAX_VALUE)
    //             dp[i]=min;
    //     }
    //     return dp[amount]==0?-1:dp[amount];
    // }
	public static void main(String[] args) {
		int[] test={186,419,83,408};
		num322 sol=new num322();
		System.out.println(sol.coinChange(test, 6249));
	}

}
