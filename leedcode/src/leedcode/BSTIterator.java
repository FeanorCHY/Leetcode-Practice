package leedcode;

import java.util.Stack;

public class BSTIterator {

	TreeNode node;
	Stack<TreeNode> st=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        node=root;
        if(node!=null)
        while(node.left!=null){
        	st.push(node);
        	node=node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(node!=null)
    		return true;
    	else
    		return false;
    }

    /** @return the next smallest number */
    public int next() {
    	int result=node.val;
    	if(node.right!=null){
    		node=node.right;
    		while(node.left!=null){
    			st.push(node);
    			node=node.left;
    		}
    	}
    	else{
    		if(st.isEmpty())
    			node=null;
    		else
    			node=st.pop();
    	}
    	
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
