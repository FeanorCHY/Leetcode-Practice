package leedcode;

public class num61 {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null)
    		return null;
		if(head.next==null)
		    return head;
		int len = 1;
    	ListNode last=head;
    	while(last.next!=null){
    		last=last.next;
    		len++;
    	}
    	k=k%len;
		if(k==0)
		    return head;
		k=len-k;
    	ListNode cur=head;
    	int index=1;
    	while(index!=k){
    		cur=cur.next;
    		index++;
    		if(cur.next==null){//&&index!=k
//    	    	cur.next=head;
//    	    	head.next=null;
//    	    	head=cur;
    			if(index==k)
    				cur=head;
    			break;
    			
    		}
    	}
    	last.next=head;
    	head=cur.next;
    	cur.next=null;
    	
        return head;
    }

	public static void main(String[] args) {
		num61 sol=new num61();
		ListNode node1=new ListNode(1);
		node1.next=new ListNode (2);
		node1.next.next=new ListNode (3);
		sol.rotateRight(node1, 3);
		System.out.println(2000000000%3);
		

	}

}
