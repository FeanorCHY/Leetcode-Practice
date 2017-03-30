package leedcode;

public class num148 {
	ListNode next;
    public ListNode sortList(ListNode head) {
    	if(head==null)
    		return head;
    	if(head.next==null){
    		return head;
    	}
    	ListNode node=head;
    	while(node.next!=null){
    		node=node.next;
    	}
    	return sortNode(null,head,node);
    }
    public ListNode sortNode(ListNode last,ListNode begin,ListNode end){
    	if(begin==end){
    		next=begin;
    		return begin;
    	}
    	if(begin.next==end){
    		if(begin.val>end.val){
    			if(last!=null)
    				last.next=end;
    			begin.next=end.next;
    			end.next=begin;
        		next=begin;
        		return end;
    		}
    		else{
    			next=end;
    			return begin;
    		}
    	}
    	else{
	    	ListNode low=begin;
	    	ListNode fast=begin;
	    	while(fast.next!=end&&fast!=end){
	    		fast=fast.next.next;
	    		low=low.next;
	    	}
    		ListNode start=sortNode(last,begin,low);
			ListNode end1=next;
    		ListNode mid=sortNode(end1,end1.next,end);
    		next=next.next;
			begin=start;
			ListNode temNext=end1;
    		while(mid!=next){
    			if(start.val<mid.val){
    				if(start==end1){
    					start.next=mid;
    					mid=next;
    				}
    				else{
	    				if(last!=null)
	    					last=last.next;
	    				else
	    					last=start;
	    				start=start.next;
    				}
    			}
    			else{
    				if(start==end1){
    					start.next=mid.next;
    				}
    				ListNode tem=mid;
    				if(last!=null){
    					last.next=mid;
    					last=last.next;
    				}
    				else
    					last=tem;
//    				if(mid.next==next){
//    					temNext=mid;
//    				}
    				mid=mid.next;
    				end1.next=mid;
    				tem.next=start;
    				if(begin==start)
    					begin=tem;
    			}
    		}
			while(temNext.next!=next){
				temNext=temNext.next;
			}
			next=temNext;
        	return begin;
    	}
    }
	public static void main(String[] args) {
		ListNode node=new ListNode(5);
		node.next=new ListNode(4);
		node.next.next=new ListNode(3);
		node.next.next.next=new ListNode(2);
		node.next.next.next.next=new ListNode(1);
		node.next.next.next.next.next=new ListNode(0);
		num148 sol=new num148();
		node=sol.sortList(node);
		while(node!=null)
		{
			System.out.print(node.val+"-->");
			node=node.next;
		}

	}

}
