package leedcode;

import java.util.Stack;

public class num369 {
    public ListNode plusOne(ListNode head) {
    	Stack<ListNode> st=new Stack<ListNode>();
    	ListNode node=head;
    	if(node==null)
    		return head;
		st.add(node);
    	while(node.next!=null){
    		node=node.next;
    		st.add(node);
    	}
		while(!st.isEmpty()){
			node=st.pop();
			if(node.val!=9){
				node.val=node.val+1;
				break;
			}
			else
				node.val=0;
		}
		if(node.val==0){
			ListNode newone=new ListNode(1);
			newone.next=node;
			head=newone;
		}
    	
    	return head;
    }
	public static void main(String[] args) {
		num369 sol=new num369();
		ListNode node=new ListNode(9);
		node.next=new ListNode(9);
		node.next.next=new ListNode(9);
		node=sol.plusOne(node);
		while(node!=null){
			System.out.print(node.val+"-->");
			node=node.next;
		}
	}

}
