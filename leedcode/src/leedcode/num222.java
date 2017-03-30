package leedcode;

import java.util.Stack;

public class num222 {
    public int countNodes(TreeNode root) {
    	if(root==null)
    		return 0;
    	TreeNode node=root;
    	int levelleft=1;
    	int levelright=1;
    	while(node.left!=null){
	    	levelleft++;
	    	node=node.left;
	    }
	    node=root;
	    while(node.right!=null){
	    	levelright++;
	    	node=node.right;
	    }
	    if(levelright==levelleft)
	    	return (2<<(levelleft-1))-1;
	    else{
	    	if(root.left!=null&&root.right!=null)
	    		return countNodes(root.left)+countNodes(root.right)+1;
	    	else if(root.left!=null&&root.right==null)
	    		return 2;
	    	else
	    		return 1;
	    		
	    }
    	
    }
//    public boolean countLast(TreeNode root,int level){
//    	if(root.right!=null)
//    		if(countLast(root.right,level+1))
//    			return true;
//    		else{
//    			if(root.left!=null){
//    				countLast(root.left,level+1);
//    			}
//    		}
//    	else
//    		if(level==levelleft)
//    			return true;
//    	return false;
//    }
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(1);
		node.right=new TreeNode(1);
		node.left.left=new TreeNode(1);
		num222 sol=new num222();
		System.out.println((2<<1)-1);
	}

}


//Stack<TreeNode> st=new Stack<TreeNode>();
//st.add(root);
//int level=1;
//while(!st.isEmpty()){
//	Stack<TreeNode> tem=new Stack<TreeNode>();
//	while(!st.isEmpty()){
//		TreeNode each=st.pop();
//		if(each.left!=null)
//			tem.add(each.left);
//		if(each.right!=null)
//			tem.add(each.right);
//	}
//	st=tem;
//	if(level==levelright)
//		return st.size()+ (int)Math.pow(2, levelright)-1;
//	level++;
//	
//}
//return 0;