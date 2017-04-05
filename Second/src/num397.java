
public class num397 {

    public int integerReplacement(int n) {
        if(n<=3)
            return n-1;
        int res=0;
        while(n>1){
            res++;
            if((n&1)==0)
                n=n/2;
            else{
                if((n&2)==0||n==3)
                    n=n-1;
                else
                    n=n+1;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		num397 sol=new num397();
		System.out.println(sol.integerReplacement(100000000));
	}

}
