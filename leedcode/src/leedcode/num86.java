package leedcode;

public class num86 {
    public ListNode partition(ListNode head, int x) {
    	ListNode node=head;
    	ListNode less=null;
    	ListNode large=null;
    	while(node!=null){
    		if(node.val<x){
    			if(less==null){
    				if(large==null){
	    				less=node;
	    				node=node.next;
    				}
    				else{
    					less=node;
    					large.next=node.next;
    					node.next=head;
    					head=node;
    					node=large.next;
    				}
    			}
    			else{
    				if(large==null){
    					less=less.next;
    					node=node.next;
    				}
    				else{
	    				large.next=node.next;
	    				node.next=less.next;
	    				less.next=node;
	    				less=less.next;
	    				node=large.next;
    				}
    				
    			}
    		}
    		else{
    			if(large==null){
    				large=node;
    				node=node.next;
    			}
    			else{
    				large=large.next;
    				node=node.next;
    			}
    		}
    	}
    	
    	
    	return head;
    }  

	public static void main(String[] args) {
		ListNode node=new ListNode(4);//4->1->3->2->5->2
		node.next=new ListNode(1);
		ListNode next=node.next;
		next.next=new ListNode(3);
		next=next.next;
		next.next=new ListNode(2);
		next=next.next;
		next.next=new ListNode(5);
		next=next.next;
		next.next=new ListNode(2);
		num86 sol=new num86();
		node=sol.partition(node, 4);
		while(node!=null){
			System.out.print(node.val+"-->");
			node=node.next;
		}
	}

}
