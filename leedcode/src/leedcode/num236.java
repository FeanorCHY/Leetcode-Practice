package leedcode;

public class num236 {
	boolean find1=false;
	boolean find2=false;
	TreeNode node1;
	TreeNode node2;
	TreeNode least;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        node1=p;
        node2=q;
        find(root);
    	return least;
    }
    public int find(TreeNode root){
    	int whom=0;
    	if(root==node1){
    		whom=1;
    		find1=true;
    	}
    	if(root==node2){
    		whom=2;
    		find2=true;
    	}
    	int left=0;
    	int right=0;
    	if(root.left!=null)
    		left=find(root.left);
    	if(left==4)
    		return 4;
    	if(left>0&&whom>0){
    		least=root;
    		return 4;
    	}
    	if(root.right!=null)
    		right=find(root.right);
    	if(right==4)
    		return 4;
    	if(right>0&&whom>0){
    		least=root;
    		return 4;
    	}
    	if(right>0&&left>0){
    		least=root;
    		return 4;
    	}
    	if((right>0||left>0)&&whom>0){
    		least=root;
    		return 4;
    	}
		else if(right>0)
			return right;
		else if(left>0)
			return left;
		else
			return whom;
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		num236 sol=new num236();
		System.out.println(sol.lowestCommonAncestor(root, root, root.right));
	}

}
