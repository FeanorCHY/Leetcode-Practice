package leedcode;

public class num463 {
    public int islandPerimeter(int[][] grid) {
    	int res=0;
    	if(grid.length==0||grid==null)
    		return 0;
    	int[] dx={-1,0};
    	int[] dy={0,-1};
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j]==1){
    				res+=4;
	    			for(int k=0;k<2;k++){
	    				int x=i+dx[k];
	    				int y=j+dy[k];
	    				if(x>=0&&y>=0&&grid[x][y]==1)
	    					res-=2;
	    			}
    			}
    		}
    	}
    	
    	
        return res;
    }
	public static void main(String[] args) {
		int[][] test=
				{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		num463 sol=new num463();
		System.out.println(sol.islandPerimeter(test));
	}

}
