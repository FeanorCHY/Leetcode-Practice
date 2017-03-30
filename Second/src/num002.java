
public class num002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode node=null;
        int plus=0;
        while(l1!=null||l2!=null){
            int sum=(l1==null?0:l1.val)+(l2==null?0:l2.val)+plus;
            plus=sum/10;
            sum=sum/10;
            if(node==null){
                node=new ListNode(sum);
                head=node;
            }
            else{
                node.next=new ListNode(sum);
                node=node.next;
            }
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(plus==1)
            node.next=new ListNode(1);
        if(head==null)
            return new ListNode(0);
        return head;
    }
	public static void main(String[] args) {
//		num002 sol=new num002();
//		String test="dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
//		long startTime=System.currentTimeMillis();
//		sol.longestPalindrome2(test);
//		long endTime=System.currentTimeMillis();
//		System.out.println("run time 2:"+(endTime-startTime)/60000.0+" min"); 
//		System.out.println();
//		startTime=System.currentTimeMillis();
//		sol.longestPalindrome(test);
//		endTime=System.currentTimeMillis();
//		System.out.println("run time 1:"+(endTime-startTime)/60000.0+" min");
	}

}
