
public class num116 {

    //constant space
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur=root;
        while(cur!=null){
            TreeLinkNode level=cur;
            while(level!=null){
                if(level.left!=null)
                    level.left.next=level.right;
                if(level.right!=null&&level.next!=null)
                    level.right.next=level.next.left;
                level=level.next;
            }
            cur=cur.left;
        }
    }
    //O(N)
    // public void connect(TreeLinkNode root) {
    //     if(root==null)
    //         return;
    //     TreeLinkNode edge=null;
    //     if(root.right!=null&&root.left!=null){
    //         root.left.next=root.right;
    //     }
    //     if(root.right!=null)
    //         edge=root.right;
    //     else if(root.left!=null)
    //         edge=root.left;
    //     if(edge!=null){
    //         TreeLinkNode parent=root.next;
    //         while(parent!=null&&parent.left==null&&parent.right==null){
    //             parent=parent.next;
    //         }
    //         if(parent!=null){
    //             edge.next=parent.left==null?parent.right:parent.left;
    //         }
    //     }
    //     if(root.right!=null){
    //         connect(root.right);
    //     }
    //     if(root.left!=null)
    //         connect(root.left);
        
    //     // while(root!=null){
    //     //     TreeLinkNode node=root;
    //     //     while(node!=null){
    //     //         System.out.print(node.val+"-->");
    //     //         node=node.next;
    //     //     }
    //     //     System.out.println();
    //     //     if(root.left!=null)
    //     //         root=root.left;
    //     //     else if(root.right!=null)
    //     //         root=root.right;
    //     //     else root=null;
    //     // }
    // }
	public static void main(String[] args) {
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		root.right=new TreeLinkNode(3);
		root.left.left=new TreeLinkNode(4);
		root.right.right=new TreeLinkNode(5);
		num116 sol=new num116();
		sol.connect(root);
	}
}
