package leedcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class num261 {

	int[] reach;
        public boolean validTree(int n, int[][] edges) {
        	if(n-1!=edges.length)
        		return false;
        	reach=new int[n];
        	for(int i=0;i<reach.length;i++){
        		reach[i]=i;
        	}
        	for(int i=0;i<edges.length;i++){
        		int root1=find(edges[i][0]);
        		int root2=find(edges[i][1]);
        		if(root1==root2)
        			return false;
        		reach[root2]=root1;
        	}
        	return true;
        }
        public int find(int node){
        	if(reach[node]==node) return node;
        	return find(reach[node]);
        }

    	
	public static void main(String[] args) {
		int[][] test={{0, 1}, {1, 2}, {2, 0}};
		System.out.println(new num261().validTree(4, test));
	}

}


//
//public boolean validTree(int n, int[][] edges) {if(edges.length==0&&n==1)
//	return true;
//if(edges.length!=n-1)
//	return false;
//int map[]=new int[n];
//for(int[] each:edges){
//	map[each[0]]++;
//	map[each[1]]++;
//}
//Queue<Integer> qu=new LinkedList<Integer>();
//for(int i=0;i<map.length;i++){
//	if(map[i]==1){
//		map[i]--;
//		qu.add(i);
//	}
//}
//int count=qu.size();
//while(!qu.isEmpty()){
//	int node=qu.poll();
//	for(int i=0;i<edges.length;i++){
//		if(edges[i][0]==node){
//			map[edges[i][1]]--;
//			if(map[edges[i][1]]==1){
//				map[edges[i][1]]--;
//				qu.add(edges[i][1]);
//				count++;
//			}
//		}
//		if(edges[i][1]==node){
//			map[edges[i][0]]--;
//			if(map[edges[i][0]]==1){
//				map[edges[i][0]]--;
//				qu.add(edges[i][0]);
//				count++;
//			}
//		}
//	}
//}
//
//
//return count==n;
//}