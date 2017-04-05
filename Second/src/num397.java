
public class num397 {
    //O(N) TLE
    // public int integerReplacement(int n) {
    //     if(n<=3)
    //         return n-1;
    //     int[] dp=new int[n+1];
    //     for(int i=2;i<=n;i++){
    //         if(i%2==0){
    //             dp[i]=1+dp[i/2];
    //         }
    //         else{
    //             dp[i]=Math.min(dp[i-1],dp[(i+1)/2]+1)+1;
    //         }
    //     }
    //     return dp[n];
    // }
    
    // int[] mem=null;
    // public int integerReplacement(int n) {
    //     if(n<=3)
    //         return n-1;
    //     if(mem==null)
    //         mem=new int[n+2];
    //     if(mem[n]>0)
    //         return mem[n];
    //     int res=0;
    //     while(n%2==0){
    //         res++;
    //         n=n/2;
    //     }
    //     if(n>1)
    //         res+=1+Math.min(integerReplacement(n+1),integerReplacement(n-1));
    //     mem[n]=res;
    //     return mem[n];
    // }
    
    public int integerReplacement(int n) {
        if(n<=3)
            return n-1;
        int res=0;
        long x=n;//take care of integer overflow
        while(x>1){
            res++;
            if((x&1)==0)
                x=x/2;
            else{
                if((x&2)==0||x==3)
                    x=x-1;
                else
                    x=x+1;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		num397 sol=new num397();
		System.out.println(sol.integerReplacement(100000000));
	}

}
