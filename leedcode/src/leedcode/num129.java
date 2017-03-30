package leedcode;

public class num129 {
	int cur=0;
	int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
        	return 0;
        sumleaf(root);
    	return sum;
    }
    public void sumleaf(TreeNode root){
    	cur=cur*10+root.val;
        if(root.left!=null){
        	sumleaf(root.left);
        	cur=cur/10;
        }
        if(root.right!=null){
        	sumleaf(root.right);
        	cur=cur/10;
        }
        if(root.left==null&&root.right==null){
        	sum=sum+cur;
        }
        	
    }
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(1);
		node.right=new TreeNode(3);
		node.right.right=new TreeNode(3);
		num129 sol=new num129();
		System.out.println(sol.sumNumbers(node));

	}

}
