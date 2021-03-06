
public class num063 {
    //Time O(mn) Space O(mn)
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0)
    //         return 0;
    //     for(int i=0;i<obstacleGrid.length;i++){
    //         for(int j=0;j<obstacleGrid[0].length;j++){
    //             if(obstacleGrid[i][j]==1){
    //                 obstacleGrid[i][j]=0;
    //                 continue;
    //             }
    //             if(i==0&&j==0)
    //                 obstacleGrid[i][j]=1;
    //             else if(i==0)
    //                 obstacleGrid[i][j]=obstacleGrid[i][j-1];
    //             else if(j==0)
    //                 obstacleGrid[i][j]=obstacleGrid[i-1][j];
    //             else
    //                 obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
    //         }
    //     }
    //     return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    // }
    
    
    
    //Time O(mn) Space O(m)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0)
            return 0;
        int dp[]=new int[obstacleGrid[0].length];
        dp[0]=1;
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[j]=0;
                }
                else if(j>0)
                    dp[j]+=dp[j-1];
            }
        }
        return dp[obstacleGrid[0].length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
