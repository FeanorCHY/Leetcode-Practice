package leedcode;

public class num25 {
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode node=head;
    	int index=1;
    	if(k==1)
    		return head;
    	ListNode groupHead=head;
    	ListNode last=null;
    	while(node!=null){
    		if(index!=k){
    			index++;
    			node=node.next;
    		}
    		else{
    			index=1;
    			if(groupHead==head){
    				head=node;
    			}
    			ListNode next=node.next;
    			node.next=null;
    			reverse(groupHead);
    			if(last!=null){
    				last.next=node;
    			}
				last=groupHead;
    			groupHead=next;
    			node=next;
    		}
    	}
    	if(index!=1&&last!=null)
    		last.next=groupHead;
    	
    	
    	
    	return head;
    }
    public ListNode reverse(ListNode head) {
    	ListNode last=head;
    	ListNode node=head.next;
    	if(node==null)
    		return head;
    	ListNode next=head.next.next;
    	last.next=null;
    	if(next==null){
    		node.next=last;
    		return head;
    	}
    	while(node!=null){
    		node.next=last;
    		last=node;
    		node=next;
    		if(next!=null)
    			next=next.next;
    	}
    	
    	return head;
    }
	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		node.next=new ListNode(2);
		node.next.next=new ListNode(3);
		node.next.next.next=new ListNode(4);
		node.next.next.next.next=new ListNode(5);
		num25 sol=new num25();
		ListNode head=sol.reverseKGroup(node, 3);
		while(head!=null){
			System.out.print(head.val+"-->");
			head=head.next;
		}
	}

}
