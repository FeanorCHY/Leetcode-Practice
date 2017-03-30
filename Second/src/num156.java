
public class num156 {

    //iterative with Stack
    // public TreeNode upsideDownBinaryTree(TreeNode root) {
    //     if(root==null)
    //         return root;
    //     Stack<TreeNode> st=new Stack<TreeNode>();
    //     while(root!=null){
    //         st.push(root);
    //         root=root.left;
    //     }
    //     TreeNode res=st.pop();
    //     TreeNode pre=res;
    //     while(!st.isEmpty()){
    //         TreeNode node=st.pop();
    //         pre.left=node.right;
    //         pre.right=node;
    //         node.left=null;
    //         node.right=null;
    //         pre=node;
    //     }
    //     return res;
    // }
    
    
    
    //recursive
    // public TreeNode upsideDownBinaryTree(TreeNode root) {
    //     if(root==null||root.left==null)
    //         return root;
    //     TreeNode newroot=upsideDownBinaryTree(root.left);
    //     root.left.left=root.right;
    //     root.left.right=root;
    //     root.left=null;
    //     root.right=null;
    //     return newroot;
    // }
    
    
    
    //iterative without Stack
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur=root;
        TreeNode pre=null;
        TreeNode right=null;
        while(cur!=null){
            TreeNode temR=cur.right;
            TreeNode temL=cur.left;
            cur.left=right;
            cur.right=pre;
            right=temR;
            pre=cur;
            cur=temL;
        }
        return pre;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
