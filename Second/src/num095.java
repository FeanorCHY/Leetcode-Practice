import java.util.LinkedList;
import java.util.List;

public class num095 {

    // List<TreeNode> res=new LinkedList<TreeNode>();
    // public List<TreeNode> generateTrees(int n) {
    //     if(n==0)
    //         return new LinkedList<TreeNode>();
    //     return build(1,n);
    // }
    // private List<TreeNode> build(int from,int to){
    //     List<TreeNode> res=new LinkedList<TreeNode>();
    //     if(from>to){
    //         res.add(null);
    //         return res;
    //     }
    //     for(int i=from;i<=to;i++){
    //         List<TreeNode> left=build(from,i-1);
    //         List<TreeNode> right=build(i+1,to);
    //         for(TreeNode l:left){
    //             for(TreeNode r:right){
    //                 TreeNode root=new TreeNode(i);
    //                 root.left=l;
    //                 root.right=r;
    //                 res.add(root);
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    
    
    //dynamic programming
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new LinkedList<TreeNode>();
        List<TreeNode> res[]=new List[n+1];
        res[0]=new LinkedList<TreeNode>();
        res[0].add(null);
        for(int i=1;i<=n;i++){
            res[i]=new LinkedList<TreeNode>();
            for(int j=1;j<=i;j++){
                for(TreeNode l:res[j-1]){
                    for(TreeNode r:res[i-j]){
                        TreeNode node=new TreeNode(j);
                        node.left=l;
                        node.right=clone(r,j);
                        res[i].add(node);
                    }
                }
            }
        }
        return res[n];
    }
    private TreeNode clone(TreeNode node,int offset){
        if(node==null)
            return null;
        TreeNode copy=new TreeNode(node.val+offset);
        copy.right=clone(node.right,offset);
        copy.left=clone(node.left,offset);
        return copy;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
