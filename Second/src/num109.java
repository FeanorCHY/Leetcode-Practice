
public class num109 {

    //Two pointer O(NlogN)
    // public TreeNode sortedListToBST(ListNode head) {
    //     if(head==null)
    //         return null;
    //     // if(head.next==null)
    //     //     return new TreeNode(head.val);
    //     ListNode slow=head;
    //     ListNode fast=head;
    //     ListNode last=null;
    //     while(fast.next!=null){
    //         last=slow;
    //         slow=slow.next;
    //         fast=fast.next;
    //         if(fast.next!=null)
    //             fast=fast.next;
    //     }
    //     if(last!=null)
    //         last.next=null;
    //     else{
    //         return new TreeNode(head.val);
    //     }
    //     TreeNode root=new TreeNode(slow.val);
    //     root.left=sortedListToBST(head);
    //     last.next=slow;
    //     root.right=sortedListToBST(slow.next);
    //     return root;
    // }
    
    
    //two pass O(N)
    private ListNode node=null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        int size=0;
        node=head;
        ListNode fast=head;
        while(fast!=null){
            fast=fast.next;
            size++;
        }
        return search(0,size-1);
    }
    private TreeNode search(int start,int end){
        if(start>end)
            return null;
        int mid=(start+end)/2;
        TreeNode left=search(start,mid-1);
        TreeNode root=new TreeNode(node.val);
        node=node.next;
        root.left=left;
        root.right=search(mid+1,end);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
