import java.util.Stack;

public class num227 {
    //iterative with stack
	//Space: O(N)
    public int calculate(String s) {
        if(s==null||s.length()==0)
            return 0;
        long num=0,part=0,res=0;;
        char[] arr=s.toCharArray();
        int idx=0;
        Stack<Long> st = new Stack<Long>();
        while(idx<arr.length&&arr[idx]==' ')
            idx++;
        if(idx==arr.length)
            return 0;
        char sign='+';
        if(arr[idx]=='-'){
            sign='-';
            idx++;
        }
        for(;idx<arr.length;idx++){
            if(arr[idx]>='0'&&arr[idx]<='9')
                num=num*10+arr[idx]-'0';
            else if(arr[idx]!=' '){
                cal(st,sign,num);
                num=0;
                sign=arr[idx];
            }
        }
        // System.out.println(sign);
        cal(st,sign,num);
        for(long each:st){
            res+=each;
        }
        return (int)res;
    }
    private void cal(Stack<Long> st,char sign,long num){
        switch(sign){
            case '+':{
                st.push(num);
                break;
            }
            case '-':{
                st.push(-num);
                break;
            }
            case '*':{
                st.push(st.pop()*num);
                break;
            }
            case '/':{
                st.push(st.pop()/num);
                break;
            }
        }
    }
    
    
    //iterative with stack
    // public int calculate(String s) {
    //     if(s==null||s.length()==0)
    //         return 0;
    //     long num=0,part=0,res=0;;
    //     char[] arr=s.toCharArray();
    //     int idx=0;
    //     while(idx<arr.length&&arr[idx]==' ')
    //         idx++;
    //     if(idx==arr.length)
    //         return 0;
    //     int sign=1;
    //     int sign2=-1;
    //     if(arr[idx]=='-'){
    //         sign=2;
    //         idx++;
    //     }
    //     for(;idx<arr.length;idx++){
    //         switch(arr[idx]){
    //             case '+':{
    //                 if(sign2>0){
    //                     part=cal(sign2,part,num);
    //                 }
    //                 else
    //                     part=num;
    //                 num=0;
    //                 res=cal(sign,res,part);
    //                 part=0;
    //                 sign=1;
    //                 sign2=-1;
    //                 break;
    //             }
    //             case '-':{
    //                 if(sign2>0){
    //                     part=cal(sign2,part,num);
    //                 }
    //                 else
    //                     part=num;
    //                 res=cal(sign,res,part);
    //                 part=0;
    //                 num=0;
    //                 sign=2;
    //                 sign2=-1;
    //                 break;
    //             }
    //             case '*':{
    //                 if(sign2>0)
    //                     part=cal(sign2,part,num);
    //                 else
    //                     part=num;
    //                 num=0;
    //                 sign2=3;
    //                 break;
    //             }
    //             case '/':{
    //                 if(sign2>0)
    //                     part=cal(sign2,part,num);
    //                 else
    //                     part=num;
    //                 num=0;
    //                 sign2=4;
    //                 break;
    //             }
    //             case ' ':{
    //                 break;
    //             }
    //             default:{
    //                 num=num*10+arr[idx]-'0';
    //             }
    //         }
    //     }
    //     System.out.println(part);
    //     System.out.println(num);
    //     if(sign2>0){
    //         part=cal(sign2,part,num);
    //     }
    //     else
    //         part=num;
    //     res=cal(sign,res,part);
    //     return (int)res;
    // }
    // private long cal(int sign,long part,long num){
    //     switch(sign){
    //         case 1:{
    //             return part+num;
    //         }
    //         case 2:{
    //             return part-num;
    //         }
    //         case 3:{
    //             return part*num;
    //         }
    //         case 4:{
    //             return part/num;
    //         }
    //     }
    //     return part+num;
    // }
	public static void main(String[] args) {
		num227 sol=new num227();
		System.out.println(sol.calculate("1-1+1"));
	}

}
