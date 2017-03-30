package leedcode;

import java.util.List;
import java.util.ArrayList;

public class num144 {

	List<Integer> list=new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
    	if(root==null)
    		return list;
    	list.add(root.val);
    	if(root.left!=null){
    		preorderTraversal(root.left);
    	}
    	if(root.right!=null)
    		preorderTraversal(root.right);
    	
    	return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
