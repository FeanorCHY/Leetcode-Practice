package leedcode;
public class num2 {
	static void printList(ListNode l)
	{
		System.out.print(l.val);
		while(l.next!=null)
		{
			System.out.print(" -> ");
			l=l.next;
			System.out.print(l.val);
		}
		System.out.println();
	}
	 static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode l3=new ListNode((l1.val+l2.val)%10);
		 int toNext=(l1.val+l2.val)/10;
		 ListNode nextNode=l3;
		 while(l1.next!=null||l2.next!=null)
		 {
			 if(l1.next==null)
			 {
				 l1.next=new ListNode(0);
			 }
			 if(l2.next==null)
			 {
				 l2.next=new ListNode(0);
			 }
			 l1=l1.next;
			 l2=l2.next;
			 nextNode.next=new ListNode((l1.val+l2.val+toNext)%10);
			 toNext=(l1.val+l2.val+toNext)/10;
			 nextNode=nextNode.next;
		 }
		 if(toNext==1)
		 {
			 nextNode.next=new ListNode(toNext);
		 }
		 return l3;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(9);
		l1.next=new ListNode(9);
//		l1.next.next=new ListNode(3);
		ListNode l2=new ListNode(1);
//		l2.next=new ListNode(6);
//		l2.next.next=new ListNode(9);
		printList(l1);
		printList(l2);
		printList(addTwoNumbers(l1,l2));
	}

}
