import java.util.ArrayList;

public class num132 {
    //back search Time worst: O(n^2) Space O(n)
    // public int minCut(String s) {
    //     if(s==null||s.length()<=1)
    //         return 0;
    //     s="!"+s;
    //     char[] arr=s.toCharArray();
    //     int[] dp=new int[arr.length+1];
    //     ArrayList<Integer> lefts=new ArrayList<Integer>(arr.length);
    //     lefts.add(2);
    //     dp[1]=-1;
    //     if(arr[1]==arr[2]){
    //         lefts.add(1);
    //         dp[3]=0;
    //     }
    //     else
    //         dp[3]=1;
    //     for(int i=3;i<arr.length;i++){
    //         int min=dp[i]+1;
    //         ArrayList<Integer> tem=new ArrayList<Integer>(arr.length);
    //         tem.add(i);
    //         for(int left:lefts){
    //             if(arr[left-1]==arr[i]){
    //                 min=Math.min(min,dp[left-1]+1);
    //                 tem.add(left-1);
    //             }
    //         }
    //         if(arr[i]==arr[i-1]){
    //             min=Math.min(min,dp[i-1]+1);
    //             tem.add(i-1);
    //         }
    //         dp[i+1]=min;
    //         lefts=tem;
    //     }
    //     return dp[dp.length-1];
    // }
    
    
    //dynamic programming Time O(n^2) Space O(n^2)
    public int minCut(String s) {
        if(s==null||s.length()<=1)
            return 0;
        char[] arr=s.toCharArray();
        int[] cut=new int[arr.length];
        boolean[][] dp=new boolean[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            cut[i]=Integer.MAX_VALUE;
            for(int j=0;j<=i;j++){
                if(arr[i]==arr[j]){
                    if(j+1>=i||dp[j+1][i-1]){
                        dp[j][i]=true;
                        cut[i]=Math.min(cut[i],j==0?0:cut[j-1]+1);
                    }
                }
            }
            dp[i][i]=true;
        }
        return cut[cut.length-1];
    }
	public static void main(String[] args) {
		num132 sol=new num132();
		System.out.println(sol.minCut("efe"));
	}

}
