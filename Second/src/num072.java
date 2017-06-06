
public class num072 {
    //dp Time O(mn) Space O(mn)
    public int minDistance(String word1, String word2) {
        if(word1==null||word2==null)
            return 0;
        char[] arr1=word1.toCharArray();
        char[] arr2=word2.toCharArray();
        int[][] dp=new int[arr1.length+1][arr2.length+1];
        for(int i=0;i<=arr1.length;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=arr2.length;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    dp[i+1][j+1]=dp[i][j];
                }
                else{
                    dp[i+1][j+1]=Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]))+1;
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
