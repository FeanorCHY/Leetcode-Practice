package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class num305 {
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res=new ArrayList<Integer>();
    	if(m==0)
    		return res;
    	int[][] grid=new int[m][n];
    	int index=1;
    	int count=0;
    	for(int i=0;i<positions.length;i++){
    		int x=positions[i][0];
    		int y=positions[i][1];
    		HashSet<Integer> list=new HashSet<Integer>();
    		if(x>0&&grid[x-1][y]>0)
    			list.add(getNum(grid[x-1][y]));
    		if(y>0&&grid[x][y-1]>0)
    			list.add(getNum(grid[x][y-1]));
    		if(x<grid.length-1&&grid[x+1][y]>0)
				list.add(getNum(grid[x+1][y]));
    		if(y<grid[0].length-1&&grid[x][y+1]>0)
				list.add(getNum(grid[x][y+1]));
    		if(list.isEmpty()){
    			grid[x][y]=index;
    			map.put(index, index);
    			index++;
    			count++;
    		}
    		else{
    			count=count-list.size()+1;
    			if(list.size()==1){
    				for(int each:list){
        				grid[x][y]=	each;
    				}
    			}
    			else{
    				grid[x][y]=	index;
    				map.put(index,index);
    				for(int each:list){
        				map.put(each, index);
    				}
    				index++;
    			}
    		}
    		res.add(count);
    	}
    	
    	
        return res;
    }
    public int getNum(int x){
    	while(map.get(x)!=x){
    		x=map.get(x);
    	}
    	return x;
    }
    
	public static void main(String[] args) {
		int[][] test={{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};
		num305 sol=new num305();
		System.out.println(sol.numIslands2(3, 3, test));
	}

}
