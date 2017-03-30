
public class num450 {

    //is the key unique? what if key does not exist? 
    // public TreeNode deleteNode(TreeNode root, int key) {
    //     if(root==null)
    //         return null;
    //     TreeNode find=root;
    //     TreeNode last=null;
    //     while(find!=null&&find.val!=key){
    //         last=find;
    //         if(key<find.val)
    //             find=find.left;
    //         else
    //             find=find.right;
    //     }
    //     if(find==null)
    //         return root;
    //     TreeNode rep=find.left!=null?find.left:find.right;
    //     TreeNode second=find.left!=null?find.right:find.left;
    //     find.left=null;
    //     find.right=null;
    //     if(second!=null){
    //         TreeNode right=rep;
    //         while(right.right!=null)
    //             right=right.right;
    //         right.right=second;
    //     }
    //     if(last!=null){
    //         if(last.left==find){
    //             last.left=rep;
    //         }
    //         else
    //             last.right=rep;
    //         return root;
    //     }
    //     else
    //         return rep;
    // }
    
    
    
    //recursive
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val>key)
            root.left=deleteNode(root.left,key);
        else if(root.val<key)
            root.right=deleteNode(root.right,key);
        else{
            if(root.right==null)
                return root.left;
            else if(root.left==null)
                return root.right;
            TreeNode right=root.right;
            TreeNode last=null;
            while(right.left!=null){
                last=right;
                right=right.left;
            }
            root.val=right.val;
            if(last==null){
                root.right=right.right;
            }
            else{
                last.left=right.right;
            }
        }
        
        return root;
    }
}
