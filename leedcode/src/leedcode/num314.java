package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class num314 {
	List<List<Integer>> listlist=new ArrayList<List<Integer>>();
	TreeMap<Integer,List<Integer>> hm=new TreeMap<Integer,List<Integer>>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
    	if(root==null)
    		return listlist;
    	List<Integer> list=new ArrayList<Integer>();
    	list.add(root.val);
    	hm.put(0,list);
    	Queue<TreeNode> st=new LinkedList<TreeNode>();
    	Queue<Integer> index=new LinkedList<Integer>();
    	st.add(root);
    	index.add(0);
    	while(!st.isEmpty()){
    		Queue<TreeNode> temST=new LinkedList<TreeNode>();
    		Queue<Integer> temIndex=new LinkedList<Integer>();//pair with TreeNode stack
    		while(!st.isEmpty()){
    			TreeNode node=st.poll();
    			int pos=index.poll();
    			if(node.left!=null){
    				temST.add(node.left);
    				temIndex.add(pos-1);
    		    	if(hm.containsKey(pos-1)){
    		    		hm.get(pos-1).add(node.left.val);
    		    	}
    		    	else{
    		        	List<Integer> tem=new ArrayList<Integer>();
    		        	tem.add(node.left.val);
    		        	hm.put(pos-1,tem);
    		    	}
    			}
    			if(node.right!=null){
    				temIndex.add(pos+1);
    				temST.add(node.right);
    		    	if(hm.containsKey(pos+1)){
    		    		hm.get(pos+1).add(node.right.val);
    		    	}
    		    	else{
    		        	List<Integer> tem=new ArrayList<Integer>();
    		        	tem.add(node.right.val);
    		        	hm.put(pos+1,tem);
    		    	}
    			}
    		}
    		index=temIndex;
    		st=temST;
    	}
    	listlist=new ArrayList<List<Integer>>(hm.values());
        return listlist;
    }
    public void build(TreeNode root,int index){
    	if(root==null)
    		return;
    	if(hm.containsKey(index)){
    		hm.get(index).add(root.val);
    	}
    	else{
        	List<Integer> list=new ArrayList<Integer>();
        	list.add(root.val);
        	hm.put(index,list);
    	}
    	build(root.left,index-1);
    	build(root.right,index+1);
    }
	public static void main(String[] args) {
		TreeNode node=new TreeNode(3);
		node.left=new TreeNode(9);
		node.right=new TreeNode(8);
		node.left.left=new TreeNode(4);
		node.left.right=new TreeNode(0);
		node.right.left=new TreeNode(1);
		node.right.right=new TreeNode(7);
		num314 sol=new num314();
		System.out.println(sol.verticalOrder(node));
	}

}
