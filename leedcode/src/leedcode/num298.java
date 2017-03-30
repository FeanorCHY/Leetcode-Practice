package leedcode;

public class num298 {
	int max=Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
    	if(root==null)
    		return 0;
    	tryGo(root,root.val-1,-1);
        return max;
    }
    public void tryGo(TreeNode root,int val,int seq){
    	if(seq==-1)
    		seq=1;
    	else{
//	    	if(desc){
//	    		if(root.val>val){
//	        		if(seq>max)
//	        			max=seq;
//	        		seq=2;
//	        		desc=false;
//	    		}
//	    	}
//	    	else{
	    		if(root.val!=val+1){
	        		if(seq-1>max)
	        			max=seq-1;
	        		seq=1;
//	        		desc=true;
	    		}
//	    	}
    	}
    	if(root.left!=null)
    		tryGo(root.left,root.val,seq+1);
    	if(root.right!=null)
    		tryGo(root.right,root.val,seq+1);
    	if(root.left==null&&root.right==null)
    	{
    		if(seq>max)
    			max=seq;
    	}
    }
    
    
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		node.right=new TreeNode(3);
		node.right.left=new TreeNode(2);
		node.right.right=new TreeNode(4);
		node.right.right.right=new TreeNode(5);
		num298 sol=new num298();
		System.out.println(sol.longestConsecutive(node));
	}

}
