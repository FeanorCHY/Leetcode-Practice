package leedcode;

import java.util.HashSet;
import java.util.Stack;

class SDbuild{
	int x;
	int y;
	int id;
	public SDbuild(int x,int y,int id){
		this.x=x;
		this.y=y;
		this.id=id;
	}
}
public class num317 {
    public int shortestDistance(int[][] grid) {
    	if(grid.length==0||grid==null)
    		return -1;
    	HashSet<Integer>[][] visit=new HashSet[grid.length][grid[0].length];
    	int[][] dis=new int[grid.length][grid[0].length];
    	Stack<SDbuild> st=new Stack<SDbuild>();
    	int len=0;
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j]>0){
    				dis[i][j]=-grid[i][j];
    				if(grid[i][j]==1){
    					st.push(new SDbuild(i,j,++len));
    				}
    			}
    			else
    				visit[i][j]=new HashSet<Integer>();
    		}
    	}
    	int step=1;
    	int min=Integer.MAX_VALUE;
    	int more=0;
    	while(!st.isEmpty()){
    		Stack<SDbuild> tem=new Stack<SDbuild>();
    		int[] dx={1,0,-1,0};
    		int[] dy={0,1,0,-1};
    		while(!st.isEmpty()){
    			SDbuild each=st.pop();
    			for(int i=0;i<4;i++){
    				int x=each.x+dx[i];
    				int y=each.y+dy[i];
    				if(x<0||x>=grid.length||y<0||y>=grid[0].length||dis[x][y]<0||visit[x][y]==null||visit[x][y].contains(each.id))
    					continue;
    				tem.add(new SDbuild(x,y,each.id));
    				visit[x][y].add(each.id);
    				dis[x][y]+=step;
    				if(visit[x][y].size()==len)
    					min=Integer.min(min, dis[x][y]);
    			}
    		}
    		if(min<Integer.MAX_VALUE){
    			if(more==2){
    				return min;
    			}
    			else
    				more++;
    		}
    		st=tem;
    		step++;
    		
    	}

		if(min<Integer.MAX_VALUE){
			return min;
		}
        return -1;
    }
	public static void main(String[] args) {
		int[][] test={{1,0}};//{{1,1,1,1,1,1,1,0},{0,0,0,0,0,0,0,1},{1,1,1,1,1,1,0,1},{1,0,0,0,0,1,0,1},{1,0,1,1,0,1,0,1},{1,0,1,0,0,1,0,1},{1,0,1,1,1,1,0,1},{1,0,0,0,0,0,0,1},{0,1,1,1,1,1,1,0}};
		num317 sol=new num317();
		System.out.println(sol.shortestDistance(test));
	}

}
