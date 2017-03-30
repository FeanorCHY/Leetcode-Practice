package leedcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class LNode{
	char c;
	int rep=1;
	public LNode(char c){
		this.c=c;
	}
}
public class num424 {
    public int characterReplacement(String s, int k) {
    	char[] arr=s.toCharArray();
    	HashSet<Character> set=new HashSet<Character>();
    	for(int i=0;i<arr.length;i++){
    		set.add(arr[i]);
    	}
    	int max=0;
    	for(Character each:set){
    		Queue<Integer> cur=new LinkedList<Integer>();
    		int left=0;
    		for(int i=0;i<arr.length;i++){
    			if(arr[i]!=each){
    				cur.add(i);
    				if(cur.size()>k){
    					max=Math.max(max,i-left);
    					left=cur.poll()+1;
    				}
    			}
    		}
    		max=Math.max(max,arr.length-left);
    	}
    	return max;
    }
	public static void main(String[] args) {
		num424 sol=new num424();
		System.out.println(sol.characterReplacement("BAAA", 0));
	}

}




//char[] arr=s.toCharArray();
//PriorityQueue<LNode> pq=new PriorityQueue<LNode>(new Comparator<LNode>(){
//
//	@Override
//	public int compare(LNode o1, LNode o2) {
//		// TODO Auto-generated method stub
//		return o2.rep-o1.rep;
//	}
//	
//});
//HashMap<Character,LNode> map=new HashMap<Character,LNode>();
//for(int i=0;i<arr.length;i++){
//	if(map.containsKey(arr[i])){
//		map.get(arr[i]).rep++;
//	}
//	else{
//		LNode tem=new LNode(arr[i]);
//		map.put(arr[i], tem);
//		pq.add(tem);
//	}
//}
//int max=0;
//while(!pq.isEmpty()&&(pq.peek().rep+k)>max){
//	LNode each=pq.poll();
//	Queue<Integer> cur=new LinkedList<Integer>();
//	int left=0;
//	for(int i=0;i<arr.length;i++){
//		if(arr[i]!=each.c){
//			cur.add(i);
//			if(cur.size()>k){
//				max=Math.max(max,i-left);
//				left=cur.poll()+1;
//			}
//		}
//	}
//	max=Math.max(max,arr.length-left);
//}
//return max;