package leedcode;

public class num117 {    
	public static void connect(TreeLinkNode root) {
		if(root==null)
			return;
		TreeLinkNode rootNext=root.next;
		TreeLinkNode next=null;
		while(rootNext!=null&&next==null){
			if(rootNext.left!=null)
				next=rootNext.left;
			else
				next=rootNext.right;
			rootNext=rootNext.next;
		}
		if(root.right!=null){
			root.right.next=next;
			if(root.left!=null)
				root.left.next=root.right;
			connect(root.right);
		}
		else if(root.left!=null){
			root.left.next=next;
		}
		if(root.left!=null)
			connect(root.left);
			
    }
	public static void main(String[] args) {
		TreeLinkNode node=new TreeLinkNode(1);
		node.left=new TreeLinkNode(2);
		node.right=new TreeLinkNode(3);
		node.left.left=new TreeLinkNode(4);
		node.left.right=new TreeLinkNode(5);
		node.right.right=new TreeLinkNode(7);
		num117 sol=new num117();
		sol.connect(node);
		while(node!=null){
			TreeLinkNode left=node;
			while(left!=null){
				System.out.print(left.val+"-->");
				left=left.next;
			}
			System.out.println();
			node=node.left;
		}
	}

}
