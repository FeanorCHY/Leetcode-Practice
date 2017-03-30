
public class num449 {

	public static void main(String[] args) {
		Codec sol=new Codec();
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(1);
		root.right=new TreeNode(3);
		sol.deserialize(sol.serialize(root));
	}

}
