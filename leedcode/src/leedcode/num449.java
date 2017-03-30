package leedcode;

public class num449 {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(2);
//		root.left=new TreeNode(1);
//		root.right=new TreeNode(3);
		Codec449 sol=new Codec449();
		sol.deserialize(sol.serialize(root));
	}

}
