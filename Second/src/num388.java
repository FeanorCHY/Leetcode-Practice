import java.util.Stack;

public class num388 {

    //is "/" added automatically? is the input valid/.txt/.txt? does directory name contain "/" or other sepcial char? will \t more than last dir? should we count space? four space into one \t?
    public int lengthLongestPath(String input) {
        Stack<Integer> st=new Stack<Integer>();
        char[] arr=input.toCharArray();
        int cur=0;
        int level=0;
        int max=0;
        int space=0;
        boolean dot=false;
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1&&arr[i]!='\n'&&arr[i]!='\t')
                cur++;
            if(arr[i]=='\n'||i==arr.length-1){
                level+=space/4;
                while(level<st.size()){
                    int file=cur-st.peek();
                    st.pop();
                    cur=(st.isEmpty()?0:st.peek())+file;
                }
                if(dot)
                    max=Math.max(max,cur+st.size()+space%4);
                dot=false;
                st.push(cur);
                level=0;
            }
            else if(arr[i]=='\t'){
                level++;
            }
            else if(arr[i]==' ')
                space++;
            else{
                if(cur>0){
                    cur+=space;
                    space=0;
                }
                cur++;
                if(arr[i]=='.')
                    dot=true;
                    
            }
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
