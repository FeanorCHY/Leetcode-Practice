import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class num094 {

    //backtracking
    // List<Integer> res=new LinkedList<Integer>();
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if(root==null)
    //         return res;
    //     search(root);
    //     return res;
    // }
    // private void search(TreeNode root){
    //     if(root.left!=null)
    //         search(root.left);
    //     res.add(root.val);
    //     if(root.right!=null)
    //         search(root.right);
    // }
    
    
    //iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        while(root.left!=null){
            st.push(root.left);
            root=root.left;
        }
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            res.add(node.val);
            if(node.right!=null){
                node=node.right;
                while(node!=null){
                    st.push(node);
                    node=node.left;
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
