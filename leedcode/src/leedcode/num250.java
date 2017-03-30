package leedcode;

public class num250 {
	int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        find(root);
    	return count;
    }
    public boolean find(TreeNode root){
    	if(root==null) return true;
    	if(find(root.left)&find(root.right)){
    		if(root.left!=null&&root.left.val!=root.val)
    			return false;
    		if(root.right!=null&&root.right.val!=root.val)
    			return false;
    		count++;
    		return true;
    		
    	}
    	return false;
    }
    
	public static void main(String[] args) {
//		[2,-89,-89,-1,-70,-70,-1,//null,84,null,-75,null,-75,84,null,57,67,81,null,null,81,67,57]
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(1);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(5);
		root.left.right=new TreeNode(5);
//		root.right.left=new TreeNode(-70);
		root.right.right=new TreeNode(5);
//		root.left.left.right=new TreeNode(84);
//		root.left.right.left=new TreeNode(-75);
//		root.right.left.left=new TreeNode(-75);
//		root.right.left.right=new TreeNode(84);
//		root.right.right.right=new TreeNode(57);
		num250 sol=new num250();
		System.out.println(sol.countUnivalSubtrees(root));//
	}

}

    
//	if(root==null)
//		return 0;
//	find(root);
//	return count;
//}
//public int find(TreeNode root){
//	if(root.right==null&&root.left==null){
//		count++;
//		System.out.println(root.val);
//		return root.val;
//	}
//	else{
//		int right=Integer.MIN_VALUE;
//		int left=0;
//		if(root.right!=null){
//			right=find(root.right);
//		}
//		if(root.left!=null){
//			left=find(root.left);
//			if(left==Integer.MIN_VALUE+1)
//				return Integer.MIN_VALUE+1;
//			if(right!=Integer.MIN_VALUE){
//				if(right==left&&right==root.val){
//					count++;
//		    		System.out.println(root.val);
//					return root.val;
//				}
//				else
//					return Integer.MIN_VALUE+1;
//			}
//			else{
//				if(left==root.val){
//					count++;
//		    		System.out.println(root.val);
//					return root.val;
//				}
//				else
//					return Integer.MIN_VALUE+1;
//			}
//		}
//		if(right!=Integer.MIN_VALUE&&right!=root.val)
//			return Integer.MIN_VALUE+1;
//		count++;
//		System.out.println(root.val);
//		return root.val;
//	}
//}