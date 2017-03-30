package leedcode;

import java.util.Stack;

public class num445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	Stack<ListNode> st1=new Stack<ListNode>();
    	Stack<ListNode> st2=new Stack<ListNode>();
    	ListNode node=l1;
    	while(node!=null){
    		st1.add(node);
    		node=node.next;
    	}
    	node=l2;
    	while(node!=null){
    		st2.add(node);
    		node=node.next;
    	}
    	int add=0;
    	ListNode last=null;
    	while(!st1.isEmpty()||!st2.isEmpty()){
    		ListNode node1=st1.isEmpty()?null:st1.pop();
    		ListNode node2=st2.isEmpty()?null:st2.pop();
    		int sum=(node1==null?0:node1.val)+(node2==null?0:node2.val)+add;
    		ListNode cur=new ListNode(sum%10);
    		add=sum/10;
    		cur.next=last;
    		last=cur;
    	}
    	if(add!=0){
    		ListNode cur=new ListNode(add);
    		cur.next=last;
    		last=cur;
    	}
    	
        return last==null?new ListNode(0):last;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
