
public class num082 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode fake=new ListNode(-1);
        fake.next=head;
        ListNode last=fake;
        ListNode node=head;
        ListNode next=head.next;
        
        while(next!=null){
            if(node.val==next.val){
                while(next!=null&&next.val==node.val)
                    next=next.next;
                last.next=next;
                node=next;
                if(next!=null)
                    next=next.next;
            }
            else{
                last=node;
                next=next.next;
                node=node.next;
            }
            
        }
        return fake.next;
    }
	public static void main(String[] args) {
		num082 sol=new num082();
		sol.deleteDuplicates(null);
	}

}
