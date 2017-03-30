package leedcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num145 {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result=new LinkedList<Integer>();
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	Queue<Integer> index=new LinkedList<Integer>();
    	if(root==null)
    		return result;
    	result.add(root.val);
    	q.add(root);
    	index.add(0);
    	while(!q.isEmpty()){
    		Queue<TreeNode> tem=new LinkedList<TreeNode>();
    		int gap=0;
    		while(!q.isEmpty()){
    			int pos=index.poll();
    			TreeNode node=q.poll();
    			if(node.left!=null){
					tem.add(node.left);
					index.add(pos+gap);
					result.add(pos+gap++,node.left.val);	
    				if(node.right!=null){
    					tem.add(node.right);
    					index.add(pos+gap);
    					result.add(pos+gap++,node.right.val);
    				}
    			}
    			else{
    				if(node.right!=null){
    					tem.add(node.right);
    					index.add(pos+gap);
    					result.add(pos+gap++,node.right.val);	
    				}
    			}
    		}
    		q=tem;
    		
    	}
        return result;
    }
	public static void main(String[] args) {
		TreeNode node=new TreeNode(37);
		node.left=new TreeNode(-34);
		node.right=new TreeNode(-48);
		node.left.right=new TreeNode(-100);
		node.right.left=new TreeNode(-100);
		node.right.right=new TreeNode(48);
		node.right.right.left=new TreeNode(-54);
		node.right.right.left.left=new TreeNode(-71);
		node.right.right.left.right=new TreeNode(-22);
		node.right.right.left.right.right=new TreeNode(8);
		num145 sol=new num145();
		System.out.println(sol.postorderTraversal(node));
	}

}
