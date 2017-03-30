import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class num144 {

    //what if null root? 
    //Stack for every Node Time: O(N) Space: O(N)
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> res=new LinkedList<Integer>();
    //     if(root==null)
    //         return res;
    //     Stack<TreeNode> st=new Stack<TreeNode>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         TreeNode node=st.pop();
    //         res.add(node.val);
    //         if(node.right!=null)
    //             st.push(node.right);
    //         if(node.left!=null)
    //             st.push(node.left);
    //     }
    //     return res;
    // }
    
    
    //Stack only for right Time: O(N) Space: O(right)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> st=new Stack<TreeNode>();
        TreeNode node=root;
        while(node!=null){
            res.add(node.val);
            if(node.right!=null)
                st.push(node.right);
            node=node.left;
            if(node==null&&!st.isEmpty())
                node=st.pop();
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
