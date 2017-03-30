import java.util.Stack;

public class num071 {

    //root ~? what for //? what for ..d? what for space?
    public String simplifyPath(String path) {
        if(path==null||path.length()==0)
            return "/";
        char[] arr=path.toCharArray();
        int idx=0;
        StringBuilder res=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        Stack<String> st=new Stack<String>();
        while(idx<arr.length){
            char c=arr[idx++];
            if(c=='/'){
                if(sb.length()!=0){
                    st.push(sb.toString());
                    sb=new StringBuilder();
                }
            }
            else if(c=='.'){
                if(sb.length()!=0){
                    sb.append('.');
                }
                else if(idx<arr.length){
                    if(arr[idx]=='.'){
                        idx++;
                        if(idx==arr.length||arr[idx]=='/'){
                            if(!st.isEmpty())
                                st.pop();
                        }
                        else{
                            sb.append("..");
                            while(idx<arr.length&&arr[idx]!='/')
                                sb.append(arr[idx++]);
                        }
                    }
                    else if(arr[idx]=='/')
                        idx++;
                    else
                        sb.append('.');
                }
            }
            else
                sb.append(c);
        }
        if(sb.length()!=0){
            st.push(sb.toString());
        }
        while(!st.isEmpty()){
            res.insert(0,"/"+st.pop());
        }
        if(res.length()==0)
            return "/";
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
