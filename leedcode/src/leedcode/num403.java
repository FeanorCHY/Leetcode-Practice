package leedcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class num403 {
    public boolean canCross(int[] stones) {
    	if(stones.length<=1)
    		return true;
    	HashMap<Integer,HashSet<Integer>> map=new HashMap<Integer,HashSet<Integer>>();
    	map.put(0, new HashSet<Integer>());
    	map.get(0).add(1);
    	for(int i=1;i<stones.length;i++){
    		map.put(stones[i],new HashSet<Integer>());
    	}
    	for(int i=0;i<stones.length;i++){
    		for(int each:map.get(stones[i])){
    			int reach=each+stones[i];
    			if(reach==stones[stones.length-1])
    				return true;
    			if(map.containsKey(reach)){
	    			HashSet<Integer> set=map.get(reach);
	    			set.add(each);
	    			set.add(each+1);
	    			if(each-1>0)
	    				set.add(each-1);
    			}
    		}
    	}
        
        return false;
    }
	public static void main(String[] args) {
		int[] test={0,1,3,6,7};
		num403 sol=new num403();
		System.out.println(sol.canCross(test));
	}

}





//class StoneNode{
//	PriorityQueue<Integer> pq;
//	int pos;
//	public StoneNode(int pos){
//		this.pos=pos;
//		pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2-o1;
//			}
//    	});
//	}
//}
//public class num403 {
//    public boolean canCross(int[] stones) {
//    	PriorityQueue<StoneNode> pqpq=new PriorityQueue<StoneNode>(new Comparator<StoneNode>(){
//
//			@Override
//			public int compare(StoneNode o1, StoneNode o2) {
//				// TODO Auto-generated method stub
//				return (o1.pos+o1.pq.peek())-(o2.pos+o2.pq.peek());
//			}
//    	}); 
//    	for(int each:stones){
//    		if(each==0){
//    			StoneNode tem=new StoneNode(0);
//    			tem.pq.add(0);
//    			pqpq.add(tem);
//    		}
//    		else{
//    			while(!pqpq.isEmpty()&&(pqpq.peek().pos+pqpq.peek().pq.peek()+1)<each){
//    				pqpq.poll();
//    			}
//    			if(pqpq.isEmpty())
//    				return false;
//    			StoneNode next=new StoneNode(each);
//    			for(StoneNode node:pqpq){
//    				for(int item:node.pq){
//    					if((each-node.pos)<=item+1&&(each-node.pos)>=item-1){
//    						next.pq.add(each-node.pos);
//    					}
//    				}
//    			}
//    			if(!next.pq.isEmpty())
//    				pqpq.add(next);
//    			else if(next.pos==stones[stones.length-1])
//    				return false;
//    		}
//    	}
//    	return true;
//    }
//	public static void main(String[] args) {
//		int[] test={0,1,3,6,7};
//		num403 sol=new num403();
//		System.out.println(sol.canCross(test));
//	}
//
//}