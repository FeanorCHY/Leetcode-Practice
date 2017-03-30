package leedcode;

import java.util.Random;

public class Solution382 {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
	ListNode head;
    private Random mRandom;
    public Solution382(ListNode head) {
        this.head=head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    	mRandom=new Random();
        ListNode node=head;
    	if(node==null)
    		return 0;
        ListNode res=node;
        node=node.next;
        int count=2;
        while(node!=null){
        	if(mRandom.nextInt(count++)==0){
        		res=node;
        	}
        	node=node.next;
        }
    	
        return res.val;
    }
}