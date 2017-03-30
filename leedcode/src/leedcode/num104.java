package leedcode;

public class num104 {
    public int maxDepth(TreeNode root) {
    	if(root==null)
    		return 0;
        return find(root);
    }
    private int find(TreeNode root){
    	return 1+Math.max(root.left==null?0:find(root.left), root.right==null?0:find(root.right));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
