
public class num337 {

    //DFS O(N)
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int res[]=search(root);
        return Math.max(res[0],res[1]);
    }
    private int[] search(TreeNode root){
        int[] res=new int[2];
        res[0]+=root.val;
        if(root.left!=null){
            int[] tem=search(root.left);
            res[1]+=Math.max(tem[0],tem[1]);
            res[0]+=tem[1];
        }
        if(root.right!=null){
            int[] tem=search(root.right);
            res[1]+=Math.max(tem[0],tem[1]);
            res[0]+=tem[1];
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
