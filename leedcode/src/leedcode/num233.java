package leedcode;

public class num233 {

    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        int sum=0;
        int q=n;
        int x=1;
        while(q>0){
        	int left=q/10;
        	int rem=q%10;
        	if(rem>1)
        		sum+=(left+1)*x;
        	else if(rem==1)
        		sum+=left*x+n%x+1;
        	else
        		sum+=left*x;
        	x*=10;
        	q/=10;
        }
        
        return sum;
    }
	public static void main(String[] args) {
		num233 sol=new num233();
		System.out.println(sol.countDigitOne(2122));
	}

}
