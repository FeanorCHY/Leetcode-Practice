package leedcode;

public class num237 {
    public void deleteNode(ListNode node) {
    	ListNode last=null;
    	if(node==null)
    		return;
    	while(node.next!=null){
    		node.val=node.next.val;
    		last=node;
    		node=node.next;
    	}
    	last.next=null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
