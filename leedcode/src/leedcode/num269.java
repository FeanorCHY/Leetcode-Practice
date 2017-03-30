package leedcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class num269 {
    public String alienOrder(String[] words) {
    	HashMap<Character,Set<Character>> edge=new HashMap<Character,Set<Character>>();
    	HashMap<Character,Integer> count=new HashMap<Character,Integer>();
    	if(words.length==0)
    		return "";
    	
    	for(int index=0;index<words.length;index++){
	    	char[] arr=words[index].toCharArray();
	    	for(int i=0;i<arr.length;i++){
	    		if(!count.containsKey(arr[i]))
	    			count.put(arr[i], 0);
	    	}
	    	if(index>0){
		    	char[] last=words[index-1].toCharArray();
		    	boolean suc=false;
	    		for(int i=0;i<Math.min(last.length,arr.length);i++){
	    			boolean add=true;
	    			if(arr[i]!=last[i]){
	    				suc=true;
	    				if(edge.containsKey(last[i])){
	    					if(edge.get(last[i]).contains(arr[i]))
	    						add=false;
	    					else
	    						edge.get(last[i]).add(arr[i]);
	    	    		}
	    	    		else{
	    	    			HashSet<Character> tem=new HashSet<Character>();
	    	    			tem.add(arr[i]);
	    	    			edge.put(last[i], tem);
	    	    		}
	    				if(add){
		    				if(count.containsKey(arr[i]))
		    					count.put(arr[i],count.get(arr[i])+1);
		    				else
		    					count.put(arr[i], 1);
	    				}
	    				break;
	    			}
	    		}
	    		if(!suc&&last.length>arr.length)
	    			return "";
	    	}
    	}
    	StringBuilder res=new StringBuilder();
    	Queue<Character> q=new LinkedList<Character>();
    	for(Character each:count.keySet()){
    		if(count.get(each)==0){
    			count.put(each, -1);
    			q.add(each);
    		}
    	}
    	while(!q.isEmpty()){
    		Character c=q.poll();
    		res.append(c);
    		if(edge.containsKey(c)){
	    		for(Character each:edge.get(c)){
	    			count.put(each, count.get(each)-1);
	    			if(count.get(each)==0){
	    				q.add(each);
	    				count.put(each, -1);
	    			}
	    		}
    		}
    	}
    	
        return res.length()==count.size()?res.toString():"";
    }
	public static void main(String[] args) {
		String words[]={"za","zb","ca","cb"};//{"wrt","wrf","er","ett","rftt"};
		num269 sol=new num269();
		System.out.println(sol.alienOrder(words));
	}

}
//for(int i=1;i<arr.length;i++){
//boolean add=true;
//if(arr[i]==arr[i-1])
//	continue;
//else if(edge.containsKey(arr[i-1])){
//	if(edge.get(arr[i-1]).contains(arr[i]))
//		add=false;
//	else
//		edge.get(arr[i-1]).add(arr[i]);
//}
//else{
//	HashSet<Character> tem=new HashSet<Character>();
//	tem.add(arr[i]);
//	edge.put(arr[i-1], tem);
//}
//if(add){
//	if(count.containsKey(arr[i]))
//		count.put(arr[i],count.get(arr[i])+1);
//	else
//		count.put(arr[i], 1);
//}
//}
