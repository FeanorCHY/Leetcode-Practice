import java.util.Stack;

public class num394 {
    //leading zero? lower case only?
    public String decodeString(String s) {
        if(s==null||s.length()==0)
            return "";
        char[] arr=s.toCharArray();
        Stack<Integer> sti=new Stack<Integer>();
        Stack<StringBuilder> sts=new Stack<StringBuilder>();
        sts.push(new StringBuilder());
        int num=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='['){
                sti.push(num);
                num=0;
                sts.push(new StringBuilder());
            }
            else if(arr[i]==']'){
                int tem=sti.pop();
                String str=sts.pop().toString();
                for(int k=0;k<tem;k++)
                    sts.peek().append(str);
            }
            else if(arr[i]>='0'&&arr[i]<='9'){
                num=num*10+arr[i]-'0';
            }
            else{
                sts.peek().append(arr[i]);
            }
        }
        return sts.peek().toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
