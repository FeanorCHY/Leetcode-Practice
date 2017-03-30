import java.util.Random;

public class Solution382 {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    Random ran;
    public Solution382(ListNode head) {
        this.head=head;
        ran=new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node=head;
        ListNode res=head;
        int num=1;
        while(node!=null){
            if(ran.nextInt(num++)==0)
                res=node;
            node=node.next;
        }
        return res.val;
    }
}