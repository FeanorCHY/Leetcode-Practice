package leedcode;

public class num337 {
    public int rob(TreeNode root) {
    	if(root==null)
    		return 0;
    	return tryRob(root,false);
    }
    public int tryRob(TreeNode root,boolean last){
    	int left=0;
    	int right=0;
    	if(last==true){
    		if(root.left!=null){
    			left=tryRob(root.left,false);
    		}
    		if(root.right!=null){
    			right=tryRob(root.right,false);
    		}
    		return left+right;
    	}
    	else{
    		if(root.left!=null){
    			left=tryRob(root.left,true);
    		}
    		if(root.right!=null){
    			right=tryRob(root.right,true);
    		}
    		int buy=root.val+left+right;
    		if(root.left!=null){
    			left=tryRob(root.left,false);
    		}
    		if(root.right!=null){
    			right=tryRob(root.right,false);
    		}
    		int not=left+right;
    		return buy>not?buy:not;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
