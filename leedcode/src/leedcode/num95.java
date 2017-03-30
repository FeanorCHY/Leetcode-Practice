package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num95 {
    public List<TreeNode> generateTrees(int n) {
        // 0.07
        return dfs(1, n);
    }
    
    public List<TreeNode> dfs(int left, int right) {
    	List<TreeNode> result=new ArrayList<TreeNode>();
    	if(left>right){
    		result.add(null);
    		return result;
    	}
    	for(int i=left;i<=right;i++){
    		List<TreeNode> leftT=dfs(left,i-1);
    		List<TreeNode> rightT=dfs(i+1,right);
    		for(TreeNode node1:leftT){
    			for(TreeNode node2:rightT){
    				TreeNode node=new TreeNode(i);
    				node.left=node1;
    				node.right=node2;
    				result.add(node);
    			}
    				
    		}
    	}
    	return result;
    	
    }
	public static void main(String[] args) {
		num95 sol=new num95();
		sol.generateTrees(3);
	}

}





//
//List<TreeNode> list;
//int maxn;
//TreeNode root;
//int count=1;
//public List<TreeNode> generateTrees(int n) {
//	list =new ArrayList<TreeNode>();
//	TreeNode node=new TreeNode(1);
//	if(n==0)
//		return list;
//	else if(n==1){
//		list.add(node);
//		return list;
//	}
//	maxn=n;
//	root=node;
//	tryAdd(1,root);
//   return list;
//}
//public boolean tryAdd(int x,TreeNode node){
//	if(x<maxn){
////		TreeNode newnode=new TreeNode(node.val);
//		TreeNode left=new TreeNode(x+1);
//		node.left=left;
//		tryAdd(x+1,left);
//		node.left=null;
//		node.right=left;
//		tryAdd(x+1,left);
//		node.right=null;
//		if(x+2<=maxn){
//   		node.left=left;
//			TreeNode right=new TreeNode(x+2);
//   		node.right=right;
//			if(tryAdd(x+2,left))
//				tryAdd(x+2,right);
//			node.left=null;
//			node.right=null;
//		}
//		return true;
//	}
//	else{
//		
//		TreeNode newroot=new TreeNode(root.val);
//		copyTree(root,newroot);
//		list.add(newroot);
//		count=1;
//		inorderTraversal(newroot);
//		System.out.println();
//		return false;
//	}
//}
//public TreeNode copyTree(TreeNode node,TreeNode coper){
//	if(node.left!=null){
//		coper.left=new TreeNode(node.left.val);
//   	copyTree(node.left,coper.left);
//	}
//	coper.val=count++;
//	if(node.right!=null){
//		coper.right=new TreeNode(node.right.val);
//   	copyTree(node.right,coper.right);
//	}
//	return coper;
//}
//public void inorderTraversal(TreeNode root) {
//	if(root!=null){
//		System.out.print(root.val+",");
//		if(root.left!=null||root.right!=null){
//       	if(root.left!=null)
//       		inorderTraversal(root.left);
//       	else
//       		System.out.print("null,");
//       	if(root.right!=null)
//       		inorderTraversal(root.right);
//       	else
//       		System.out.print("null,");
//		}
//	    
//	}
//}