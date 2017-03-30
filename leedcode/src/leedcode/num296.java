package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num296 {
    public int minTotalDistance(int[][] grid) {
    	List<List<Integer>> listlist=new ArrayList<List<Integer>>();
    	List<Integer> ver=new ArrayList<Integer>();
    	List<Integer> hor=new ArrayList<Integer>();
    	for(int i=0;i<grid.length;i++){
    		List<Integer> list=new ArrayList<Integer>();
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j]==1){
    				list.add(j);
    				ver.add(i);
    				hor.add(j);
    			}
    		}
    		listlist.add(list);
    	}
    	if(ver.size()==0){
    		return 0;
    	}
    	Collections.sort(hor);
    	int x=ver.get(ver.size()/2);
    	int y=hor.get(hor.size()/2);
    	int dis=0;
    	for(int i=0;i<ver.size();i++){
    		dis+=Math.abs(ver.get(i)-x)+Math.abs(hor.get(i)-y);
    	}
    	
    	return dis;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
