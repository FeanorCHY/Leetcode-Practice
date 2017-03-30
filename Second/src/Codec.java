import java.util.Stack;

//Leval traversal
// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         Queue<TreeNode> q=new LinkedList<TreeNode>();
//         q.add(root);
//         StringBuilder res=new StringBuilder();
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int i=0;i<size;i++){
//                 TreeNode node=q.poll();
//                 if(node==null) 
//                     res.append('#');
//                 else{
//                     res.append(node.val);
//                     q.add(node.left);
//                     q.add(node.right);
//                 }
//                 res.append(',');
//             }
//         }
//         return res.toString();
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         char[] arr=data.toCharArray();
//         int num=0;
//         TreeNode root=null;
//         boolean left=true;
//         Queue<TreeNode> q=new LinkedList<TreeNode>();
//         for(int i=0;i<arr.length;i++){
//             if(arr[i]==','){
//                 TreeNode node=new TreeNode(num);
//                 num=0;
//                 if(root==null)
//                     root=node;
//                 else{
//                     if(left)
//                         q.peek().left=node;
//                     else
//                         q.poll().right=node;
//                     left=!left;
//                 }
//                 q.add(node);
//             }
//             else if(arr[i]=='#'){
//                 if(root==null)
//                     return null;
//                 else{
//                     if(!left)
//                         q.poll();
//                     left=!left;
//                 }
//                 i++;
//             }
//             else
//                 num=num*10+arr[i]-'0';
//         }
//         return root;
//     }
// }


//DFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res=new StringBuilder();
        seri(root,res);
        return res.toString();
    }
    private void seri(TreeNode root,StringBuilder res){
        if(root==null){
            res.append('#').append(',');
            return;
        }
        else{
            res.append(root.val).append(',');
            seri(root.left,res);
            seri(root.right,res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        char[] arr=data.toCharArray();
        Stack<Integer> st=new Stack<Integer>();
        st.push(0);
        return dese(arr,st);
    }
    private TreeNode dese(char[] arr,Stack<Integer> idx){
        if(idx.peek()>=arr.length)
            return null;
        if(arr[idx.peek()]=='#'){
            idx.push(idx.pop()+2);
            return null;
        }
        int num=0;
        while(arr[idx.peek()]!=','){
            num=num*10+arr[idx.peek()]-'0';
            idx.push(idx.pop()+1);
        }
        TreeNode node=new TreeNode(num);
        idx.push(idx.pop()+1);
        node.left=dese(arr,idx);
        node.right=dese(arr,idx);
        return node;
    }
}