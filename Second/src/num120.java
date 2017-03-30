import java.util.List;

public class num120 {

    //will the sum over the Integer Limit? is the number be negative? will the triangle not exact triangle? 
    //go from front
    // public int minimumTotal(List<List<Integer>> t) {
    //     int n=t.size();
    //     if(n==0)
    //         return 0;
    //     int[] dp=new int[n];
    //     int min=Integer.MAX_VALUE;
    //     dp[0]=t.get(0).get(0);
    //     if(n==1)
    //         return dp[0];
    //     for(int i=1;i<n;i++){
    //         for(int j=i;j>=0;j--){
    //             int val=t.get(i).get(j);
    //             if(j!=i){
    //                 if(j-1>=0)
    //                     dp[j]=Math.min(dp[j],dp[j-1])+val;
    //                 else
    //                     dp[j]=dp[j]+val;
    //             }
    //             else{
    //                 dp[j]=dp[j-1]+val;
    //             }
    //             if(i==n-1)
    //                 min=Math.min(min,dp[j]);
    //         }
    //     }
    //     return min;
    // }



    //go from back
    public int minimumTotal(List<List<Integer>> t) {
        int n=t.size();
        if(n==0)
            return 0;
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+t.get(i).get(j);
            }
        }
        return dp[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
