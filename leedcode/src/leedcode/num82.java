package leedcode;

public class num82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
    	ListNode node=head;
    	ListNode next=node.next;
    	boolean dup=false;
    	ListNode last=null;
    	while(next!=null)
    	{
    		if(node.val==next.val){
    			node.next=next.next;
    			next.next=null;
    			next=node.next;
    			dup=true;
    		}
    		else{
    			if(dup)
    			{
    				if(head==node){
    					head=node.next;
    					node.next=null;
    					node=head;
    					if(node!=null)
    						next=head.next;
    					else
    						next=null;
    				}
    				else{
    					last.next=node.next;
    					node.next=null;
    					node=last.next;
    					if(node!=null)
    						next=node.next;
    					else
    						next=null;
    				}
    				dup=false;
    			}
    			else{
        			if(node==head)
        				last=node;
        			else
        				last=last.next;
        			node=node.next;
        			next=node.next;
    			}
    		}
    	}
		if(dup)
		{
			if(head==node){
				head=node.next;
				if(head!=null)
					next=head.next;
				else
					next=null;
				node.next=null;
			}
			else{
				last.next=node.next;
				node.next=null;
				node=last.next;
				if(node!=null)
					next=node.next;
				else
					next=null;
			}
		}
    	return head;
    }
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		node1.next=new ListNode(1);
		num82 sol=new num82();
	}

}
