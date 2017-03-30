package leedcode;

public class num141 {
    public boolean hasCycle(ListNode head) {
    	ListNode f=head;
    	ListNode s=head;
    	if(head==null)
    		return false;
    	s=s.next;
    	if(s==null)
    		return false;
    	f=s.next;
    	while(f!=null){
    		s=s.next;
    		if(f.next!=null)
    			f=f.next.next;
    		else
    			return false;
    		if(s==f)
    			return true;
    	}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
