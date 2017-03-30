package leedcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class FreNode{
	char c;
	int rep=1;
	public FreNode(char c){
		this.c=c;
	}
	public String toString(){
		return "c:"+c+",rep="+rep; 
	}
}
public class num451 {
    public String frequencySort(String s) {
    	List<FreNode> list=new ArrayList<FreNode>(); 
//    	PriorityQueue<FreNode> q=new PriorityQueue<FreNode>(new Comparator<FreNode>(){
//
//			@Override
//			public int compare(FreNode o1, FreNode o2) {
//				// TODO Auto-generated method stub
//				return o2.rep-o1.rep;
//			}
//    		
//    	}); 
    	char[] arr=s.toCharArray();
    	HashMap<Character,FreNode> map=new HashMap<Character,FreNode>();
    	for(char each:arr){
    		if(map.containsKey(each)){
    			map.get(each).rep++;
    		}
    		else{
    			FreNode tem=new FreNode(each);
    			map.put(each, tem);
    			list.add(tem);
    		}
    	}
//    	System.out.println(q.toString());
    	StringBuilder sb=new StringBuilder();
    	list.sort(new Comparator<FreNode>(){

			@Override
			public int compare(FreNode o1, FreNode o2) {
				// TODO Auto-generated method stub
				return o2.rep-o1.rep;
			}
    		
    	});
    	for(int i=0;i<list.size();i++){
    		for(int j=0;j<list.get(i).rep;j++)
    			sb.append(list.get(i).c);
    	}
//    	while(!q.isEmpty()){
//    		for(int i=0;i<q.peek().rep;i++)
//    			sb.append(q.peek().c);
//    		q.poll();
//    	}
        return sb.toString();
    }
	public static void main(String[] args) {
		num451 sol=new num451();
		System.out.println(sol.frequencySort("Aabb"));
	}

}
