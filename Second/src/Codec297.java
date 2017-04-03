import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //BFS
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
//         if(data==null||data.length()==0||data.equals("#,"))
//             return null;
//         Queue<TreeNode> q=new LinkedList<TreeNode>();
//         char[] arr=data.toCharArray();
//         int idx=0;
//         TreeNode root=null;
//         while(idx<arr.length){
//             if(arr[idx]=='#')
//                 idx+=2;
//             else{
//                 int[] get=move(arr,idx);
//                 TreeNode node=new TreeNode(get[0]);
//                 idx=get[1];
//                 q.add(node);
//                 if(root==null){
//                     root=node;
//                     continue;
//                 }
//                 q.peek().left=node;
//             }
//             if(arr[idx]=='#')
//                 idx+=2;
//             else{
//                 int[] get=move(arr,idx);
//                 TreeNode node=new TreeNode(get[0]);
//                 idx=get[1];
//                 q.add(node);
//                 q.peek().right=node;
//             }
//             q.poll();
//         }
//         return root;
//     }
//     private int[] move(char[] arr,int idx){
//         int sign=1;
//         int num=0;
//         if(arr[idx]=='-'){
//             sign=-1;
//             idx++;
//         }
//         while(arr[idx]!=','){
//             num=num*10+arr[idx++]-'0';
//         }
//         idx++;
//         return new int[]{num*sign,idx};
//     }
// }




 //inorder DFS
public class Codec297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "#";
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.add(root);
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            if(st.peek()==null)
                res.append('#');
            else
                res.append(st.peek().val);
            res.append(',');
            if(st.peek()!=null)
                st.push(st.peek().left);
            else{
                st.pop();
                if(!st.isEmpty())
                    st.push(st.pop().right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0||data.equals("#"))
            return null;
        Stack<TreeNode> st=new Stack<TreeNode>();
        char[] arr=data.toCharArray();
        int idx=0;
        TreeNode root=null;
        // System.out.println(data);
        while(idx<arr.length){
            if(arr[idx]=='#'){
                idx+=2;
                int[] get=move(arr,idx);
                while(idx<arr.length&&get==null){
                    idx+=2;
                    st.pop();
                    if(idx<arr.length)
                        get=move(arr,idx);
                }
                if(idx==arr.length)
                    break;
                TreeNode node=new TreeNode(get[0]);
                idx=get[1];
                st.pop().right=node;
                st.push(node);
            }
            else{
                int[] get=move(arr,idx);
                TreeNode node=new TreeNode(get[0]);
                idx=get[1];
                if(root==null)
                    root=node;
                else{
                    st.peek().left=node;
                }
                st.push(node);
            }
        }
        return root;
    }
    private int[] move(char[] arr,int idx){
        if(arr[idx]=='#')
            return null;
        int sign=1;
        int num=0;
        if(arr[idx]=='-'){
            sign=-1;
            idx++;
        }
        while(arr[idx]!=','){
            num=num*10+arr[idx++]-'0';
        }
        idx++;
        return new int[]{num*sign,idx};
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));