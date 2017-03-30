package leedcode;

public class num147 {
    public ListNode insertionSortList(ListNode head) {
    	if(head==null)
    		return head;
    	if(head.next==null)
    		return head;
    	ListNode node=head;
    	ListNode next=node.next;
    	while(next!=null){
    		ListNode x=node.next;
    		next=next.next;
    		node.next=x.next;
    		x.next=null;
    		ListNode start=head;
    		ListNode last=null;
    		while(start!=next){
    			if(start.val>x.val)
    				break;
    			if(last==null)
    				last=start;
    			else
    				last=last.next;
				start=start.next;
    		}
    		if(start==head){
    			x.next=head;
    			head=x;
    		}
    		else if(start==next){
    			node.next=x;
    			x.next=next;
    			node=x;
    		}
    		else{
    			x.next=last.next;
    			last.next=x;
    		}
    	}
    	
    	
    	return head;
    }
	public static void main(String[] args) {
		ListNode head=new ListNode(4);
		head.next=new ListNode(2);
		head.next.next=new ListNode(1);
		head.next.next.next=new ListNode(3);
		num147 sol=new num147();
		head=sol.insertionSortList(head);
		while(head!=null){
			System.out.print(head.val);
			head=head.next;
		}
	}

}
