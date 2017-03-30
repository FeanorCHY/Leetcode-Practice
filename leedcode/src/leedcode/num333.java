package leedcode;

public class num333 {
	int count=0;
	int max=-1;
    public int largestBSTSubtree(TreeNode root) {
    	if(root==null)//null input
    		return 0;
    	find(true,true,0,root);
        return max;
    }
    public int find(boolean head,boolean fromLeft,int last,TreeNode root){
    	if(root.right==null&&root.left==null){
    		count++;
    		max=Math.max(max,1);
    		return 1;
    	}
    	int cur=0;
    	int left=0;
    	int right=0;
    	boolean ok=true;//judge if itself ok? regarding of parents
    	if(root.left!=null){
			left=find(false,true,root.val,root.left);
			if(root.val<root.left.val){
				cur=-1;
				ok=false;
			}
			if(!head){
				if(!fromLeft&&root.left.val<last){//check valid comparing to grandparents
					cur=-1;
				}
			}
    	}
    	if(root.right!=null){
			right=find(false,false,root.val,root.right);
    		if(root.val>root.right.val){
    			cur=-1;
				ok=false;
    		}
			if(!head){
				if(fromLeft&&root.right.val>last){
					cur=-1;
				}
			}
    	}
    	if(left>max)
    		max=left;
    	if(right>max)
    		max=right;
    	if(ok&&left+right+1>max&&left!=-1&&right!=-1)
    		max=left+right+1;//itself
    	if(cur==-1||left==-1||right==-1)
    		return -1;//return cur might result in 0;
    	else{
    		return left+right+1;
    	}
    }
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
//		node.left=new TreeNode(5);
		node.right=new TreeNode(4);
//		node.left.left=new TreeNode(1);
//		node.left.right=new TreeNode(8);
		node.right.left=new TreeNode(3);
		node.right.left.left=new TreeNode(2);
		node.right.left.left.left=new TreeNode(5);
		num333 sol=new num333();
		System.out.println(sol.largestBSTSubtree(node));
	}

}
