import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class num113 {

    //iterative
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null)
            return res;
        Stack<TreeNode> st=new Stack<TreeNode>();
        int cur=0;
        LinkedList<Integer> list=new LinkedList<Integer>();
        while(root!=null){
            st.push(root);
            cur+=root.val;
            list.add(root.val);
            root=root.left;
        }
        // if(cur==sum)
        //     res.add(new LinkedList<Integer>(list));
        Stack<Integer> num=new Stack<Integer>();
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            // list.removeLast();
            // cur-=node.val;
            if(node==null){
                list.removeLast();
                cur-=num.pop();
            }
            else if(node.right!=null){
                st.push(null);
                num.push(node.val);
                node=node.right;
                while(node!=null){
                    st.push(node);
                    cur+=node.val;
                    list.add(node.val);
                    node=node.left;
                }
            }
            else{
                if(node.left==null&&cur==sum)
                    res.add(new LinkedList<Integer>(list));
                list.removeLast();
                cur-=node.val;
            }
        }
        return res;
    }
    
    
    
    //recursive with top down
    // List<List<Integer>> res=new LinkedList<List<Integer>>();
    // int sum;
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //     if(root==null)
    //         return res;
    //     this.sum=sum;
    //     search(new ArrayList<Integer>(),0,root);
    //     return res;
    // }
    // private void search(List<Integer> list,int pre,TreeNode root){
    //     list.add(root.val);
    //     if(root.right==null&&root.left==null){
    //         if(pre+root.val==sum){
    //             res.add(new ArrayList<Integer>(list));
    //         }
    //         list.remove(list.size()-1);
    //         return;
    //     }
    //     if(root.left!=null){
    //         search(list,pre+root.val,root.left);
    //     }
    //     if(root.right!=null){
    //         search(list,pre+root.val,root.right);
    //     }
    //     list.remove(list.size()-1);
    // }
    
    
    //recursive with bottom up
    // int sum;
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //     if(root==null)
    //         return new LinkedList<List<Integer>>();
    //     this.sum=sum;
    //     return search(0,root);
    // }
    // private List<List<Integer>> search(int pre,TreeNode root){
    //     List<List<Integer>> res=new LinkedList<List<Integer>>();
    //     if(root.right==null&&root.left==null){
    //         if(pre+root.val==sum){
    //             List<Integer> tem=new LinkedList<Integer>();
    //             tem.add(root.val);
    //             res.add(tem);
    //         }
    //         return res;
    //     }
    //     if(root.left!=null){
    //         res.addAll(search(pre+root.val,root.left));
    //     }
    //     if(root.right!=null){
    //         res.addAll(search(pre+root.val,root.right));
    //     }
    //     for(List<Integer> list :res)
    //         list.add(0,root.val);
    //     return res;
    // }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(-2);
		root.right=new TreeNode(3);
		num113 sol=new num113();
		System.out.println(sol.pathSum(root, -1));
	}

}
