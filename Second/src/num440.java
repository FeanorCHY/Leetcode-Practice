
public class num440 {

    //talent
    // public int findKthNumber(int n, int k) {
    //     if(n<1)
    //         return -1;
    //     int pow=1,rem=0;
    //     for(int x=n/10;x>0;x/=10){
    //         pow*=10;
    //         rem+=pow;
    //     }
    //     return -count(n,1,k-1,pow,rem);
    // }
    // private int count(int n,int cur,int rest,int pow,int rem){
    //     if(cur>n)
    //         return 0;
    //     int tem=rest;
    //     int gap=rem;
    //     for(int i=cur;i<=cur+9;i++){
    //         if(rest--==0)
    //             return -i;
    //         if(i==n)
    //         	return tem-rest;
    //         if((i+1)*pow>n){
    //             int x=count(n,i*10,rest,pow/10,rem/10-1);
    //             if(x<0)
    //                 return x;
    //             gap=gap/10-1;
    //             pow/=10;
    //             rest-=x;
    //             rem=rem/10-1;
    //         }
    //         else if(rest-gap<0)
    //             return count(n,i*10,rest,pow/10,rem/10-1);
    //         else
    //             rest-=gap;
    //     }
    //     return tem-rest;
    // }
    
    //traditional
    public int findKthNumber(int n, int k) {
        if(n<1)
            return -1;
        k--;
        int cur=1;
        while(k>0){
            int tem=count(n,cur,cur+1);
            if(k-tem>=0){
                k-=tem;
                cur++;
            }
            else{
                k--;
                cur*=10;
            }
                
        }
        return cur;
    }
    private int count(long n,long n1,long n2){
        int step=0;
        while(n1<=n){
            step+=Math.min(n+1,n2)-n1;
            n1*=10;
            n2*=10;
        }
        return step;
    }
	public static void main(String[] args) {
		num440 sol=new num440();
		System.out.println(sol.findKthNumber(356, 356));
	}

}
