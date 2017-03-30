
public class num142 {

    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
            return null;
        ListNode slow=head.next;
        ListNode fast=slow.next;
        if(fast==null)
            return null;
        while(fast!=null&&fast!=slow){
            slow=slow.next;
            fast=fast.next;
            if(fast==null)
                return null;
            else
                fast=fast.next;
        }
        if(fast==null)
            return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
