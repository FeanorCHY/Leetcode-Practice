import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class num103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null)
            return res;
        Stack<TreeNode> q=new Stack<TreeNode>();
        q.push(root);
        boolean left=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new LinkedList<Integer>();
            Stack<TreeNode> tem=new Stack<TreeNode>();
            while(!q.isEmpty()){
                TreeNode node=q.pop();
                list.add(node.val);
                if(left){
                    if(node.left!=null)
                        tem.push(node.left);
                    if(node.right!=null)
                        tem.push(node.right);
                }
                else{
                    if(node.right!=null)
                        tem.push(node.right);
                    if(node.left!=null)
                        tem.push(node.left);
                }
            }
            q=tem;
            left=!left;
            res.add(list);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
