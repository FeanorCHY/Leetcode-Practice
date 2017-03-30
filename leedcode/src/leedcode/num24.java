package leedcode;

public class num24 {

    public static ListNode1 swapPairs(ListNode1 head) {
    	if(head==null)
    		return null;
    	ListNode1 node=head;
    	ListNode1 next=node.next;
    	ListNode1 last=head;
    	while(node!=null && next!=null){
    		node.next=next.next;
    		next.next=node;
    		if(head==node)
    			head=next;
    		else
    			last.next=next;
    		last=node;
    		node=node.next;
    		if(node==null)
    			return head;
    		else
    			next=node.next;
    	}
    	return head;
    }
    public static void printNode(ListNode1 head)
    {
    	ListNode1 node=head;
    	while(node!=null)
    	{
    		System.out.print(node.val+"-->");
    		node=node.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 head=new ListNode1(1);
		ListNode1 curNode=head;
		for(int i=1;i<2;i++)
		{
			ListNode1 node=new ListNode1(i+1);
			curNode.next=node;
			curNode=curNode.next;
		}
		printNode(head);
		System.out.println();
		printNode(swapPairs(head));
	}

}
class ListNode1 {
	int val;
	ListNode1 next;
	ListNode1(int x) { val = x; }
}
