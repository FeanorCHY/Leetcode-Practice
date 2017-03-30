import java.util.Stack;

public class num098 {

    // public boolean isValidBST(TreeNode root) {
    //     if(root==null)
    //         return true;
    //     return check(null,null,root);
    // }
    // private boolean check(TreeNode right,TreeNode left,TreeNode root){
    //     if(root.left!=null){
    //         if(root.val<=root.left.val||(right!=null&&right.val>=root.left.val))
    //             return false;
    //         if(!check(right,root,root.left))
    //             return false;
    //     }
    //     if(root.right!=null){
    //         if(root.val>=root.right.val||(left!=null&&left.val<=root.right.val))
    //             return false;
    //         if(!check(root,left,root.right))
    //             return false;
    //     }
    //     return true;
    // }
    
    
    //concise one
    // public boolean isValidBST(TreeNode root) {
    //     if(root==null)
    //         return true;
    //     return check(Long.MIN_VALUE,Long.MAX_VALUE,root);
    // }
    // private boolean check(long min,long max,TreeNode root){
    //     if(root==null)
    //         return true;
    //     if(root.val<=min||root.val>=max)
    //         return false;
    //     return check(min,root.val,root.left)&&check(root.val,max,root.right);
    // }
    
    
    
    
    
    //iterative inorder traverse
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        Stack<TreeNode> st=new Stack<TreeNode>();
        while(root!=null){
            st.push(root);
            root=root.left;
        }
        TreeNode pre=null;
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            if(pre!=null&&node.val<=pre.val)
                return false;
            pre=node;
            node=node.right;
            while(node!=null){
                st.push(node);
                node=node.left;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
