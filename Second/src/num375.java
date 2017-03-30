
public class num375 {

    //recursive with dynamic programming
    // int[][] dp;
    // public int getMoneyAmount(int n) {
    //     dp=new int[n+1][n+1];
    //     return move(1,n);
    // }
    // private int move(int low,int high){
    //     if(low>=high)
    //         return 0;
    //     else if(low+1==high)
    //         return low;
    //     else if(low+2==high)
    //         return (low+high)/2;
    //     else{
    //         if(dp[low][high]>0)
    //             return dp[low][high];
    //         int min=Integer.MAX_VALUE;
    //         for(int i=low;i<=high;i++){
    //             min=Math.min(min,i+Math.max(move(low,i-1),move(i+1,high)));
    //         }
    //         dp[low][high]=min;
    //         return min;
    //     }
    // }
    
    
    
    
    
    //iterative with dynamic programming O(N^3) Space O(N^2)
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>0;i--){
            for(int j=i+1;j<=n;j++){
                int tem=Integer.MAX_VALUE;
                for(int k=(i+j)/2;k<=j;k++){//optimized here
                    if(k-1>i&&k+1<j)
                        tem=Math.min(tem,k+Math.max(dp[i][k-1],dp[k+1][j]));
                    else if(k-1>i)
                        tem=Math.min(tem,k+dp[i][k-1]);
                    else if(k+1<j)
                        tem=Math.min(tem,k+dp[k+1][j]);
                    else
                        tem=Math.min(tem,k);
                }
                dp[i][j]=tem;
            }
        }
        return dp[1][n];
    }
	public static void main(String[] args) {
		num375 sol=new num375();
		sol.getMoneyAmount(9);
	}

}
