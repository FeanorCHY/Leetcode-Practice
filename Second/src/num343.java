
public class num343 {

    //dynamic programming O(N^2)
    // public int integerBreak(int n) {
    //     int dp[]=new int[n+1];
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         for(int j=1;j<=i/2;j++){
    //             dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
    //         }
    //         if(i<n)
    //             dp[i]=Math.max(dp[i],i);
    //     }
    //     return dp[n];
    // }
    
    //O(N)
    // public int integerBreak(int n) {
    //     int dp[]=new int[n+1];
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         if(i<=6)
    //             dp[i]=(i>>1)*(i-(i>>1));
    //         else
    //             dp[i]=3*dp[i-3];
    //     }
    //     return dp[n];
    // }
    
    //O(logN)
    public int integerBreak(int n) {
        if(n == 2)
            return 1;
        else if(n == 3)
            return 2;
        else if(n%3 == 0)
            return (int)Math.pow(3, n/3);
        else if(n%3 == 1)
            return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
        else 
            return 2 * (int) Math.pow(3, n/3);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
