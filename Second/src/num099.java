
public class num099 {

    TreeNode wrong1=null;
    TreeNode LNode=null,next=null;
    boolean suc=false;
    public void recoverTree(TreeNode root) {
        search(root);
        if(!suc)
            swap(wrong1,next);
    }
    private void search(TreeNode node){
        if(node==null)
            return;
        search(node.left);
        if(suc)
            return;
        if(LNode==null)
            LNode=node;
        else if(LNode.val>node.val){
            if(wrong1==null){
                wrong1=LNode;
                next=node;
            }
            else{
                swap(wrong1,node);
                suc=true;
            }
        }
        LNode=node;
        search(node.right);
    }
    private void swap(TreeNode node1,TreeNode node2){
        int tem=node1.val;
        node1.val=node2.val;
        node2.val=tem;
    } 
}
