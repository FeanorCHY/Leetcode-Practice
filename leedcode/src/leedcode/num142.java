package leedcode;

import java.util.HashSet;

public class num142 {
    public ListNode detectCycle(ListNode head) {
    	ListNode node1=head;
    	ListNode node2=head;
    	try{
	    	node1=node1.next;
	    	node2=node2.next.next;
	    	while(node1!=node2){
	        	node1=node1.next;
	        	node2=node2.next.next;
	    	}
	    	node2=head;
	    	while(node1!=node2){
	        	node1=node1.next;
	        	node2=node2.next;
	    	}
    	}
    	catch(Exception e){
    		return null;
    	}
    	
    	return node1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



//if(head==null){
//	return null;
//}
//HashSet<ListNode> hs=new HashSet<ListNode>();
//ListNode node=head;
//while(!hs.contains(node))
//{
//	hs.add(node);
//	node=node.next;
//	if(node==null)
//		return null;
//}
//return node;