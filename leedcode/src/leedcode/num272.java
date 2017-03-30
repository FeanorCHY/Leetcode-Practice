package leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class num272 {
	double target;
	Queue<Integer> q=new LinkedList<Integer>();
	Stack<Integer> st=new Stack<Integer>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
    	this.target=target;
    	List<Integer> res=new ArrayList<Integer>();
    	traverse(root);
    	for(int i=0;i<k;i++){
    		if(q.isEmpty()||st.isEmpty()){
    			res.add(st.isEmpty()?q.poll():st.pop());
    		}
    		else{
    			if(q.peek()-target<target-st.peek()){
    				res.add(q.poll());
    			}
    			else
    				res.add(st.pop());
    		}
    	}
        return res;
    }
    public void traverse(TreeNode root){
    	if(root.left!=null)
    		traverse(root.left);
    	if((double)root.val<target)
    		st.add(root.val);
    	else
    		q.add(root.val);
    	if(root.right!=null)
    		traverse(root.right);
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(8);
		root.left=new TreeNode(1);
		num272 sol=new num272();
		System.out.println(sol.closestKValues(root, 6.0, 1));
	}

}
