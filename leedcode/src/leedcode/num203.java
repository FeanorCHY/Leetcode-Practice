package leedcode;

public class num203 {
    public ListNode removeElements(ListNode head, int val) {
    	if(head==null)
    		return null;
    	while(head!=null&&head.val==val)
    		head=head.next;
    	ListNode node=head;
    	if(head==null)
    		return null;
    	while(node.next!=null){
    		if(node.next.val==val)
    			node.next=node.next.next;
    		else
    			node=node.next;
    	}
    	
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
