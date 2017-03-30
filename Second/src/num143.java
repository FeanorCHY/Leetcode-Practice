
public class num143 {

    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode slow=head;
        ListNode last=null;
        ListNode fast=head;
        while(fast!=null){
            last=slow;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
        }
        if(last!=head)
            last.next=null;
        else
            return;
        last=null;
        fast=slow.next;
        while(slow!=null){
            slow.next=last;
            last=slow;
            slow=fast;
            if(fast!=null)
                fast=fast.next;
        }
        fast=head;
        while(last!=null){
            slow=last;
            last=last.next;
            slow.next=fast.next;
            fast.next=slow;
            fast=slow.next;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
