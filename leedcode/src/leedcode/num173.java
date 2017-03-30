package leedcode;

public class num173 {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(6);
		node.left=new TreeNode(2);
		node.right=new TreeNode(7);
		node.left.left=new TreeNode(1);
		node.left.right=new TreeNode(4);
		node.left.right.left=new TreeNode(3);
		node.left.right.right=new TreeNode(5);
		node.right.left=new TreeNode(8);
		node.right.left.right=new TreeNode(9);
		node.right.right=new TreeNode(10);
		BSTIterator bst=new BSTIterator(node);
		while(bst.hasNext()){
			System.out.print(bst.next()+"  ");
		}

	}

}
