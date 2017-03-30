
public class num222 {
    //using middle
    //O((LogN)^2)
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int left=0;
        int right=0;
        TreeNode node=root;
        while(node!=null){
            node=node.left;
            left++;
        }
        node=root.right;
        while(node!=null){
            node=node.left;
            right++;
        }
        if(right==left-1)
            return (1<<right)+search(false,right,root.right);
        else{
            return (1<<right)+search(true,left-1,root.left);
        }
    }
    private int search(boolean left,int pre,TreeNode root){
        if(root==null)
            return 0;
        int right=0;
        TreeNode node=root.right;
        while(node!=null){
            node=node.left;
            right++;
        }
        if(right==pre-1)
            return (1<<right)+search(false,right,root.right);
        else{
            return (1<<right)+search(true,pre-1,root.left);
        }
    }
    
    
    
    //O((LogN)^2)
    //left go and right go
    // public int countNodes(TreeNode root) {
    //     if(root==null)
    //         return 0;
    //     int left=0;
    //     int right=0;
    //     TreeNode node=root;
    //     while(node!=null){
    //         node=node.left;
    //         left++;
    //     }
    //     node=root;
    //     while(node!=null){
    //         node=node.right;
    //         right++;
    //     }
    //     if(right==left)
    //         return (1<<left)-1;
    //     else{
    //         return 1+search(true,left-1,root.left)+search(false,right-1,root.right);
    //     }
    // }
    // private int search(boolean left,int pre,TreeNode root){
    //     if(root==null)
    //         return 0;
    //     int count=0;
    //     TreeNode node=root;
    //     if(left){
    //         while(node!=null){
    //             node=node.right;
    //             count++;
    //         }
    //     }
    //     else{
    //         while(node!=null){
    //             node=node.left;
    //             count++;
    //         }
    //     }
    //     if(pre==count)
    //         return (1<<count)-1;
    //     else
    //         return 1+search(true,left?pre-1:count-1,root.left)+search(false,left?count-1:pre-1,root.right);
    // }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.left.left=new TreeNode(5);
		root.left.left.right=new TreeNode(9);
		root.left.right=new TreeNode(6);
		root.left.right.left=new TreeNode(10);
		root.left.right.right=new TreeNode(11);
		root.right.left=new TreeNode(7);
		root.right.left.left=new TreeNode(12);
		root.right.right=new TreeNode(8);
		num222 sol=new num222();
		System.out.println(sol.countNodes(root));
	}

}
