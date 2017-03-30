package leedcode;

public class num450 {
	TreeNode god;
    public TreeNode deleteNode(TreeNode root, int key) {
    	god=root;
    	search(root,key);
    	return god;
    }
    TreeNode Alt=null;
    private boolean search(TreeNode root, int key){
    	if(root==null)
    		return false;
    	if(root.val==key){
    		if(root.left!=null)
    			findAlt(root.left,true);
    		else if(root.right!=null)
    			findAlt(root.right,false);
			if(Alt!=null){
				Alt.left=Alt==root.left?Alt.left:root.left;
				Alt.right=Alt==root.right?Alt.right:root.right;
			}
    		if(root==god){
    			god=Alt;
    		}
    		return true;
    	}
    	else if(root.val>key){
    		if(search(root.left,key)){
    			root.left=Alt;
    		}
    	}
    	else {
    		if(search(root.right,key)){
    			root.right=Alt;
    		}
    	}
    	return false;
    }
    private boolean findAlt(TreeNode root,boolean left){
    	if(left){
	    	if(root.right!=null){
	    		if(findAlt(root.right,left)){
	    			root.right=Alt.left;
	    		}
	    		return false;
	    	}
	    	else{
	    		Alt=root;
	    		return true;
	    	}
    	}
    	else{
	    	if(root.left!=null){
	    		if(findAlt(root.left,left)){
	    			root.left=Alt.right;
	    		}
	    		return false;
	    	}
	    	else{
	    		Alt=root;
	    		return true;
	    	}
    		
    	}
    }
	public static void main(String[] args) {
		String test="3,2,4,1,N,N,N";//"38,34,40,19,36,39,41,8,23,35,37,N,N,N,48,5,11,22,29,N,N,N,N,45,49,4,7,10,14,21,N,24,31,42,46,N,N,3,N,6,N,9,N,13,18,20,N,N,26,30,33,N,44,N,47,1,N,N,N,N,N,12,N,16,N,N,N,25,27,N,N,32,N,43,N,N,N,0,2,N,N,15,17,N,N,N,28";
		num450 sol=new num450();
		Codec449 cod=new Codec449();
		System.out.println(cod.serialize(sol.deleteNode(cod.deserialize(test), 3)));
	}

}
