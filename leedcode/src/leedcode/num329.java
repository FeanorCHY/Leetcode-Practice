package leedcode;

import java.util.HashMap;

public class num329 {
	int[][] matrix;
	int[] dx={1,0,-1,0};
	int[] dy={0,1,0,-1};
	boolean visit[][];
	int count=1;
	HashMap<String,Integer> map=new HashMap<String,Integer>();
    public int longestIncreasingPath(int[][] matrix) {
    	this.matrix=matrix;
    	if(matrix.length==0||matrix==null)
    		return 0;
    	visit=new boolean[matrix.length][matrix[0].length];
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
        		visit[i][j]=true;
    			dps(i,j);
    			visit[i][j]=false;
    		}
    	}
    	return count;
    }
    private void dps(int x,int y){
    	String record=x+" "+y;
    	for(int i=0;i<4;i++){
    		int nx=x+dx[i];
    		int ny=y+dy[i];
    		if(nx<0||ny<0||nx>=matrix.length||ny>=matrix[0].length||matrix[nx][ny]<=matrix[x][y]||visit[nx][ny])
    			continue;
        	String tem=nx+" "+ny;
    		if(map.containsKey(tem)){
    	    	if(map.containsKey(record)){
    	    		if(map.get(record)<1+map.get(tem)){
    	    			map.put(record, 1+map.get(tem));
	    			}
    	    	}
    	    	else
    	    		map.put(record, 1+map.get(tem));
    	    	count=Math.max(count, map.get(record));
    	    	continue;
    		}
    		visit[nx][ny]=true;
    		dps(nx,ny);
        	if(!map.containsKey(record))
        		map.put(record, 1+map.get(tem));
        	else{
        		if(map.get(record)<map.get(tem)+1){
        			map.put(record, 1+map.get(tem));
        		}
        	}
        	count=Math.max(count, map.get(record));
    		visit[nx][ny]=false;
    	}
    	if(!map.containsKey(record))
    		map.put(record, 1);
    }
	public static void main(String[] args) {
		int[][] test={{7,7,5},{2,4,6},{8,2,0}};//{{1,2},{2,3}};//{{3,4,5},{3,2,6},{2,2,1}};//{{9,9,4},{6,6,8},{2,1,1}};
		num329 sol=new num329();
		System.out.println(sol.longestIncreasingPath(test));
	}

}
