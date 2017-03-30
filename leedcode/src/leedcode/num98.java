package leedcode;

public class num98 {
	long max=(long)Integer.MIN_VALUE-3;
	boolean start=true;
    public boolean isValidBST(TreeNode root) {
    	if(root==null)
    		return true;
    	if(root.left==null&&root.right==null)
    		return true;
        return toValid(root);
    }
    public boolean toValid(TreeNode root){
    	long val=root.val;
    	if(root.left!=null){
    		if(!toValid(root.left))
    			return false;
    		if(val>max){
        		max=val;
        		if(root.right!=null)
        			if(!toValid(root.right))
        				return false;
    			}
    		else
    			return false;
    		
    	}
    	else{
    		if(val>max){
        		max=val;
        		if(root.right!=null)
        			if(!toValid(root.right))
        				return false;
    			}
    		else
    			return false;
    	}
    	return true;
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(2);
		TreeNode left=new TreeNode(1);
		TreeNode right=new TreeNode(3);
		root.left=left;
		root.right=right;
		num98 sol=new num98();
		sol.isValidBST(root);
	}

}
