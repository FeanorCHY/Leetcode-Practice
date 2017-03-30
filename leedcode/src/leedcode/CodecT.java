package leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CodecT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root==null)
    		return "null";
    	List<Integer> list=new ArrayList<Integer>();
    	Queue<TreeNode> st=new LinkedList<TreeNode>();
//    	StringBuilder sb=new StringBuilder();
    	list.add(root.val);
    	st.add(root);
    	while(!st.isEmpty()){
    		TreeNode node=st.poll();
    		if(node.left!=null){
    			st.add(node.left);
    			list.add(node.left.val);
    		}
    		else
    			list.add(null);
    		if(node.right!=null){
    			st.add(node.right);
    			list.add(node.right.val);
    		}
    		else
    			list.add(null);
    		
    	}
    	String res=list.toString();
        return res.substring(1,res.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	TreeNode root=null;
    	String[] arr=data.split(", ");
    	if(data.equals("null"))
    		return root;
    	else
    		root=new TreeNode(Integer.parseInt(arr[0]));
    	
    	Queue<TreeNode> st=new LinkedList<TreeNode>();
    	st.add(root);
    	int index=1;
    	while(index<arr.length){
    		TreeNode node=st.poll();
    		String left=arr[index++];
    		String right=arr[index++];
    		if(left.equals("null"))
    			node.left=null;
    		else{
    			node.left=new TreeNode(Integer.parseInt(left));
    			st.add(node.left);
    		}
    		if(right.equals("null"))
    			node.right=null;
    		else{
    			node.right=new TreeNode(Integer.parseInt(right));
    			st.add(node.right);
    		}
    	}
    	
    	
    	return root;
    }
}
