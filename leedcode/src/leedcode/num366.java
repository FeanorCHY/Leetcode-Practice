package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num366 {
	List<List<Integer>> listlist=new ArrayList<List<Integer>>();
    public List<List<Integer>> findLeaves(TreeNode root) {
    	
    	if(root==null)
    		return listlist;
    	listlist.add(new ArrayList<Integer>());
    	int node=tryDelete(root);
		if(listlist.size()<node){
			List<Integer> list=new ArrayList<Integer>();
	    	list.add(root.val);
	    	listlist.add(list);
		}
		else{
			listlist.get(node-1).add(root.val);
		}
        return listlist;
    }
    public int tryDelete(TreeNode root){
    	int left=0;
    	int right=0;
    	if(root.left!=null){
    		if(root.left.left==null&&root.left.right==null){
    			listlist.get(0).add(root.left.val);
    			root.left=null;
    			left=1;
    		}
    		else{
    			left=tryDelete(root.left);
    			if(listlist.size()<left){
    				List<Integer> list=new ArrayList<Integer>();
    				list.add(root.left.val);
    				listlist.add(list);
    			}
    			else
    				listlist.get(left-1).add(root.left.val);
    			root.left=null;
    		}
    	}
    	if(root.right!=null){
    		if(root.right.left==null&&root.right.right==null){
    			listlist.get(0).add(root.right.val);
    			root.right=null;
    			right=1;
    		}
    		else{
    			right=tryDelete(root.right);
    			if(listlist.size()<right){
    				List<Integer> list=new ArrayList<Integer>();
    				list.add(root.right.val);
    				listlist.add(list);
    			}
    			else
    				listlist.get(right-1).add(root.right.val);
    			root.right=null;
    		}
    	}
		return Math.max(left, right)+1;
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.left.right.left=new TreeNode(8);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(6);
		root.right.left.right=new TreeNode(7);
		num366 sol=new num366();
		System.out.println(sol.findLeaves(root));
	}

}
