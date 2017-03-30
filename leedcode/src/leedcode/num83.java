package leedcode;

 class ListNodex {
      int val;
      ListNodex next;
      ListNodex(int x) { val = x; }
  }
 
public class num83 {

    public ListNodex deleteDuplicates(ListNodex head) {
    	if(head==null)
    		return null;
    	ListNodex tem=head;
    	ListNodex next=head.next;
    	while(next!=null)
    	{
    		if(tem.val==next.val){
    			tem.next=next.next;
    			next=next.next;
    		}
    		else{
    			tem=tem.next;
    			next=tem.next;
    		}
    	}
    	
    	
        return head;
    }
	public static void main(String[] args) {

	}

}
