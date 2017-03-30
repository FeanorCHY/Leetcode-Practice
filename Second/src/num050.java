
public class num050 {

    // will it over Double limit? O(logn)
    //negative input!!!
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n==-1)
            return 1/x;
        double t=myPow(x,n/2);
        if(n%2==0)
            return t*t;
        else
            return t*t*(n<0?1/x:x);
    }
	public static void main(String[] args) {
		System.out.println(-3/2);
	}

}
