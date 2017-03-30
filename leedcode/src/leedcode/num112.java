package leedcode;

public class num112 {
	int sum;
    public boolean hasPathSum(TreeNode root, int sum) {
    	this.sum=sum;
    	if(root==null)
    		return false;
        return check(root,0);
    }
    private boolean check(TreeNode node,int pre){
    	if(node.left==null&&node.right==null){
    		if(pre+node.val==sum)
    			return true;
    		else
    			return false;
    	}
    	if(node.left!=null&&check(node.left,node.val+pre)){
    		return true;
    	}
    	if(node.right!=null&&check(node.right,node.val+pre)){
    		return true;
    	}
    	
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
