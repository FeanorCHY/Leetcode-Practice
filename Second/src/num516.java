
public class num516 {
    //brute force Search O(2^N)
    // int res=0;
    // public int longestPalindromeSubseq(String s) {
    //     if(s==null||s.length()==0)
    //         return 0;
    //     char[] arr=s.toCharArray();
    //     search(0,arr.length-1,arr,0);
    //     return res;
    // }
    // private void search(int l,int r,char[] arr,int cur){
    //     while(l<=r){
    //         if(arr[l]==arr[r]){
    //             if(l==r)
    //                 cur++;
    //             else
    //                 cur+=2;
    //             l++;
    //             r--;
    //         }
    //         else{
    //             int teml=l,temr=r;
    //             while(teml<=temr&&arr[teml]!=arr[temr]){
    //                 teml++;
    //             }
    //             search(teml,temr,arr,cur);
    //             teml=l;
    //             temr=r;
    //             while(teml<=temr&&arr[teml]!=arr[temr]){
    //                 temr--;
    //             }
    //             search(teml,temr,arr,cur);
    //             search(l+1,r-1,arr,cur);
    //             return;
    //         }
    //     }
    //     res=Math.max(cur,res);
    // }
    
    
    //dp Time O(N^2) Space O(N^2)
    // public int longestPalindromeSubseq(String s) {
    //     if(s==null||s.length()==0)
    //         return 0;
    //     char[] arr=s.toCharArray();
    //     int[][] dp=new int[arr.length][arr.length];
    //     for(int i=0;i<arr.length;i++)
    //         dp[i][i]=1;
    //     for(int l=2;l<=arr.length;l++){
    //         for(int i=0;i<=arr.length-l;i++){
    //             if(arr[i]==arr[i+l-1])
    //                 dp[i][i+l-1]=dp[i+1][i+l-2]+2;
    //             else
    //                 dp[i][i+l-1]=Math.max(dp[i+1][i+l-1],dp[i][i+l-2]);
    //         }
    //     }
    //     return dp[0][arr.length-1];
    // }
    
    //recursive dp
    int[][] dp;
    char[] arr;
    public int longestPalindromeSubseq(String s) {
        if(s==null||s.length()==0)
            return 0;
        arr=s.toCharArray();
        dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++)
            dp[i][i]=1;
        return search(0,arr.length-1);
    }
    private int search(int i,int j){
        if(i>j||dp[i][j]>0)
            return dp[i][j];
        else if(arr[i]==arr[j])
            dp[i][j]=2+search(i+1,j-1);
        else
            dp[i][j]=Math.max(search(i+1,j),search(i,j-1));
        return dp[i][j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
