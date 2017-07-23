
public class num174 {

    //1 dimension dp Time O(mn) space O(n)
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0)
            return 0;
        int[] dp=new int[dungeon[0].length];
        for(int i=dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){
                dp[j]=Math.min(i==dungeon.length-1?Integer.MAX_VALUE:dp[j],j==dungeon[0].length-1?Integer.MAX_VALUE:dp[j+1]);
                if(i==dungeon.length-1&&j==dungeon[0].length-1)
                    dp[j]=1;
                if(dungeon[i][j]<0)
                    dp[j]=dp[j]-dungeon[i][j];
                else
                    dp[j]=Math.max(dp[j]-dungeon[i][j],1);//take care of minus
            }
        }
        return Math.max(dp[0],1);
    }
	public static void main(String[] args) {
		num174 sol=new num174();
		int[][] test={{2},{1}};
		System.out.println(sol.calculateMinimumHP(test));
	}

}
