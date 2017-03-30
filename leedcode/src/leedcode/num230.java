package leedcode;

public class num230 {
	int count=0;
	int pos=0;
    public int kthSmallest(TreeNode root, int k) {
    	pos=k;
    	
    	if(root==null)
    		return 0;
    	return find(root);
    }
    public int find(TreeNode root){
    	if(root.left!=null){
    		int val=find(root.left);
        	if(count==pos){
        		return val;
        	}
    	}
    	count++;
    	if(count==pos){
    		return root.val;
    	}
    	if(root.right!=null){
    		int val=find(root.right);
	    	if(count==pos){
	    		return val;
	    	}
    	}
    	return 0;
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		num230 sol=new num230();
		System.out.println(sol.kthSmallest(root, 2));
	}

}
