import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class num145 {

    //iterative Time O(n) Space O(h)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            res.add(0,node.val);
            if(node.left!=null)
                st.push(node.left);
            if(node.right!=null)
                st.push(node.right);
        }
        return res;
    }
	public static void main(String[] args) {
	}

}
