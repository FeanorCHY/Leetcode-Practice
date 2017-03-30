package leedcode;

public class num63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==1&&obstacleGrid[0].length==1)
            return (1-obstacleGrid[0][0]);
    	int n=obstacleGrid[0].length;
        int m=obstacleGrid.length;
    	int[] step=new int[n];
    	step[0]=1;
    	for(int i=0;i<m;i++){
    	    if(obstacleGrid[i][0]==1)
    	        step[0]=0;
    		for(int j=1;j<n;j++){
    			step[j]=(step[j]+step[j-1])*(1-obstacleGrid[i][j]);
    		}
    	}
        return step[n-1];
    }
	public static void main(String[] args) {
		int[][] test={{1},{0}};
	}

}
