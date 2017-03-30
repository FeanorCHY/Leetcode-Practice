
public class num481 {
    //if n is negative number?
    //try to be smart but failed
    // public int magicalString(int n) {
    //     if(n==0)
    //         return 0;
    //     else if(n<=3)
    //         return 1;
    //     else if(n==4)
    // 		return 2;
    //     else if(n==5)
    // 		return 3; 
    //     int total=5;
    //     int res=3;
    //     int idx=2;
    //     StringBuilder sb=new StringBuilder(n+5);
    //     sb.append("122");
    //     boolean one=false;
    //     while(total<n){
    //         if(sb.charAt(idx++)=='2'){
    //             if(total+2<=n||(total+1==n&&one))
    //                 res++;
    //             total+=2;
    //             sb.append("11");
    //         }
    //         else{
    //             total++;
    //             if(one){
    //                 res++;
    //             }
    //             sb.append("1");
    //             one=!one;
    //         }
    //         if(total>=n)
    //             break;
    //         if(sb.charAt(idx++)=='2'){
    //             if(one){
    //                 if(total+1==n)
    //                     res+=1;
    //                 else if(total+2==n)
    //                     res+=2;
    //             }
    //             else{
    //                 if(total+3==n)
    //                     res+=1;
    //                 else if(total+4<=n)
    //                     res+=2;
    //             }
    //             total+=4;
    //             sb.append("22");
    //         }
    //         else{
    //             if(one){
    //                 if(total+1==n){
    //                     res++;
    //                 }
    //                 else
    //                     res+=2;
    //             }
    //             total+=2;
    //             sb.append("2");
    //             one=!one;
    //         }
    //     }
    //     return res;
    // }
    
    
    //O(N)
    //if n is negative number?
    // public int magicalString(int n) {
    //     if(n==0)
    //         return 0;
    //     if(n<=3)
    //         return 1;
    //     int total=3;
    //     int res=1;
    //     int idx=2;
    //     StringBuilder sb=new StringBuilder(n+5);
    //     sb.append("122");
    //     boolean one=true;
    //     while(total<n){
    //         if(sb.charAt(idx++)=='2'){
    //             if(one){
    //                 if(total+1==n)
    //                     res+=1;
    //                 else
    //                     res+=2;
    //                 sb.append("11");
    //             }
    //             else
    //                 sb.append("22");
    //             total+=2;
    //         }
    //         else{
    //             if(one){
    //                 res+=1;
    //                 sb.append("1");
    //             }
    //             else
    //                 sb.append("2");
    //             total+=1;
    //         }
    //         one=!one;
    //     }
    //     return res;
    // }
    
    
    //using array
    public int magicalString(int n) {
        if(n==0)
            return 0;
        if(n<=3)
            return 1;
        int[] arr=new int[n+1];
        arr[0]=1;
        arr[1]=2;
        arr[2]=2;
        int tail=3,res=1,idx=2,cur=1;
        while(tail<n){
            for(int i=0;i<arr[idx];i++){
                arr[tail++]=cur;
                if(cur==1&&tail<=n) 
                    res++;
            }
            idx++;
            cur=3-cur;
        }
        return res;
    }
	public static void main(String[] args) {
		num481 sol=new num481();
		System.out.println(sol.magicalString(7));
	}

}
