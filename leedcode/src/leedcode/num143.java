package leedcode;

import java.util.Stack;

public class num143 {
    public void reorderList(ListNode head) {
    	if(head==null)
    		return;
    	if(head.next==null)
    		return;
        ListNode node=head;
        int len=1;
        Stack<ListNode> st=new Stack<ListNode>();
        st.push(head);
        while(node.next!=null){
        	node=node.next;
        	st.push(node);
        	len++;
        }
        if(len==2)
        	return;
        int index=1;
        node=head;
        while(index!=len/2+1){
        	ListNode tail=st.pop();
        	tail.next=node.next;
        	node.next=tail;
        	node=tail.next;
        	index++;
        }
        if(len%2==1)
        	st.pop().next=null;
        else
        	node.next=null;
    }
	public static void main(String[] args) {
	}

}
