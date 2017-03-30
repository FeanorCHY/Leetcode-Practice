import java.util.Stack;

public class num385 {

    public NestedInteger deserialize(String s) {
        NestedInteger root=null;
        int sign=1;
        if(s==null||s.length()==0)
            return root;
        Stack<NestedInteger> st=new Stack<NestedInteger>();
        char[] arr=s.toCharArray();
        int num=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='['){
                NestedInteger tem=new NestedInteger();
                if(root!=null){
                    root.add(tem);
                    st.push(root);
                }
                root=tem;
            }
            else if(arr[i]==','){
                if(arr[i-1]!=']'){
                    root.add(new NestedInteger(sign*num));
                    num=0;
                    sign=1;
                }
            }
            else if(arr[i]==']'){
                if(arr[i-1]!='['&&arr[i-1]!=']'){
                    root.add(new NestedInteger(sign*num));
                    num=0;
                    sign=1;
                }
                if(!st.isEmpty())
                    root=st.pop();
            }
            else if(arr[i]=='-'){
                sign=-1;
            }
            else{
                num=num*10+arr[i]-'0';
            }
        }
        if(root==null)
            return new NestedInteger(sign*num);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
