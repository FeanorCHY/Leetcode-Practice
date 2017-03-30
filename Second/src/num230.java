
public class num230 {

    //worse when the target is in the left
    //   public int kthSmallest(TreeNode root, int k) {
    //     int count = countNodes(root.left);
    //     if (k <= count) {
    //         return kthSmallest(root.left, k);
    //     } else if (k > count + 1) {
    //         return kthSmallest(root.right, k-1-count); // 1 is counted as current node
    //     }
        
    //     return root.val;
    // }
        
    // public int countNodes(TreeNode n) {
    //     if (n == null) return 0;
        
    //     return 1 + countNodes(n.left) + countNodes(n.right);
    // }
    
    
    
    
    //iterative
    // public int kthSmallest(TreeNode root, int k) {
    //     Stack<TreeNode> st=new Stack<TreeNode>();
    //     TreeNode node=root;
    //     while(node!=null){
    //         st.push(node);
    //         node=node.left;
    //     }
    //     while(k!=0){
    //         node=st.pop();
    //         k--;
    //         if(k==0)
    //             return node.val;
    //         node=node.right;
    //         while(node!=null){
    //             st.push(node);
    //             node=node.left;
    //         }
    //     }
    //     return -1;
    // }
    
    
    
    
    
    
    //O(N)
    boolean find=false;
    int num=0;
    public int kthSmallest(TreeNode root, int k) {
        int left=0;
        int right=0;
        if(root.left!=null)
            left=kthSmallest(root.left,k);
        if(left+1==k&&find==false){
            find=true;
            num=root.val;
            return root.val;
        }
        if(find)
            return num;
        if(root.right!=null)
            right=kthSmallest(root.right,k-left-1);
        if(find)
            return num;
        else
            return left+right+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
