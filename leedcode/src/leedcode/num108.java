package leedcode;

public class num108 {

	int arr[];
    public TreeNode sortedArrayToBST(int[] nums) {
    	TreeNode root=null;
    	arr=nums;
    	root=build(0,nums.length-1);
    	
    	return root;
	}
    public TreeNode build(int start,int end){
    	int mid=(start+end)/2;
    	if(start>end)
    		 return null;
    	TreeNode node=new TreeNode(arr[mid]);
    	if(start==end){
    		return node;
    	}
    	node.left=build(start,mid-1);
    	node.right=build(mid+1,end);
    	
    	
    	return node;
    }
	public static void main(String[] args) {
		num108 sol=new num108();
		int[] test={1,2,3,4,5};
		TreeNode node=sol.sortedArrayToBST(test);
		System.out.println(node.val);
	}

}
