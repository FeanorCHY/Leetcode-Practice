package leedcode;

import java.util.LinkedList;
import java.util.Queue;


public class Codec449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder sb=new StringBuilder();
    	if(root==null)
    		return "N,";
    	else{
    		sb.append(root.val+",");
    	}
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		TreeNode node=q.poll();
    		if(node.left!=null){
    			sb.append(node.left.val+",");
    			q.add(node.left);
    		}
    		else
    			sb.append("N,");
    		if(node.right!=null){
    			sb.append(node.right.val+",");
    			q.add(node.right);
    		}
    		else
    			sb.append("N,");
    	}
        return sb.substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	char[] arr=data.toCharArray();
    	int num=0;
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	int idx=0;
    	TreeNode root=null;
    	while(idx<arr.length){
    		while(idx<arr.length&&arr[idx]<='9'&&arr[idx]>='0'){
    			num=num*10+arr[idx++]-'0';
    		}
    		if(root==null){
    			root=idx<arr.length&&arr[idx]=='N'?null:new TreeNode(num);
    			idx=idx+(idx<arr.length&&arr[idx]=='N'?2:1);
    			q.add(root);
    		}
    		else{
    			TreeNode node=q.poll();
    			node.left=arr[idx]=='N'?null:new TreeNode(num);
    			idx=idx+(arr[idx]=='N'?2:1);
    			if(node.left!=null)
    				q.add(node.left);
    			num=0;
        		while(idx<arr.length&&arr[idx]<='9'&&arr[idx]>='0'){
        			num=num*10+arr[idx++]-'0';
        		}
    			node.right=idx!=arr.length&&arr[idx]=='N'?null:new TreeNode(num);
    			idx=idx+(idx!=arr.length&&arr[idx]=='N'?2:1);
    			if(node.right!=null)
    				q.add(node.right);
    		}
			num=0;
    	}
        return root;
    }
}
