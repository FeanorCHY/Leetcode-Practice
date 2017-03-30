package leedcode;

public class num124 {
	int max=Integer.MIN_VALUE;
	boolean head=true;
    public int maxPathSum(TreeNode root) {
    	boolean ishead=head;
    	if(head)
    		head=false;
    	int left=0;
    	int right=0;
    	if(root.left!=null){
    		left=Math.max(maxPathSum(root.left),0);
    	}
    	if(root.right!=null){
    		right=Math.max(maxPathSum(root.right),0);
    	}
    	max=Math.max(root.val+left+right, max);
    	if(ishead)
    		return max;
    	else
    		return root.val+Math.max(left, right);
    }
//    public int 
	public static void main(String[] args) {
		num124 sol=new num124();
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(-2);
//		node.right=new TreeNode(3);
		System.out.println(sol.maxPathSum(node));
	}

}
