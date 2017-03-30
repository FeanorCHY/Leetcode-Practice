package leedcode;

public class num105 {
	int[] pre;
	int[] in;
	int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	pre=preorder;
    	in=inorder;
    	if(in.length==0)
    		return null;
    	TreeNode root=new TreeNode(pre[index++]);
    	if(0<in.length-1){

        	for(int i=0;i<=in.length-1;i++){
        		if(in[i]==root.val){
        			TreeNode lNode;
        			TreeNode rNode;
        			if(0<=i-1){
        				lNode=new TreeNode(pre[index++]);
        				if(i-1>0)
        					build(0,i-1,lNode);
    				}
        			else
        				lNode=null;
        			if(i+1<=in.length-1){
        				rNode=new TreeNode(pre[index++]);
        				if(i+1<in.length-1)
        					build(i+1,in.length-1,rNode);
        			}
        			else
        				rNode=null;
        			root.left=lNode;
        			root.right=rNode;
        			break;
        		}
        	}
		}
        return root;
    }
    public void build(int left,int right,TreeNode root){
    	for(int i=left;i<=right;i++){
    		if(in[i]==root.val){
    			TreeNode lNode;
    			TreeNode rNode;
    			if(index!=in.length){
        			if(left<=i-1){
        				lNode=new TreeNode(pre[index++]);
        				if(left<i-1)
        					build(left,i-1,lNode);
    				}
        			else
        				lNode=null;
    			}
    			else
    				lNode=null;
    			if(index!=in.length){
        			if(i+1<=right){
	    				rNode=new TreeNode(pre[index++]);
	        			if(i+1<right)
	        				build(i+1,right,rNode);
        			}
        			else
        				rNode=null;
    			}
    			else
    				rNode=null;
    			root.left=lNode;
    			root.right=rNode;
    			break;
    		}
    		
    	}
    }
	public static void main(String[] args) {
		int[] test1={3,1,2,4};
		int[] test2={1,2,3,4};
		num105 sol=new num105();
		sol.buildTree(test1, test2);

	}

}
