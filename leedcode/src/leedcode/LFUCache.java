package leedcode;

import java.util.HashMap;

class LFUNode{
	LFUNode pre=null;
	LFUNode next=null;
	int fre=0;
	int val;
	int key;
	public LFUNode(int key,int val){
		this.val=val;
		this.key=key;
	}
}
public class LFUCache {
	LFUNode head;
	LFUNode tail;
	int len;
	HashMap<Integer,LFUNode> map;
    public LFUCache(int capacity) {
        head=new LFUNode(0,0);
        head.fre=Integer.MAX_VALUE;
        tail=new LFUNode(0,0);
        head.next=tail;
        tail.pre=head;
        len=capacity;
        map=new HashMap<Integer,LFUNode>();
    }
    
    public int get(int key) {
    	if(!map.containsKey(key))
    		return -1;
    	LFUNode cur=map.get(key);
    	LFUNode pre=cur.pre;
    	delete(cur);
    	cur.fre++;
    	addFrom(pre,cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
    	if(len==0)
    		return;
        if(!map.containsKey(key)){
        	LFUNode cur=new LFUNode(key,value);
        	if(len==map.size()){
        		map.remove(tail.pre.key);
        		delete(tail.pre);
        	}
    		addFrom(tail,cur);
    		map.put(key, cur);
        }
        else{
        	LFUNode cur=map.get(key);
        	cur.val=value;
        	LFUNode pre=cur.pre;
        	delete(cur);
        	cur.fre++;
        	addFrom(pre,cur);
        }
    }
    private void delete(LFUNode node){
    	node.pre.next=node.next;
    	node.next.pre=node.pre;
    	node.next=null;
    	node.pre=null;
    }
    private void insert(LFUNode node,LFUNode cur){
    	cur.next=node.next;
    	cur.pre=node;
    	node.next.pre=cur;
    	node.next=cur;
    }
    private void addFrom(LFUNode from,LFUNode cur){
    	while(from.fre<=cur.fre)
    		from=from.pre;
    	insert(from,cur);
    }
}
