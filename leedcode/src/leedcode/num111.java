package leedcode;

import java.util.Stack;

public class num111 {
    public int minDepth(TreeNode root) {
    	Stack<TreeNode> st=new Stack<TreeNode>();
    	if(root==null)
    		return 0;
    	st.push(root);
    	int count=1;
    	while(!st.isEmpty()){
    		Stack<TreeNode> tem=new Stack<TreeNode>();
    		while(!st.isEmpty()){
    			TreeNode node=st.pop();
    	    	if(node.right==null&&node.left==null)
    	    		return count;
    			if(node.left!=null)
    				tem.push(node.left);
    			if(node.right!=null)
    				tem.push(node.right);
    		}
    		count++;
    		st=tem;
    	}
    	return count;
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		num111 sol=new num111();
		System.out.println(sol.minDepth(root));
	}

}
