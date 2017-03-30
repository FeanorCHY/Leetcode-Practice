
public class num061 {

    //what if k>length
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)
            return head;
        int len=0;
        ListNode node=head;
        ListNode last=null;
        while(node!=null){
            len++;
            last=node;
            node=node.next;
        }
        k=k%len;
        if(k==0)
            return head;
        node=head;
        k=len-k;
        ListNode l=null;
        while(k>0){
            l=node;
            node=node.next;
            k--;
        }
        if(l==null)
            return head;
        l.next=null;
        last.next=head;
        return node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
