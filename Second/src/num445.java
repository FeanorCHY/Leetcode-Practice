import java.util.Stack;

public class num445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> st1=new Stack<ListNode>();
        Stack<ListNode> st2=new Stack<ListNode>();
        while(l1!=null){
            st1.push(l1);
            l1=l1.next;
        }
        while(l2!=null){
            st2.push(l2);
            l2=l2.next;
        }
        ListNode next=null;
        int plus=0;
        while(!st1.isEmpty()||!st2.isEmpty()||plus!=0){
            int sum=(st1.isEmpty()?0:st1.pop().val)+(st2.isEmpty()?0:st2.pop().val)+plus;
            plus=sum/10;
            sum=sum%10;
            ListNode node=new ListNode(sum);
            node.next=next;
            next=node;
        }
        return next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
