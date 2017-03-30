package leedcode;

public class num106 {

	int[] in;
	int[] post;
	int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	in=inorder;
    	post=postorder;
    	index=postorder.length-1;
    	TreeNode root=build(0,index);
        return root;
    }
    public TreeNode build(int iS,int iE){
//    	int pS=in.length-1-fake_pS;
//    	int pE=in.length-1-fake_pE;
    	if(iS>iE)
    		return null;
    	int rootV=post[index--];
    	TreeNode root=new TreeNode(rootV);
    	if(iS==iE)
    		return root;
    	int i=iS;
    	for(;i<=iE;i++){
    		if(in[i]==rootV)
    			break;
    	}
    	root.right=build(i+1,iE);
    	root.left=build(iS,i-1);
    	
    	
    	return root;
    }
    
    
	public static void main(String[] args) {
		int[] test1={1,2,3,4,5,6,7,8,9};
		int[] test2={1,3,5,4,2,8,9,7,6};
		num106 sol=new num106();
		sol.buildTree(test1, test2);
	}

}
