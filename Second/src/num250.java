
public class num250 {

    //backtracking
    // int res=0;
    // public int countUnivalSubtrees(TreeNode root) {
    //     if(root==null)
    //         return 0;
    //     search(root);
    //     return res;
    // }
    // private int search(TreeNode node){
    //     int left=0;
    //     int right=0;
    //     if(node.left!=null)
    //         left=search(node.left);
    //     if(node.right!=null)
    //         right=search(node.right);
    //     if(left>0&&right>0){
    //         if(node.val==node.left.val&&node.val==node.right.val){
    //             res++;
    //             return 1;
    //         }
    //         else
    //             return -1;
    //     }
    //     else if(left<0||right<0){
    //         return -1;
    //     }
    //     else if(left==0&&right==0){
    //         res++;
    //         return 1;
    //     }
    //     else if(left>0){
    //         if(node.val==node.left.val){
    //             res++;
    //             return 1;
    //         }
    //         else 
    //             return -1;
    //     }
    //     else{
    //         if(node.val==node.right.val){
    //             res++;
    //             return 1;
    //         }
    //         else
    //             return -1;
    //     }
    // }
    
    
    
    
    //concise one
    int res=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null)
            return 0;
        search(root,0);
        return res;
    }
    private boolean search(TreeNode node,int val){
        if(node==null)
            return true;
        if(!search(node.left,node.val)|!search(node.right,node.val))
            return false;
        res++;
        return node.val==val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
