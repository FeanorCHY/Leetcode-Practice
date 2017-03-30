package leedcode;

import java.util.Stack;

public class num100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	Stack<TreeNode> stp=new Stack<TreeNode>(); 
    	Stack<TreeNode> stq=new Stack<TreeNode>();
    	if(p==null&&q==null)
    		return true;
    	else if(p==null||q==null)
    		return false;
    	stp.add(p);
    	stq.add(q);
    	while(!stp.isEmpty()){
    		TreeNode nodep=stp.pop();
    		if(stq.isEmpty())
    			return false;
    		TreeNode nodeq=stq.pop();
    		if(nodeq==null||nodep.val!=nodeq.val)
    			return false;
    		if(nodep.left!=null){
    			stp.add(nodep.left);
    			stq.add(nodeq.left);
    		}
    		else if(nodeq.left!=null)
    			return false;
    				
    		if(nodep.right!=null){
    			stp.add(nodep.right);
    			stq.add(nodeq.right);
    		}
    		else if(nodeq.right!=null)
    			return false;
    	}
    	if(!stq.isEmpty())
    		return false;
    	
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
