package leedcode;

import java.util.PriorityQueue;

public class num265 {
    public int minCostII(int[][] costs) {
    	if(costs.length==0)
    		return 0;
    	if(costs[0].length==0)
    		return 0;
    	int k=costs[0].length;
    	int[] least=new int[2];
    	int pos=0;
    	for(int i=0;i<costs.length;i++){
        	int[] teml=new int[2];
        	int temp=0;
    		teml[0]=Integer.MAX_VALUE;
    		teml[1]=Integer.MAX_VALUE;
    		for(int j=0;j<k;j++){
    			int val=j==pos?costs[i][j]+least[1]:costs[i][j]+least[0];
    			if(val<teml[0]){
    				teml[1]=teml[0];
    				teml[0]=val;
    				temp=j;
    			}
    			else if(val<teml[1]){
    				teml[1]=val;
    			}
    		}
			least=teml;
			pos=temp;
    	}
    	
    	
    	return least[0];
    }
	public static void main(String[] args) {
		int[][] test=
				{{8,16,12,18,9},{19,18,8,2,8},{8,5,5,13,4},{15,9,3,19,2},{8,7,1,8,17},{8,2,8,15,5},{8,17,1,15,3},{8,8,5,5,16},{2,2,18,2,9}};
//				{{4,16},{15,5},{18,17},{10,12},{14,10},{3,10},{2,11},{18,14},{9,1},{14,13}};
//			{{1,3},{2,2}};
		num265 sol=new num265();
		System.out.println(sol.minCostII(test));
		char a='\t';
	}

}

//PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
//if(costs.length==0)
//	return 0;
//for(int i=0;i<costs.length;i++){
//	PriorityQueue<Integer> tem=new PriorityQueue<Integer>();
//	int num=pq.isEmpty()?0:pq.poll().intValue();
//	for(int j=0;j<costs[0].length;j++){
//		if(i>0){
//			if(costs[i-1][j]==num){
//				costs[i][j]=pq.peek()+costs[i][j];
//			}
//			else
//				costs[i][j]=num+costs[i][j];
//		}
//		tem.add(costs[i][j]);
//	}
//	pq=tem;
//}
//
//
//return pq.peek();