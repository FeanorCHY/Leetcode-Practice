package leedcode;

public class num270 {
    public int closestValue(TreeNode root, double target) {
    	if(root.val==target)
    		return root.val;
    	else if(root.val<target){
    		if(root.right!=null){
    			int val=closestValue(root.right,target);
    			if(Math.abs((double)val-target)>Math.abs((double)root.val-target))
    				return root.val;
    			else
    				return val;
    		}
    		else
    			return root.val;
    	}
    	else{
    		if(root.left!=null){
        		int val=closestValue(root.left,target);
    			if(Math.abs((double)val-target)>Math.abs((double)root.val-target))
    				return root.val;
    			else
    				return val;
    		}
    		else
    			return root.val;
    	}
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		num270 sol=new num270();
		System.out.println(sol.closestValue(root, 3.4));
	}

}
