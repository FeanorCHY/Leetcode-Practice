
public class num298 {
    //DFS Bottom Up
    // int res=0;
    // public int longestConsecutive(TreeNode root) {
    //     search(root);
    //     return res;
    // }
    // private int search(TreeNode root){
    //     if(root==null)
    //         return 0;
    //     int left=search(root.left);
    //     int right=search(root.right);
    //     if(root.left==null||root.left.val==root.val+1)
    //         left++;
    //     else
    //     	left=1;
    //     if(root.right==null||root.right.val==root.val+1)
    //         right++;
    //     else
    //     	right=1;
    //     int val=Math.max(left,right);
    //     res=Math.max(val,res);
    //     return val;
    // }
    
    
    
    //Top down
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        search(root,0,0);
        return res;
    }
    private void search(TreeNode node,int dev,int count){
        if(node==null)
            return;
        if(dev==node.val)
            count++;
        else
            count=1;
        res=Math.max(count,res);
        search(node.left,node.val+1,count);
        search(node.right,node.val+1,count);
    }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(2);
		root.right.right=new TreeNode(4);
		root.right.right.right=new TreeNode(5);
		num298 sol=new num298();
		sol.longestConsecutive(root);
	}

}
