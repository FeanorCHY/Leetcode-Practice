package leedcode;

public class num235 {
	TreeNode p,q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	this.p=p;
    	this.q=q;
        return find(root);
    }
    private TreeNode find(TreeNode root){
    	TreeNode get1=null;
    	TreeNode left=null;
    	TreeNode right=null;
    	if(root==p||root==q)
    		get1=root;
    	if(root.left!=null){
    		left=find(root.left);
    	}
    	if(root.right!=null){
    		right=find(root.right);
    	}
    	if(get1!=null)
    		return get1;
    	else if(left!=null&&right!=null)
    		return root;
    	else if(left !=null)
    		return left;
    	else if(right !=null)
    		return right;
    	else 
    		return null;
    }
	public static void main(String[] args) {
		CodecT code=new CodecT();
		num235 sol=new num235();
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(1);
		root.right=new TreeNode(3);
		System.out.println(sol.lowestCommonAncestor(root, root.right, root.left).val);
	}

}
