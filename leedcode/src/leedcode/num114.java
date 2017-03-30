package leedcode;

public class num114 {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        if(root.left!=null){
        	TreeNode right=root.right;
        	root.right=root.left;
        	root.left=null;
        	flatten(root.right);
        	TreeNode tem=root.right;
        	while(tem.right!=null){
        		tem=tem.right;
        	}
        	tem.right=right;
        	flatten(right);
        }
        else
        	flatten(root.right);
    }
//    public void build
	public static void main(String[] args) {
		num114 sol=new num114();
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(2);
		node.left.left=new TreeNode(3);
		sol.flatten(node);
		System.out.println();
	}

}
