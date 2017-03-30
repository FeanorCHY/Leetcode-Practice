package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num94 {
	List<Integer> list=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
    	if(root!=null){
        	if(root.left!=null)
        		inorderTraversal(root.left);
    		list.add(root.val);
        	if(root.right!=null)
        		inorderTraversal(root.right);
    	    
    	}
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
