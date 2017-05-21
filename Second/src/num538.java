
public class num538 {

    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        traverse(root);
        return root;
    }
    private void traverse(TreeNode node){
        if(node==null)
            return;
        traverse(node.right);
        sum+=node.val;
        node.val=sum;
        traverse(node.left);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
