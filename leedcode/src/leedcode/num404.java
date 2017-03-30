package leedcode;

public class num404 {
	int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
    	if(root==null)
    		return 0;
    	sum(root);
    	return sum;
    }
    private void sum(TreeNode root){
    	if(root.left!=null){
    		if(root.left.left==null&&root.left.right==null)
    			sum+=root.left.val;
    		sum(root.left);
    	}
    	if(root.right!=null)
    		sum(root.right);
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
