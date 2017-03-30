import java.util.Stack;

public class BSTIterator {

    TreeNode root;
    Stack<TreeNode> st;
    TreeNode node;
    public BSTIterator(TreeNode root) {
        this.st=new Stack<TreeNode>();
        this.root=root;
        node=root;
        if(root!=null){
            while(node.left!=null){
                st.push(node);
                node=node.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node!=null;
    }

    /** @return the next smallest number */
    public int next() {
        int cur=node.val;
        if(node.right==null){
            node=st.isEmpty()?null:st.pop();
        }
        else{
            node=node.right;
            while(node.left!=null){
                st.push(node);
                node=node.left;
            }
        }
        
        
        return cur;
    }
}
