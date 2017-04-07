import java.util.LinkedList;
import java.util.List;

public class num366 {

    //does the removal order matter?
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null)
            return res;
        search(res,root);
        return res;
    }
    private int search(List<List<Integer>> res,TreeNode node){
        if(node==null)
            return 0;
        int left=search(res,node.left);
        int right=search(res,node.right);
        int max=Math.max(left,right);
        if(res.size()==max)
            res.add(new LinkedList<Integer>());
        res.get(max).add(node.val);
        node.left=null;
        node.right=null;
        return max+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
