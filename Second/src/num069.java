
public class num069 {

    //Binary Search logx
    //what if x is negative?
    // public int mySqrt(int x) {
    //     if(x<=0)
    //         return 0;
    //     if(x==1)
    //         return 1;
    //     long l=1,r=x/2;
    //     while(l<=r){
    //         long mid=l+(r-l)/2;//take care if l+r> Integer limit!
    //         if(mid*mid>(long)x)
    //             r=mid-1;
    //         else if(mid*mid<(long)x)
    //             l=mid+1;
    //         else
    //             return (int)mid;
    //     }
    //     return (int)r;
    // }
    
    //newton
    // public int mySqrt(int x) {
    //     if(x<=0)
    //         return 0;
    //     if(x==1)
    //         return 1;
    //     long t=x;
    //     while(t*t>(long)x)
    //         t=(t+x/t)/2;
    //     return (int)t;
    // }
    
    
    //bit manipulation
    public int mySqrt(int x) {
        if(x<=0)
            return 0;
        if(x==1)
            return 1;
        long t=0;
        while((long)(1<<t)*(long)(1<<t)<=(long)x)//find the significant bit
            t++;
        t--;//the last significant position
        long res=0;
        while(t>=0){
            if((res|(1<<t))*(res|(1<<t))<=(long)x)//find if this position is one
                res|=(1<<t);
            t--;
        }
        return (int)res;
    }
	public static void main(String[] args) {
		num069 sol=new num069();
		sol.mySqrt(2147395599);
	}

}
