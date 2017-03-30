package leedcode;

public class num110 {
	boolean res=true;
    public boolean isBalanced(TreeNode root) {
    	if(root==null)
    		return res;
    	check(root);
    	
        return res;
    }
    private int check(TreeNode root){
    	if(root.right==null&&root.left==null)
    		return 1;
    	int right=0;
    	int left=0;
    	if(root.right!=null)
    		right=check(root.right);
    	if(root.left!=null)
    		left=check(root.left);
    	if(Math.abs(right-left)>1)
    		res=false;
    	return Math.max(right, left);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
