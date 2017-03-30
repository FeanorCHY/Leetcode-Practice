package leedcode;

public class num297 {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(1);
		root.left.right=new TreeNode(5);
		root.right=new TreeNode(2);
		CodecT sol=new CodecT();
		System.out.println(sol.serialize(root));
		sol.deserialize(sol.serialize(null));
	}

}
