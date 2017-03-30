package leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(root==null)
    		return res;
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		Queue<TreeNode> tem=new LinkedList<TreeNode>();
			List<Integer> list=new ArrayList<Integer>();
    		while(!q.isEmpty()){
    			TreeNode node=q.poll();
    			list.add(node.val);
    			if(node.left!=null)
    				tem.add(node.left);
    			if(node.right!=null)
    				tem.add(node.right);
    		}
    		res.add(0,list);
    		q=tem;
    	}
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
