package leedcode;

public class num99 {
	TreeNode last;
	TreeNode large=null;
	TreeNode less=null;
    public void recoverTree(TreeNode root) {
 	  traverse(root);
 	  if(large!=null){
		  int tem=large.val;
		  large.val=less.val;
		  less.val=tem;
 	  }
    }
   public boolean traverse(TreeNode root){
//	   if(root.left!=null&&root.left.val<root.val){
//		   
//	   }
	   if(root.left!=null){
		   traverse(root.left);
	   }
	   if(last==null)
		   last=root;
	   else if(root.val<last.val){
		   if(large==null){
			   large=last;
			   less=root;
			   last=root;
			   
		   }
		   else{
			   less=root;
		   }
	   }
	   else{
		   last=root;
	   }
	   if(root.right!=null){
		   traverse(root.right);
	   }
	   
	   return true;
   }
	public static void main(String[] args) {
		TreeNode node=new TreeNode(2);
		node.left=new TreeNode(1);
		node.left.right=new TreeNode(3);
		num99 sol=new num99();
		sol.recoverTree(node);
	}

}
