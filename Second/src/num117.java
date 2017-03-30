
public class num117 {

    //bfs
    // public void connect(TreeLinkNode root) {
    //     if(root==null)
    //         return;
    //     TreeLinkNode cur=root;
    //     while(cur!=null){
    //         TreeLinkNode tem=cur;
    //         TreeLinkNode next=null;//get the first node of next level
    //         while(tem!=null){
    //             if(tem.left!=null&&tem.right!=null){//connect children
    //                 tem.left.next=tem.right;
    //                 if(next==null)
    //                     next=tem.left;//get the first node of next level
    //             }
    //             if(tem.left!=null||tem.right!=null){//if so find their cousin
    //                 if(next==null)
    //                     next=(tem.left!=null?tem.left:tem.right);//get the first node of next level
    //                 TreeLinkNode temtem=tem;
    //                 tem=tem.next;//next uncle
    //                 while(tem!=null&&tem.left==null&&tem.right==null){//find counsin
    //                     tem=tem.next;
    //                 }
    //                 if(tem!=null){//if there is a cousin
    //                     if(temtem.right!=null)
    //                         temtem.right.next=(tem.left!=null?tem.left:tem.right);
    //                     else
    //                         temtem.left.next=(tem.left!=null?tem.left:tem.right);
    //                 }
    //             }
    //             else
    //                 tem=tem.next;
    //         }
    //         cur=next;
    //     }
    // }
    
    
    
    //dfs
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        if(root.left!=null&&root.right!=null){
            root.left.next=root.right;//connect its children
        }
        TreeLinkNode edge=null;
        edge=(root.right!=null?root.right:root.left);
        if(edge!=null){
            TreeLinkNode uncle=root.next;
            while(uncle!=null&&uncle.left==null&&uncle.right==null){//find counsin
                uncle=uncle.next;
            }
            if(uncle!=null)
                edge.next=(uncle.left!=null?uncle.left:uncle.right);
        }
        connect(root.right);
        connect(root.left);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
