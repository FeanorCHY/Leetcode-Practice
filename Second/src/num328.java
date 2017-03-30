
public class num328 {

    //simple
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    
    //mine
    // public ListNode oddEvenList(ListNode head) {
    //     if(head==null||head.next==null||head.next.next==null) return head;
    //     ListNode odd=head;
    //     ListNode even=head.next;
    //     ListNode node=even.next;
    //     ListNode even1=even;
    //     ListNode odd1=odd;
    //     while(node!=null){
    //         odd1.next=node;
    //         node=node.next;
    //         odd1=odd1.next;
    //         if(node==null)
    //             break;
    //         even1.next=node;
    //         node=node.next;
    //         even1=even1.next;
    //     }
    //     odd1.next=even;
    //     if(even1!=null)
    //         even1.next=null;
    //     return odd;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
