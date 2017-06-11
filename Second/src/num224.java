import java.util.Stack;

public class num224 {
    //recursive
// 	int i=0;
// 	public int calculate(String s) {
//         if(s==null||s.length()==0)
//             return 0;
//         char[] arr=s.toCharArray();
//         int minus=1;
//         int num=0,res=0;
//         for(;i<arr.length;i++){
//             if(arr[i]==' ')
//                 continue;
//             else if(arr[i]=='-'){
//                 res+=minus*num;
//                 num=0;
//                 minus=-1;
//             }
//             else if(arr[i]=='+'){
//                 res+=minus*num;
//                 num=0;
//                 minus=1;
//             }
//             else if(arr[i]=='('){
//             	i++;
//                 num=calculate(s);
//             }
//             else if(arr[i]==')'){
//                 res+=minus*num;
//                 num=0;
//                 minus=1;
//                 return res;
//             }
//             else{
//                 num=num*10+arr[i]-'0';
//             }
//         }
//         res+=minus*num;
//         num=0;
//         minus=1;
//         return res;
        
//     }
    
    //iterative
	public int calculate(String s) {
        if(s==null||s.length()==0)
            return 0;
        char[] arr=s.toCharArray();
        int minus=1;
        Stack<Integer> r=new Stack<Integer>();
        Stack<Integer> m=new Stack<Integer>();
        int num=0,res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==' ')
                continue;
            else if(arr[i]=='-'){
                res+=minus*num;
                num=0;
                minus=-1;
            }
            else if(arr[i]=='+'){
                res+=minus*num;
                num=0;
                minus=1;
            }
            else if(arr[i]=='('){
                m.push(minus);
                minus=1;
                r.push(res);
                res=0;
            }
            else if(arr[i]==')'){
                res+=minus*num;
                num=res;
                res=r.pop();
                minus=m.pop();
            }
            else{
                num=num*10+arr[i]-'0';
            }
        }
        res+=minus*num;
        num=0;
        minus=1;
        return res;
        
    }
	public static void main(String[] args) {
		String test="(1+(4+5+2)-3)+(6+8)";
		num224 sol=new num224();
		System.out.println(sol.calculate(test));
	}

}
