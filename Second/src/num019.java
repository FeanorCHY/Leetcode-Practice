
public class num019 {

    //one pass two pointer  
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null){
            head=head.next;
            return head;
        }
        ListNode slow=head;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    
    
    
    //two pass with Stack
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     Stack<ListNode> st=new Stack<ListNode>();
    //     ListNode node=head;
    //     while(node!=null){
    //         st.push(node);
    //         node=node.next;
    //     }
    //     for(int i=0;i<n;i++){
    //         node=st.pop();
    //     }
    //     if(node==head){
    //         head=head.next;
    //     }
    //     else{
    //         st.peek().next=node.next;
    //     }
    //     return head;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
