package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class num437 {
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	int sum;
	public int pathSum(TreeNode root, int sum) {
		map.put(0, 1);
		this.sum=sum;
		return find(root,0);
    }
	private int find(TreeNode root,int pre){
		if(root==null)
			return 0;
		pre=pre+root.val;
		int res=map.getOrDefault(pre-sum, 0);
		map.put(pre, map.getOrDefault(pre, 0)+1);
		res+=find(root.left,pre)+find(root.right,pre);
		map.put(pre, map.get(pre)-1);
		return res;
	}
	public static void main(String[] args) {
		CodecT code=new CodecT();
		num437 sol=new num437();
		System.out.println(sol.pathSum(code.deserialize("10, 5, -3, 3, 2, null, 11, 3, -2, null, 1"),  8));
	}

}





//int count=0;
//int sum;
//public int pathSum(TreeNode root, int sum) {
//	this.sum=sum;
//	if(root==null)
//		return 0;
//	Queue<Integer> q=new LinkedList<Integer>();
//	Queue<TreeNode> nq=new LinkedList<TreeNode>();
//	nq.add(root);
//	q.add(root.val);
//	while(!q.isEmpty()){
//    	Queue<Integer> temq=new LinkedList<Integer>();
//    	Queue<TreeNode> temnq=new LinkedList<TreeNode>();
//		while(!q.isEmpty()){
//			
//		}
//	}
//	
//	
//	find(root);
//	
//	return count;
//}
//private List<Integer> find(TreeNode root){
//	List<Integer> tem=new ArrayList<Integer>();
//	tem.add(root.val);
//	if(root.val==sum)
//		count++;
//	if(root.left!=null){
//		List<Integer> left=find(root.left);
//		for(int each:left){
//			tem.add(each+root.val);
//			if(each+root.val==sum)
//				count++;
//		}
//	}
//	if(root.right!=null){
//		List<Integer> right=find(root.right);
//		for(int each:right){
//			tem.add(each+root.val);
//			if(each+root.val==sum)
//				count++;
//		}
//	}
//	return tem;
//	
//}