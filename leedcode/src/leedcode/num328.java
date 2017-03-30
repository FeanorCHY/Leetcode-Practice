package leedcode;

public class num328 {
    public ListNode oddEvenList(ListNode head) {
    	if(head==null)
    		return null;
    	if(head.next==null)
    		return head;
    	int index=1;
    	ListNode even=head.next;
    	ListNode evenNode=null;
    	ListNode node=head;
    	ListNode last=null;
    	while(node!=null){
    		if(index%2==0){
    			last.next=node.next;
    			if(evenNode!=null)
    				evenNode.next=node;
    			evenNode=node;
    			evenNode.next=null;
    			node=last.next;
    		}
    		else{
    			if(last==null)
    				last=node;
    			else
    				last=last.next;
    			node=node.next;
			}
    		index++;
    	}
    	last.next=even;
        return head;
    }
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
//		head.next.next.next=new ListNode(4);
//		head.next.next.next.next=new ListNode(5);
//		head.next.next.next.next.next=new ListNode(6);
		num328 sol=new num328();
		sol.oddEvenList(head);
		while(head!=null){
			System.out.print(head.val+"-->");
			head=head.next;
		}
	}

}
