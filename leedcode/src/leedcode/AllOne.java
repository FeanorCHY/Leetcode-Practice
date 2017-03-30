package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;


public class AllOne {
	private class AOlink{
		AOlink last=null;
		AOlink next=null;
		int val;
		HashSet<String> set=new HashSet<String>();
		AOlink(int val){
			this.val=val;
		}
	}
	AOlink head;
	AOlink tail;
	HashMap<String,Integer> map2;
	HashMap<Integer,AOlink> map;
	public AllOne() {
		head=new AOlink(0);
		tail=new AOlink(0);
		head.next=tail;
		tail.last=head;
		map2=new HashMap<String,Integer>();
		map=new HashMap<Integer,AOlink>();
	}
    public void inc(String key) {
    	if(map2.containsKey(key)){
    		AOlink node=map.get(map2.get(key));
    		AOlink next=node.next;
    		map2.put(key, map2.get(key)+1);
    		node.set.remove(key);
    		if(next.val!=node.val+1){
    			insert(node,next,node.val+1,key);
    		}
    		else{
    			next.set.add(key);
    		}
    		if(node.set.isEmpty()){
    			delete(node);
    		}
    		
    	}
    	else{
    		map2.put(key, 1);
    		AOlink next=head.next;
    		if(next.val!=1){
    			insert(head,next,1,key);
    		}
    		else{
    			next.set.add(key);
    		}
    		
    	}
		System.out.println(map);
    }
    public void dec(String key) {
    	if(map2.containsKey(key)){
    		AOlink node=map.get(map2.get(key));
    		AOlink last=node.last;
    		node.set.remove(key);
    		if(node.val!=1){
    			map2.put(key, map2.get(key)-1);
    			if(last.val==node.val-1){
    				last.set.add(key);
    			}
    			else{
    				insert(last,node,node.val-1,key);
    			}
    		}
    		else
    			map2.remove(key);
    		if(node.set.isEmpty())
    			delete(node);
    		
    	}
		System.out.println(map);
    }
    public String getMaxKey() {
    	if(head.next.val==0)
    		return "";
    	return tail.last.set.iterator().next();
    }
    public String getMinKey() {
    	if(head.next.val==0)
    		return "";
    	return head.next.set.iterator().next();
    }
    private void insert(AOlink pre,AOlink next,int val,String key){
    	AOlink cur=new AOlink(val);
    	cur.set.add(key);
    	pre.next=cur;
    	cur.next=next;
    	next.last=cur;
    	cur.last=pre;
    	map.put(val, cur);
    }
    private void delete(AOlink node){
    	node.last.next=node.next;
    	node.next.last=node.last;
    	node.last=null;
    	node.next=null;
    	map.remove(node.val);
    }
}




//List<AOcell> map;
//HashMap<String,Integer> map2;
//int max=-1;
//int min=0;
//
///** Initialize your data structure here. */
//public AllOne() {
//    map=new ArrayList<AOcell>();
//    map2=new HashMap<String,Integer>();
//}
//
///** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
//public void inc(String key) {
//	if(map2.containsKey(key)){
//    	int val=map2.get(key);
//    	map.get(val).remove(key);
//    	if(val==min&&map.get(val).isEmpty())
//    		min++;
//    	else if(val==max){
//    		max++;
//    	}
//    	if(!map.containsKey(val+1)){
//    		HashSet<String> tem=new HashSet<String>();
//    		tem.add(key);
//    		map.put(val+1, tem);
//    	}
//    	else
//    		map.get(val+1).add(key);
//    	map2.put(key, val+1);
//    	max=Math.max(max, val+1);
//    }
//	else{
//		if(map.containsKey(1)){
//			map.get(1).add(key);
//			
//		}
//		else{
//    		HashSet<String> tem=new HashSet<String>();
//    		tem.add(key);
//    		map.put(1, tem);
//		}
//		map2.put(key, 1);
//    	max=Math.max(max, 1);
//    	if(min==0)
//    		min=1;
//    	else
//    		min=Math.min(min, 1);
//	}
//}
//
///** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
//public void dec(String key) {
//	if(map2.containsKey(key)){
//    	int val=map2.get(key);
//    	map.get(val).remove(key);
//    	if(val==max&&map.get(max).isEmpty()){
//    		max--;
//    	}
//    	if(val==min)
//    	{
//    		if((val==1&&map.get(val).isEmpty())||val>1)
//    			min--;
//    		if(min==0){
//    			for(int each:map.keySet()){
//    				if(!map.get(each).isEmpty()){
//    					min=each;
//    					break;
//    				}
//    			}
//    		}
//    	}
//    	if(val-1>0){
//        	if(!map.containsKey(val-1)){
//        		HashSet<String> tem=new HashSet<String>();
//        		tem.add(key);
//        		map.put(val-1, tem);
//        	}
//        	else
//        		map.get(val-1).add(key);
//        	map2.put(key, val-1);
//    	}
//    	else
//    		map2.remove(key);
//    	min=Math.min(min, min);
//    }
//}
//
///** Returns one of the keys with maximal value. */
//public String getMaxKey() {
//	if(max<1)
//		return "";
//    return map.get(max).iterator().next();
//}
//
///** Returns one of the keys with Minimal value. */
//public String getMinKey() {
//	if(min<1)
//		return "";
//    return map.get(min).iterator().next();
//}