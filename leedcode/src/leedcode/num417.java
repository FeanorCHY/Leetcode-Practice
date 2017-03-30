package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num417 {
	List<int[]> res=new ArrayList<int[]>();
	int[][] matrix;
	int[] dx={1,0,-1,0};
	int[] dy={0,1,0,-1};
	int[][] state;
    public List<int[]> pacificAtlantic(int[][] matrix) {
    	this.matrix=matrix;
    	if(matrix.length==0||matrix==null)
    		return res;
    	state=new int[matrix.length][matrix[0].length];
    	for(int i=0;i<matrix.length;i++){
    		state[i][0]=1;
    	}
    	for(int i=0;i<matrix[0].length;i++){
    		state[0][i]=1;
    	}
    	for(int i=0;i<matrix.length;i++){
    		find(i,0,true);
    	}
    	for(int i=0;i<matrix[0].length;i++){
    		find(0,i,true);
    	}
    	for(int i=0;i<matrix[0].length;i++){
    		find(matrix.length-1,i,false);
    	}
    	for(int i=0;i<matrix.length;i++){
    		find(i,matrix[0].length-1,false);
    	}
    	return res;
    }
    private void find(int x,int y,boolean pac){
    	if(!pac){
    		if(state[x][y]==1){
	    		state[x][y]=3;
	    		res.add(new int[]{x,y});
    		}
    		if(state[x][y]==0)
    			state[x][y]=2;
    	}
    	for(int i=0;i<4;i++){
    		int nx=x+dx[i];
    		int ny=y+dy[i];
    		
    		if(nx>=0&&ny>=0&&nx<matrix.length&&ny<matrix[0].length){
    			if(pac&&state[nx][ny]==0&&matrix[nx][ny]>=matrix[x][y]){
    				state[nx][ny]=1;
    				find(nx,ny,pac);
    			}
    			else if(!pac&&state[nx][ny]<2&&matrix[nx][ny]>=matrix[x][y]){
    				find(nx,ny,pac);
    			}
    		}
    	}
    }
	public static void main(String[] args) {
		int[][] test={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		num417 sol=new num417();
		List<int[]> list=sol.pacificAtlantic(test);
		for(int[] each:list)
			System.out.println(Arrays.toString(each));
	}

}

//state=new int[matrix.length][matrix[0].length];
//state[0][state[0].length-1]=1;
//state[state.length-1][0]=1;
//res.add(new int[]{state.length-1,0});
//res.add(new int[]{0,state[0].length-1});
//find(0,state[0].length-1);
//find(state.length-1,0);