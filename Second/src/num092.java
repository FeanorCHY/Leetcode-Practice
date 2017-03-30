
public class num092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode node=head;
        ListNode last=null;
        while(m>1){
            last=node;
            node=node.next;
            m--;
            n--;
        }
        ListNode front=last;
        if(last!=null)
            last.next=null;
        ListNode tail=node;
        last=node;
        node=node.next;
        ListNode next=node.next;
        while(n>1){
            node.next=last;
            last=node;
            node=next;
            if(next!=null)
                next=next.next;
            n--;
        }
        tail.next=node;
        if(front!=null)
            front.next=last;
        else
            head=last;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
