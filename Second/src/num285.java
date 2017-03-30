
public class num285 {

    // TreeNode res=null;
    // TreeNode p;
    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    //     this.p=p;
    //     if(root==null||p==null)
    //         return null;
    //     search(root);
    //     return res;
    // }
    // private int search(TreeNode root){
    //     if(root==p){
    //         if(root.right!=null){
    //             TreeNode node=root.right;
    //             while(node.left!=null)
    //                 node=node.left;
    //             res=node;
    //             return 5;
    //         }
    //         else
    //             return 1;
    //     }
    //     if(root.left!=null){
    //         int left=search(root.left);
    //         if(left==1){
    //             res=root;
    //             return 5;
    //         }
                
    //     }
    //     if(root.right!=null){
    //         int right=search(root.right);
    //         if(right==1)
    //             return 1;
    //     }
    //     return 5;
    // }
    
    
    
    //iterative
    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    //     if(root==null||p==null)
    //         return null;
    //     Stack<TreeNode> st=new Stack<TreeNode>();
    //     while(root!=null){
    //         st.push(root);
    //         root=root.left;
    //     }
    //     while(!st.isEmpty()){
    //         TreeNode node=st.pop();
    //         TreeNode right=node.right;
    //         while(right!=null){
    //             st.push(right);
    //             right=right.left;
    //         }
    //         if(node==p){
    //             if(!st.isEmpty())
    //                 return st.peek();
    //         }
    //     }
    //     return null;
    // }
    
    
    //Binary Search
    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    //     if(root==null||p==null)
    //         return null;
    //     Stack<TreeNode> st=new Stack<TreeNode>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         TreeNode node=st.pop();
    //         if(p.val>node.val){
    //             if(node.right!=null)
    //                 st.push(node.right);
    //             else
    //                 return null;
    //         }
    //         else if(p.val<node.val){
    //             st.push(node);
    //             if(node.left!=null)
    //                 st.push(node.left);
    //             else
    //                 return null;
    //         }
    //         else{
    //             node=node.right;
    //             while(node!=null){
    //                 st.push(node);
    //                 node=node.left;
    //             }
    //             if(!st.isEmpty())
    //                 return st.peek();
    //         }
    //     }
    //     return null;
    // }
    
    
    //recursive
    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    //     if(root==null||p==null)
    //         return null;
    //     if(p.val>=root.val)
    //         return inorderSuccessor(root.right,p);
    //     else{
    //         TreeNode left=inorderSuccessor(root.left,p);
    //         if(left==null)
    //             return root;
    //         else 
    //             return left;
    //     }
    // }
    
    
    //concise iterative without stack
    
    //recursive
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null||p==null)
            return null;
        TreeNode suc=null;
        while(root!=null){
            if(p.val<root.val){
                suc=root;
                root=root.left;
            }
            else
                root=root.right;
        }
        return suc;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
