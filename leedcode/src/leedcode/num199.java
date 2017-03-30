package leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num199 {
//	Stack<TreeNode> st =new Stack<TreeNode>();
	List<Integer> list=new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
    	if(root==null)
    		return list;
    	build(root,0);
    	return list;
    }
    public void build(TreeNode root,int layer){
    	if(list.size()==layer){
    		list.add(root.val);
    	}
    	if(root.right!=null){
//    		st.push(root);
    		build(root.right,layer+1);
    	}
    	if(root.left!=null){
    		build(root.left,layer+1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
