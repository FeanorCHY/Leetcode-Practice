
public class num023 {

    //divide and conquer Time O(nklogk) Space O(logk)
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null||lists.length==0)
            return null;
        return partition(lists,0,lists.length-1);
    }
    private ListNode partition(ListNode[] lists,int s,int e){
        if(s==e)
            return lists[s];
        else if(s<e){
            int m=(s+e)/2;
            ListNode l1=partition(lists,s,m);
            ListNode l2=partition(lists,m+1,e);
            return merge(l1,l2);
        }
        else
            return null;
    }
    private ListNode merge(ListNode l1,ListNode l2){
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        else{
            ListNode head=new ListNode(0);
            ListNode tail=head;
            while(l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    tail.next=l1;
                    tail=l1;
                    l1=l1.next;
                    tail.next=null;
                }
                else{
                    tail.next=l2;
                    tail=l2;
                    l2=l2.next;
                    tail.next=null;
                }
            }
            if(l1==null)
                tail.next=l2;
            else
                tail.next=l1;
            return head.next;
        }
    }
    
    //priorityQueue Time O(knlogk+klogk) Space O(k)
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists==null||lists.length==0)
    //         return null;
    //     ListNode head=new ListNode(0);
    //     ListNode node=head;
    //     PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
    //         @Override
    //         public int compare(ListNode l1,ListNode l2){
    //             return l1.val-l2.val;
    //         }
    //     });
    //     for(ListNode list:lists){
    //         if(list!=null)
    //             pq.add(list);
    //     }
    //     while(!pq.isEmpty()){
    //         ListNode list=pq.poll();
    //         if(list.next!=null)
    //             pq.add(list.next);
    //         list.next=null;
    //         node.next=list;
    //         node=list;
    //     }
    //     return head.next;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
