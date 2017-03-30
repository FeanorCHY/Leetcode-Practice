package leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num103 {
	List<List<Integer>> listlist = new ArrayList<List<Integer>>();
	boolean left=true;
	Stack<TreeNode> st=new Stack<TreeNode>();
	Stack<TreeNode> stal=new Stack<TreeNode>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	if(root==null)
    		return listlist;
    	st.add(root);
    	traverse();
    	return listlist;
    	
    	
    	
    	
    	
    	
    	
    }
    public void traverse(){
    	while(!st.isEmpty()){
	    	List<Integer> tem=new ArrayList<Integer>();
	    	boolean able=false;;
	    	if(left==true){
	    		while(!st.isEmpty()){
	    			TreeNode poped=st.pop();
	    			tem.add(poped.val);
	    			if(poped.left!=null){
	    				stal.push(poped.left);
	    				able=true;
	    			}
	    			if(poped.right!=null){
	    				stal.push(poped.right);
	    				able=true;
	    			}
	    		}
	    		left=false;
	    		Stack<TreeNode> temSt=st;
	    		st=stal;
	    		stal=temSt;
	    	}
	    	else{
	    		while(!st.isEmpty()){
	    			TreeNode poped=st.pop();
	    			tem.add(poped.val);
	    			if(poped.right!=null){
	    				stal.push(poped.right);
	    				able=true;
	    			}
	    			if(poped.left!=null){
	    				stal.push(poped.left);
	    				able=true;
	    			}
	    		}
	    		left=true;
	    		Stack<TreeNode> temSt=st;
	    		st=stal;
	    		stal=temSt;
	    		
	    	}
	    	listlist.add(tem);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
