package leedcode;

public class num200 {
	char[][] big_grid;
    public int numIslands(char[][] grid) {
    	big_grid=grid;
    	int result=0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]=='1'){
        			result++;
        			change(i,j);
        		}
        	}
        }
    	
    	return result;
    }
    public void change(int i,int j){
    	big_grid[i][j]='0';
    	if(i>0){
    		if(big_grid[i-1][j]=='1')
    			change(i-1,j);
    	}
    	if(j>0)
    		if(big_grid[i][j-1]=='1')
    			change(i,j-1);
    	if(i<big_grid.length-1)
    		if(big_grid[i+1][j]=='1')
    			change(i+1,j);
    	if(j<big_grid[0].length-1)
    		if(big_grid[i][j+1]=='1')
    			change(i,j+1);
    		
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
