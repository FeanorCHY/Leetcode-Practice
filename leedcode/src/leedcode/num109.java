package leedcode;

public class num109 {
    public TreeNode sortedListToBST(ListNode head) {
    	int len=0;
    	ListNode node=head;
    	while(node!=null)
    	{
    		len++;
    		node=node.next;
    	}
    	TreeNode root=build(head,1,len);
        return root;
    }
    public TreeNode build(ListNode begin,int start,int end){
    	if(start>end)
    		return null;
    	if(start==end)
    		return new TreeNode(begin.val);
    	int mid=(start+end)/2;
    	ListNode midnode=begin;
    	int index=start;
//    	ListNode last=null;
    	while(index!=mid){
    		index++;
//    		if(last==null)
//    			last=midnode;
//    		else
//    			last=last.next;
    		midnode=midnode.next;
    	}
    	TreeNode root=new TreeNode(midnode.val);
    	root.left=build(begin,start,mid-1);
    	root.right=build(midnode.next,mid+1,end);
    	
    	
    	return root;
    }
	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		node.next=new ListNode(2);
		node.next.next=new ListNode(3);
		num109 sol=new num109();
		sol.sortedListToBST(node);
	}

}
