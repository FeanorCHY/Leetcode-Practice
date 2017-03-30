package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num113 {
	int target;
	List<List<Integer>> listlist=new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	target=sum;
    	if(root==null)
    		return listlist;
    	traverse(root,0,new ArrayList<Integer>());
        return listlist;
    }
    public void traverse(TreeNode root,int sum,List<Integer> list){
    	sum=sum+root.val;
    	list.add(root.val);
    	if(root.left!=null){
//    		if(sum<target)
    			traverse(root.left,sum,list);
    	}
    	if(root.right!=null){
//    		if(sum<target)
    			traverse(root.right,sum,list);
    	}
    	if(root.right==null&&root.left==null){
    		if(sum==target)
    			listlist.add(new ArrayList<Integer>(list));
    	}
    	list.remove(list.size()-1);
    }
	public static void main(String[] args) {
		num113 sol=new num113();
		TreeNode node=new TreeNode(-1);
//		node.left=new TreeNode(2);
		node.right=new TreeNode(-3);
		System.out.println(sol.pathSum(node, -4));
	}

}
