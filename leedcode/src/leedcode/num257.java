package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num257 {
	List<String> res=new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
    	StringBuilder sb=new StringBuilder();
    	if(root==null)
    		return res;
    	if(root.left==null&&root.right==null){
    		res.add(root.val+"");
    		return res;
    	}
    	find(sb,root);	
        return res;
    }
    private void find(StringBuilder sb,TreeNode root){
    	sb.append((sb.length()==0?"":"->")+root.val);
    	if(root.left==null&&root.right==null){
    		res.add(sb.toString());
    		return;
    	}
    	int len=sb.length();
    	if(root.left!=null){
    		find(sb,root.left);
    		sb.setLength(len);
    	}
    	if(root.right!=null){
    		find(sb,root.right);
    		sb.setLength(len);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
