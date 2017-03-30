package leedcode;

import java.util.LinkedList;
import java.util.Queue;

public class num116 {

    public void connect(TreeLinkNode root) {
    	if(root==null)
    		return;
    	LinkedList<TreeLinkNode> q=new LinkedList<TreeLinkNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		TreeLinkNode last=null;
    		LinkedList<TreeLinkNode> tem=new LinkedList<TreeLinkNode>();
    		for(TreeLinkNode node:q){
    			if(node.left!=null)
    				tem.add(node.left);
    			if(node.right!=null)
    				tem.add(node.right);
    			if(last!=null)
    				last.next=node;
				last=node;
    		}
    		last.next=null;
    		q=tem;
    	}
    }
	public static void main(String[] args) {
	}

}
