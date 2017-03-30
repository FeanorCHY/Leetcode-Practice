package leedcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class num310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	List<Integer> list=new ArrayList<Integer>();
    	if(n==1){
    		list.add(0);
    		return list;
    	}
    	int[] map=new int[n];
    	for(int[] edge:edges){
    		map[edge[0]]++;
    		map[edge[1]]++;
    	}
    	Queue<Integer> q=new LinkedList<Integer>();
    	for(int i=0;i<map.length;i++){
    		if(map[i]==1)
    			q.add(i);
    	}
    	if(n==2)
    		return new ArrayList<Integer>(q);
    	int count=q.size();//for more cases that end with 2,1
    	while(!q.isEmpty()){
        	Queue<Integer> tem=new LinkedList<Integer>();
	    	while(!q.isEmpty()){
	    		int node=q.poll();
	    		for(int[] edge:edges){
	    			if(node==edge[0]){
	    				map[edge[1]]--;
	    				if(map[edge[1]]==1)
	    					tem.add(edge[1]);
	    			}
	    			if(node==edge[1]){
	    				map[edge[0]]--;
	    				if(map[edge[0]]==1)
	    					tem.add(edge[0]);
	    			}
	    		}
	    	}
	    	count+=tem.size();
	    	if(count==n)
	    		return new ArrayList<Integer>(tem);
	    	q=tem;
    	}
        return list;
    }
	public static void main(String[] args) {
		int[][] test={{1,0},{1,2},{1,3}};
		num310 sol=new num310();
		System.out.println(sol.findMinHeightTrees(4, test));

	}

}
