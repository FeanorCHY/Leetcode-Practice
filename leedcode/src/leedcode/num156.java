package leedcode;

public class num156 {
	TreeNode BigRoot=null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
    	if(root==null)
    		return null;
    	if(root.left==null)
    		return root;
    	
    	
    	build(root);
    	return BigRoot;
    }
    public TreeNode build(TreeNode root){
    	if(root.left.left!=null){
    		TreeNode newRoot=build(root.left);
    		newRoot.right=root;
    		newRoot.left=root.right;
    		root.right=null;
    		root.left=null;
    		return newRoot.right;
    	}
    	else{
    		TreeNode newRoot=root.left;
    		newRoot.left=root.right;
    		newRoot.right=root;
    		root.left=null;
    		root.right=null;
    		BigRoot=newRoot;
    		return root;
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
