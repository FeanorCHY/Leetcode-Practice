package leedcode;

public class num234 {
    public boolean isPalindrome(ListNode head) {
    	if(head==null)
    		return true;
    	ListNode s=head;
    	ListNode f=head;
    	ListNode last=null;
    	while(f!=null){
    		last=s;
    		s=s.next;
    		f=f.next;
    		if(f!=null)
    			f=f.next;
    	}
    	last.next=null;
    	last=null;
    	if(s==null)
    		return true;
    	ListNode next=s.next;
    	while(s!=null){
    		s.next=last;
    		last=s;
    		s=next;
    		if(next!=null)
    			next=next.next;
    	}
    	while(last!=null){
    		if(last.val!=head.val)
    			return false;
    		last=last.next;
    		head=head.next;
    	}
        return true;
    }
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
//		head.next=new ListNode(2);
		num234 sol=new num234();
		System.out.println(sol.isPalindrome(head));
	}

}



//boolean pal=true;
//ListNode head;
//public boolean isPalindrome(ListNode head) {
//	if(head==null)
//		return true;
//	this.head=head;
//	check(head);
//    return pal;
//}
//private ListNode check(ListNode node){
//	if(node.next!=null){
//		ListNode com=check(node.next);
//		if(com==null||com==node)
//			return null;
//		if(com.next.val!=node.val){
//			pal=false;
//			return null;
//		}
//		return com.next;
//	}
//	else{
//		if(node==head){
//			return null;
//		}
//		if(node.val!=head.val){
//			pal=false;
//			return null;
//		}
//		return head;
//	}
//}
