
public class num086 {

    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
            return head;
        ListNode less=new ListNode(0);
        ListNode large=new ListNode(0);
        ListNode sidx=less;
        ListNode lidx=large;
        ListNode node=head;
        while(node!=null){
            if(node.val<x){
                sidx.next=node;
                sidx=sidx.next;
                node=node.next;
                sidx.next=null;
            }
            else{
                lidx.next=node;
                lidx=lidx.next;
                node=node.next;
                lidx.next=null;
            }
        }
        sidx.next=large.next;
        return less.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
