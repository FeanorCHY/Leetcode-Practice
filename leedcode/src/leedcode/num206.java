package leedcode;

public class num206 {
    public ListNode reverseList(ListNode head) {
    	ListNode last=null;
    	ListNode node=head;
    	if(head==null)
    		return head;
    	ListNode next=head.next;
    	while(node!=null){
    		node.next=last;
    		last=node;
    		node=next;
    		System.out.println(node);
    		if(node!=null)
    			next=node.next;
    	}
    	
    	
    	return last;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
