import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class num314 {
    //PreOrder traversal failled!!!
    // List<List<Integer>> res=new ArrayList<List<Integer>>();
    // TreeMap<Integer,List<Integer>> map=new TreeMap<Integer,List<Integer>>();
    // public List<List<Integer>> verticalOrder(TreeNode root) {
    //     if(root==null)
    //         return res;
    //     map.put(0,new ArrayList<Integer>());
    //     search(0,root);
    //     for(List<Integer> list:map.values())
    //         res.add(list);
    //     return res;
    // }
    // private void search(int col,TreeNode node){
    //     if(!map.containsKey(col))
    //         map.put(col,new ArrayList<Integer>());
    //     map.get(col).add(node.val);
    //     if(node.left!=null)
    //         search(col-1,node.left);
    //     if(node.right!=null)
    //         search(col+1,node.right);
    // }
    
    
    //leval traversal Space O(L)
    // class FakeNode{
    //     TreeNode node;
    //     int col;
    //     FakeNode(TreeNode node,int col){
    //         this.col=col;
    //         this.node=node;
    //     }
    // }
    // public List<List<Integer>> verticalOrder(TreeNode root) {
    //     List<List<Integer>> res=new ArrayList<List<Integer>>();
    //     if(root==null)
    //         return res;
    //     Queue<FakeNode> q=new LinkedList<FakeNode>();
    //     TreeMap<Integer,List<Integer>> map=new TreeMap<Integer,List<Integer>>();
    //     q.add(new FakeNode(root,0));
    //     while(!q.isEmpty()){
    //         int size=q.size();
    //         for(int i=0;i<size;i++){
    //             FakeNode node=q.poll();
    //             if(!map.containsKey(node.col))
    //                 map.put(node.col,new ArrayList<Integer>());
    //             map.get(node.col).add(node.node.val);
    //             if(node.node.left!=null)
    //                 q.add(new FakeNode(node.node.left,node.col-1));
    //             if(node.node.right!=null)
    //                 q.add(new FakeNode(node.node.right,node.col+1));
    //         }
    //     }
    //     for(List<Integer> list:map.values())
    //         res.add(list);
    //     return res;
    // }
    
    
    
    
    
    //leval traversal with precalculated range
    class FakeNode{
        TreeNode node;
        int col;
        FakeNode(TreeNode node,int col){
            this.col=col;
            this.node=node;
        }
    }
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<List<Integer>>();
        computeRange(root,0);
        int n=max-min+1;
        List<List<Integer>> res=new ArrayList<List<Integer>>(n);
        for(int i=0;i<n;i++)
            res.add(new ArrayList<Integer>());
        Queue<FakeNode> q=new LinkedList<FakeNode>();
        q.add(new FakeNode(root,-min));
        while(!q.isEmpty()){
            FakeNode node=q.poll();
            res.get(node.col).add(node.node.val);
            if(node.node.left!=null)
                q.add(new FakeNode(node.node.left,node.col-1));
            if(node.node.right!=null)
                q.add(new FakeNode(node.node.right,node.col+1));
        }
        return res;
    }
    private void computeRange(TreeNode root, int idx){
        if(root==null)
            return;
        max=Math.max(max,idx);
        min=Math.min(min,idx);
        computeRange(root.left,idx-1);
        computeRange(root.right,idx+1);
    }
	public static void main(String[] args) {
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		map.put(0, 1);
		map.put(-3, 3);
		map.put(512, 22);
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		System.out.println(res);

	}

}
