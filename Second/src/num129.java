
public class num129 {

    //recursive
    int res=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        sum(root,0);
        return res;
    }
    private void sum(TreeNode root,int pre){
        if(root.left==null&&root.right==null){
            res+=pre*10+root.val;
            return;
        }
        if(root.left!=null){
            sum(root.left,root.val+pre*10);
        }
        if(root.right!=null){
            sum(root.right,root.val+pre*10);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
