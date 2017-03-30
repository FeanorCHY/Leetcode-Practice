import java.util.Stack;

public class num106 {

    //iterative with Stack
    // public TreeNode buildTree(int[] in, int[] post) {
    //     if(in==null||post==null||in.length!=post.length||in.length==0)
    //         return null;
    //     int len=in.length;
    //     Stack<TreeNode> st=new Stack<TreeNode>();
    //     int idx1=len-1,idx2=len-1;
    //     TreeNode root=new TreeNode(post[idx2--]);
    //     st.push(root);
    //     TreeNode pre=null;
    //     while(idx1>=0||idx2>=0){
    //         if(!st.isEmpty()&&st.peek().val==in[idx1]){
    //             pre=st.pop();
    //             idx1--;
    //         }
    //         else if(pre!=null){
    //             TreeNode node=new TreeNode(post[idx2--]);
    //             pre.left=node;
    //             st.push(node);
    //             pre=null;
    //         }
    //         else{
    //             TreeNode node=new TreeNode(post[idx2--]);
    //             st.peek().right=node;
    //             st.push(node);
    //         }
    //     }
    //     return root;
    // }
    
    
    
    //backtracking
    int[] in;
    int[] post;
    int idx;
    public TreeNode buildTree(int[] in, int[] post) {
        if(in==null||post==null||in.length!=post.length||in.length==0)
            return null;
        this.in=in;
        this.post=post;
        idx=post.length-1;
        return build(0,post.length-1);
    }
    private TreeNode build(int start,int end){
        if(start>end)
            return null;
        int i=start;
        for(;i<=end;i++){
            if(post[idx]==in[i])
                break;
        }
        TreeNode root=new TreeNode(post[idx--]);
        root.right=build(i+1,end);
        root.left=build(start,i-1);
        return root;
    }
	public static void main(String[] args) {
//		int[] test1={4,2,5,1,9,6,8,3,11,10,7};
//		int[] test2={4,5,2,9,8,6,11,10,7,3,1};

		int[] test1={2,1};
		int[] test2={2,1};
		num106 sol=new num106();
		sol.buildTree(test1, test2);
	}

}
