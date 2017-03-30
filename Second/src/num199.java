import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num199 {

    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new LinkedList<Integer>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(i==0)
                    res.add(node.val);
                if(node.right!=null)
                    q.add(node.right);
                if(node.left!=null)
                    q.add(node.left);
            }
        }
        return res;
    }
    
    
    //DFS
    // List<Integer> res;
    // public List<Integer> rightSideView(TreeNode root) {
    //     res=new LinkedList<Integer>();
    //     if(root==null)
    //         return res;
    //     search(1,root);
    //     return res;
    // }
    // private void search(int level,TreeNode root){
    //     if(level>res.size())
    //         res.add(root.val);
    //     if(root.right!=null)
    //         search(level+1,root.right);
    //     if(root.left!=null)
    //         search(level+1,root.left);
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
