
public class num138 {

    //change structure of original list. without hashtable
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node=head,next;
        while(node!=null){
            RandomListNode copy=new RandomListNode(node.label);
            next=node.next;
            copy.next=next;
            node.next=copy;
            node=next;
        }
        node=head;
        while(node!=null){
            if(node.random!=null)
                node.next.random=node.random.next;
            node=node.next.next;
        }
        node=head;
        RandomListNode head2=null;
        RandomListNode cur=null;
        while(node!=null){
            if(head2==null){
                head2=node.next;
                cur=head2;
            }
            else{
                cur.next=node.next;
                cur=cur.next;
            }
            node.next=cur.next;
            node=node.next;
        }
        // node=head;
        // while(node!=null){
        //     System.out.print(node.label+"-->");
        //     node=node.next;
        // }
        return head2;
    }
    
    
    //two pass with hash table space O(N)
    // public RandomListNode copyRandomList(RandomListNode head) {
    //     if(head==null)
    //         return null;
    //     RandomListNode org=head;
    //     RandomListNode node=null;//new RandomListNode(head.val);
    //     RandomListNode head2=null;//node;
    //     HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
    //     map.put(null,null);
    //     while(head!=null){
    //         if(node==null){
    //             node=new RandomListNode(head.label);
    //             map.put(head,node);
    //             head2=node;
    //         }
    //         else{
    //             node.next=new RandomListNode(head.label);
    //             map.put(head,node.next);
    //             node=node.next;
    //         }
    //         head=head.next;
            
    //     }
    //     head=org;
    //     node=head2;
    //     while(node!=null){
    //         node.random=map.get(head.random);
    //         node=node.next;
    //         head=head.next;
    //     }
    //     return head2;
    // }
    
    //one pass with hash table space O(N)
    // public RandomListNode copyRandomList(RandomListNode head) {
    //     if(head==null)
    //         return null;
    //     RandomListNode node=null;//new RandomListNode(head.val);
    //     RandomListNode head2=null;//node;
    //     HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
    //     // map.put(head,node);
    //     while(head!=null){
    //         if(map.containsKey(head)){
    //             node.next=map.get(head);
    //             node=node.next;
    //         }
    //         else{
    //             if(node==null){
    //                 node=new RandomListNode(head.label);
    //                 map.put(head,node);
    //                 head2=node;
    //             }
    //             else{
    //                 node.next=new RandomListNode(head.label);
    //                 map.put(head,node.next);
    //                 node=node.next;
    //             }
    //         }
    //         if(head.random!=null){
    //             RandomListNode ran=null;
    //             if(map.containsKey(head.random)){
    //                 ran=map.get(head.random);
    //             }
    //             else
    //                 ran=new RandomListNode(head.random.label);
    //             node.random=ran;
    //             map.put(head.random,ran);
    //         }
    //         else
    //             node.random=null;
    //         head=head.next;
            
    //     }
    //     return head2;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
