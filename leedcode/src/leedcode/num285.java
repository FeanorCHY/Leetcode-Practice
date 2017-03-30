package leedcode;

public class num285 {
	boolean find=false;
	TreeNode succ=null;
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root==null)
			return null;
		TreeNode node=null;
		if(root.left!=null)
			node=inorderSuccessor(root.left,p);
		if(find==true){
			if(succ==null){
				succ=root;
				return succ;
			}
			else
				return succ;
		}
		if(root==p){
			find=true;
		}
		if(root.right!=null)
			node=inorderSuccessor(root.right,p);
		if(succ!=null){
			return succ;
		}
		return null;
	}
	
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		node.right=new TreeNode(2);
		System.out.println(new num285().inorderSuccessor(node, node));
	}

}
