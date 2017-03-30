package leedcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int k, int v) {
        key = k;
        value = v;
    }
}
public class LRUCache { 
	private int capacity;
private Node head, tail;
private HashMap<Integer, Node> hm;

public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new Node(-1, -1);
    tail = new Node(0, 0);
    head.next = tail;
    tail.pre = head;
    this.hm = new HashMap<Integer, Node>();
}

public int get(int key) {
	System.out.println("get: "+key);
	if(hm.containsKey(key)){
		Node tem=hm.get(key);
		moveToHead(tem);
		NodeStringtail(tail);
		NodeString(head);
		return tem.value;
	}
    return -1;
}

public void set(int key, int value) {
	System.out.println("set: "+key+" value: "+value);
	if(hm.containsKey(key)){
		Node tem=hm.get(key);
		tem.value=value;
		moveToHead(tem);
	}
	else{
		Node node=new Node(key,value);
		node.next=head.next;
		head.next.pre=node;
		head.next=node;
		node.pre=head;
		hm.put(key, node);
		if(hm.size()>capacity){
			hm.remove(removeTail());
		}
	}
	NodeStringtail(tail);
	NodeString(head);
}

private void moveToHead(Node node) {
	if(head.next==node)
		return;
	else{
		Node next=node.next;
		Node pre=node.pre;
		next.pre=pre;
		pre.next=next;
		node.next=head.next;
		head.next.pre=node;
		head.next=node;
		node.pre=head;
		
	}
}

private int removeTail() {
	Node node=tail.pre;
	Node next=node.next;
	Node pre=node.pre;
	next.pre=pre;
	pre.next=next;
    return node.key;
}
    void NodeString(Node node){
    	System.out.print("from head:  ");
    	while(node!=null){
    		System.out.print(node.key+"->");
    		node=node.next;
    	}
    	System.out.println();
    }
    void NodeStringtail(Node node){
    	System.out.println();
    	String out="";
    	while(node!=null){
    		out="<-"+node.key+out;
    		node=node.pre;
    	}
		System.out.print("from tail:"+out);
    	System.out.println();
    }

}
