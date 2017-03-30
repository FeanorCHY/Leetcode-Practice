package leedcode;

import java.util.LinkedList;

public class num101 {
    public boolean isSymmetric(TreeNode root) {
    	if(root==null)
    		return true;
    	LinkedList<TreeNode> list=new LinkedList<TreeNode>();
    	list.add(root.left);
    	list.add(root.right);
    	while(!list.isEmpty()){
    		LinkedList<TreeNode> tem=new LinkedList<TreeNode>();
    		while(!list.isEmpty()){
    			if(list.size()<2)
    				return false;
    			TreeNode first=list.removeFirst();
    			TreeNode last=list.removeLast();
    			if(first==null||last==null){
    				if(!(first==null&&last==null))
    					return false;
    			}
    			else if(first.val!=last.val)
    				return false;
    			if(first!=null){
    				tem.addFirst(first.right);
    				tem.addFirst(first.left);
    				tem.addLast(last.left);
    				tem.addLast(last.right);
    			}
    				
    		}
    		list=tem;
    	}
    	return true;
    }
	public static void main(String[] args) {
		CodecT code=new CodecT();
		num101 sol=new num101();
		System.out.println(sol.isSymmetric(code.deserialize("1, 2, 2, 3, 4, 4, 3")));
	}

}
