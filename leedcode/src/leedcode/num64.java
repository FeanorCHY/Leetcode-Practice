package leedcode;

public class num64 {
    public int minPathSum(int[][] grid) {
    	int m=grid.length;
    	int n=grid[0].length;
    	int[] step=new int[n];
    	step[0]=grid[0][0];
    	for(int i=1;i<n;i++){
    		step[i]=step[i-1]+grid[0][i];
    	}
//    	step[0]=grid[0][0];
    	for(int i=1;i<m;i++){
    		step[0]=step[0]+grid[i][0];
    		for(int j=1;j<n;j++){
    			if(step[j]<step[j-1])
    				step[j]=step[j]+grid[i][j];
    			else
    				step[j]=step[j-1]+grid[i][j];
    		}
    	}
        return step[n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
