import java.util.Stack;

public class num114 {
    //does the order matter?
    // public void flatten(TreeNode root) {
    //     if(root==null)
    //         return;
    //     change(root);
    // }
    // public TreeNode change(TreeNode root){
    //     TreeNode left=null;
    //     TreeNode right=null;
    //     if(root.right!=null){
    //         right=change(root.right);
    //     }
    //     if(root.left!=null){
    //         left=change(root.left);
    //         left.right=root.right;
    //         root.right=root.left;
    //         root.left=null;
    //     }
    //     if(right==null){
    //         if(left==null)
    //             return root;
    //         return left;
    //     }
    //     return right;
    // }
    
    
    
    //short anwser
    // TreeNode pre=null;
    // public void flatten(TreeNode root){
    //     if(root==null)
    //         return;
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right=pre;
    //     root.left=null;
    //     pre=root;
    // }



    //iterative
    public void flatten(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            if(node.right!=null)
                st.push(node.right);
            if(node.left!=null)
                st.push(node.left);
            if(!st.isEmpty())
                node.right=st.peek();
            node.left=null;
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
