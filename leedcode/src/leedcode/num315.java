package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class BTreeNode{
	BTreeNode left;
	BTreeNode right;
	int leftN;
	int rightN;
	int val;
	public BTreeNode(int val){
		this.val=val;
		left=null;
		right=null;
		leftN=0;
		rightN=0;
	}
}
public class num315 {
	
	private int addNode(BTreeNode root,BTreeNode node,int count){
		if(node.val>=root.val){
			count=root.leftN+(node.val==root.val?0:1)+count;
			root.rightN=root.rightN+1;
			if(root.right==null){
				root.right=node;
				return count;
			}
			else{
				return addNode(root.right,node,count);
			}
		}
		else{
			root.leftN=root.leftN+1;
			if(root.left==null){
				root.left=node;
				return count;
			}
			else{
				return addNode(root.left,node,count);
			}
		}
	}
    public List<Integer> countSmaller(int[] nums) {
    	List<Integer> res=new ArrayList<Integer>();
    	BTreeNode root=null;
    	for(int i=nums.length-1;i>=0;i--){
    		BTreeNode node=new BTreeNode(nums[i]);
    		if(root==null){
    			root=node;
    			res.add(0);
    		}
			else
				res.add(addNode(root,node,0));
    	}
    	Collections.reverse(res);
        return res;
    }
	public static void main(String[] args) {
		int[] test={5,2,6,1};
		num315 sol=new num315();
		System.out.println(sol.countSmaller(test));
	}

}
