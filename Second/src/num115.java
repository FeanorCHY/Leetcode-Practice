
public class num115 {

    public int numDistinct(String s, String t) {
        if(s==null||t==null||s.length()<t.length())
            return 0;
        char[] sarr=s.toCharArray();
        char[] tarr=t.toCharArray();
        int[][] dp=new int[sarr.length+1][tarr.length+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        for(int i=1;i<=tarr.length;i++){
            for(int j=i;j<=sarr.length;j++){
                dp[j][i]=dp[j-1][i];
                if(tarr[i-1]==sarr[j-1])
                    dp[j][i]+=dp[j-1][i-1];
            }
        }
        return dp[sarr.length][tarr.length];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
