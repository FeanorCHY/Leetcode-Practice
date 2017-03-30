package leedcode;

public class num226 {
    public TreeNode invertTree(TreeNode root) {
    	if(root==null)
    		return null;
    	TreeNode tem=root.left;
    	root.left=root.right;
    	root.right=tem;
    	if(root.left!=null)
    		invertTree(root.left);
    	if(root.right!=null)
    		invertTree(root.right);
    	
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
