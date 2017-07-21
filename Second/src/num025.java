
public class num025 {

    //iterative Time O(n) Space O(1)
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if(head==null||head.next==null||k==1)
//             return head;
//         ListNode node=head;
//         int len=0;
//         while(node!=null){
//             node=node.next;
//             len++;
//         }
//         ListNode dummy=new ListNode(0);
//         dummy.next=head;
//         ListNode last=head;
//         node=head.next;
//         ListNode behind=dummy;
//         for(int i=k;i<=len;i+=k){
//             ListNode nextHead=last;
//             for(int j=0;j<k-1;j++){
//                 ListNode next=node.next;
//                 node.next=last;
//                 last=node;
//                 node=next;
//             }
//             behind.next=last;
//             behind=nextHead;
//             nextHead.next=node;
//             last=node;
//             if(node!=null)
//                 node=node.next;
//         }
//         return dummy.next;
            
//     }
    
    //one pass Time O(n) Space O(n/k)
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1)
            return head;
        ListNode cur=head;
        int count=0;
        while(cur!=null&&count!=k){
            cur=cur.next;
            count++;
        }
        if(count==k){
            cur=reverseKGroup(cur,k);
            while(count-->0){
                ListNode next=head.next;
                head.next=cur;
                cur=head;
                head=next;
            }
            return cur;
        }
        return head;
            
    }
}
