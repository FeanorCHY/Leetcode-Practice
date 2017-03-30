import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null)
            return res;
        List<TreeNode> list=new LinkedList<TreeNode>();
        // List<Integer> x=new LinkedList<Integer>();
        list.add(root);
        // x.add(root.val);
        // res.add(x);
        while(list.size()!=0){
            List<TreeNode> tem=new LinkedList<TreeNode>();
            List<Integer> x=new LinkedList<Integer>();
            for(TreeNode each:list){
                x.add(each.val);
                if(each.left!=null){
                    tem.add(each.left);
                }
                if(each.right!=null){
                    tem.add(each.right);
                }
            }
            res.add(x);
            list=tem;
        }
        return res;
    }

	public static void main(String[] args) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
	}

}
