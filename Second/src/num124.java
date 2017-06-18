
public class num124 {

    //backtracking
    long res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        search(root);
        return (int)res;
    }
    private long search(TreeNode root){
        if(root==null)
            return (long)Integer.MIN_VALUE-1;
        long left=search(root.left);
        long right=search(root.right);
        res=Math.max(root.val,Math.max(left+(long)root.val,Math.max(res,Math.max(right+(long)root.val,left+right+(long)root.val))));
        return Math.max(left+root.val,Math.max(right+(long)root.val,root.val));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
