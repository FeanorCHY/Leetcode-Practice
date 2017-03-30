package leedcode;

public class num92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(n==m)
    		return head;
    	ListNode node=head;
    	ListNode tail=null;
    	ListNode nodem=null;
    	int x=1;
    	boolean start=false;
    	if(x==m){
    		start=true;
    	}
    	while(x-1!=n){
    		if(nodem!=null){
    			nodem.next=node.next;
    			if(start){
    				node.next=head;
    				head=node;
				}
    			else{
    				node.next=tail.next;
    				tail.next=node;
    			}
    			node=nodem;
    		}

    		if(start&&nodem==null)
        		nodem=head;
    		if(x==m){
    			nodem=node;
    		}
    		if(x+1==m)
    			tail=node;
    			
    			
    			
			node=node.next;
    		x++;
    	}
    	
    	
        return head;
    }
	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		node.next=new ListNode(2);
		ListNode next=node.next;
		next.next=new ListNode(3);
		next=next.next;
		next.next=new ListNode(4);
		next=next.next;
		next.next=new ListNode(5);
		num92 sol=new num92();
		node=sol.reverseBetween(node, 1, 3);
		while(node!=null){
			System.out.print(node.val+"-->");
			node=node.next;
		}
	}

}
