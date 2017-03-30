
public class num062 {

    //constant space
    //using formula
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number 
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int)res;
    }
    
    //using dynamic programming
    //Space O(N)
    // public int uniquePaths(int m, int n) {
    //     if(m<=0||n<=0)
    //         return 0;
    //     int[] dp=new int[n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i==0||j==0)
    //                 dp[j]=1;
    //             else{
    //                 dp[j]=dp[j]+dp[j-1];
    //             }
    //         }
    //     }
    //     return dp[n-1];
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
