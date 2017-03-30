package leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(root==null)
    		return res;
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		List<Integer> list=new ArrayList<Integer>();
    		Queue<TreeNode> tem=new LinkedList<TreeNode>();
    		while(!q.isEmpty()){
    			TreeNode node=q.poll();
    			list.add(node.val);
    			if(node.left!=null)
    				tem.add(node.left);
    			if(node.right!=null)
    				tem.add(node.right);
    		}
    		q=tem;
    		res.add(list);
    	}
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
