package leedcode;

import java.awt.List;

import javax.swing.event.ListSelectionEvent;

public class num23 {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length>2){
    		ListNode[] list1=new ListNode[lists.length/2];
    		ListNode[] list2=new ListNode[lists.length-lists.length/2];
    		for(int i=0;i<lists.length;i++){
    			if(i<list1.length)
    				list1[i]=lists[i];
    			else{
    				list2[i-list1.length]=lists[i];
    			}
    		}
    		ListNode head1=mergeKLists(list1);
    		ListNode head2=mergeKLists(list2);
    		ListNode[] result=new ListNode[2];
    		result[0]=head1;
    		result[1]=head2;
    		return mergeKLists(result);
    	}
    	else if(lists.length==2){
    		ListNode head=null;
    		ListNode node=null;
    		while(lists[0]!=null&&lists[1]!=null){
    			int low=-1;
    			if(lists[0].val<lists[1].val){
    				low=0;
    			}
    			else
    				low=1;
    			if(head==null){
    				head=lists[low];
    				node=lists[low];
    				lists[low]=lists[low].next;
    				node.next=null;
    			}
    			else{
    				node.next=lists[low];
    				lists[low]=lists[low].next;
    				node=node.next;
    				node.next=null;
    			}
    		}
    		if(head==null&&lists[0]==null&&lists[1]==null)
    		    return head;
    		if(head==null){
    			head=lists[0]==null?lists[1]:lists[0];
    			return head;
    		}
    		if(lists[0]==null){
    			node.next=lists[1];
    		}
    		else
    			node.next=lists[0];
    		return head;
    		
    	}
    	else if(lists.length==1){
    		return lists[0];
    	}
    	else
    		return null;
    }
	public static void main(String[] args) {
		ListNode[] lists=new ListNode[1];
		lists[0]=new ListNode(1);
		lists[0].next=new ListNode(2);
		lists[0].next.next=new ListNode(5);
		num23 sol=new num23();
		ListNode node=sol.mergeKLists(lists);
		while(node!=null){
			System.out.print(node.val+"-->");
			node=node.next;
		}
	}

}
