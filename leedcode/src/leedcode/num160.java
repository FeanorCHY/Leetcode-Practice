package leedcode;

public class num160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int len1=0;
    	int len2=0;
    	ListNode node=headA;
    	while(node!=null){
    		len1++;
    		node=node.next;
    	}
    	node=headB;
    	while(node!=null){
    		len2++;
    		node=node.next;
    	}
    	ListNode node2=null;
    	if(len1>len2){
    		node=headA;
    		node2=headB;
    	}
    	else{
    		node2=headA;
    		node=headB;
    	}
    	for(int i=0;i<Math.abs(len1-len2);i++){
    		node=node.next;
    	}
    	while(node!=null&&node!=node2){
    		node=node.next;
    		node2=node2.next;
    	}
    	
        return node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
