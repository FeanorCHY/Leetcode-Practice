package leedcode;

public class num361 {
	char[][] grid;
    public int maxKilledEnemies(char[][] grid) {
    	this.grid=grid;
    	int max=-1;
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j]=='0')
    				max=Math.max(max, tryKill(i,j));
    		}
    	}
    	if(max<0)//avoid empty input
    		return 0;
        return max;
    }
    public int tryKill(int x,int y){
    	int index=y-1;
    	int count=0;
    	while(index>=0){
    		if(grid[x][index]=='W')
    			break;
    		else if(grid[x][index]=='E')
    			count++;
    		index--;
    	}
    	index=y+1;
    	while(index<grid[0].length){
    		if(grid[x][index]=='W')
    			break;
    		else if(grid[x][index]=='E')
    			count++;
    		index++;
    	}
    	index=x-1;
    	while(index>=0){
    		if(grid[index][y]=='W')
    			break;
    		else if(grid[index][y]=='E')
    			count++;
    		index--;
    	}
    	index=x+1;
    	while(index<grid.length){
    		if(grid[index][y]=='W')
    			break;
    		else if(grid[index][y]=='E')
    			count++;
    		index++;
    	}
    	return count;
    }
	public static void main(String[] args) {
		char test[][]={"0E00".toCharArray(),"E0WE".toCharArray(),"0E00".toCharArray()};
		num361 sol=new num361();
		System.out.println(sol.maxKilledEnemies(test));
	}

}
