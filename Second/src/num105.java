import java.util.Stack;

public class num105 {

    //iterative
    public TreeNode buildTree(int[] pre, int[] in) {
        if(pre==null||in==null||pre.length==0||pre.length!=in.length)
            return null;
        TreeNode root=new TreeNode(Integer.MAX_VALUE);
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        int i=0,j=0;
        TreeNode node=null;
        while(i<in.length){
            if(st.peek().val==in[j]){
                node=st.pop();
                j++;
            }
            else if(node!=null){
                TreeNode cur=new TreeNode(pre[i++]);
                st.push(cur);
                node.right=cur;
                node=null;
            }
            else{
                TreeNode cur=new TreeNode(pre[i++]);
                st.peek().left=cur;
                st.push(cur);
            }
        }
        return root.left; 
    }
    
    
    //what if invalid
    //recursive
    // int index=0;
    // int[] pre;
    // int[] in;
    // public TreeNode buildTree(int[] pre, int[] in) {
    //     if(pre==null||in==null||pre.length==0||pre.length!=in.length)
    //         return null;
    //     TreeNode root=new TreeNode(pre[index]);
    //     this.pre=pre;
    //     this.in=in;
    //     return construct(0,in.length-1);
    // }
    // public TreeNode construct(int start,int end){
    //     if(start>end)
    //         return null;
    //     TreeNode root=new TreeNode(pre[index]);
    //     int tem=start;
    //     for(;tem<=end;tem++){
    //         if(in[tem]==pre[index])
    //             break;
    //     }
    //     index++;
    //     root.left=construct(start,tem-1);
    //     root.right=construct(tem+1,end);
    //     return root;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
