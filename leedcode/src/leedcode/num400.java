package leedcode;

public class num400 {
    public int findNthDigit(int n) {
    	long cur=9;
    	long dig=1;
    	long sum=0;
    	while(sum+cur*dig<n){
    		sum+=cur*dig;
    		dig++;
    		cur*=10;
    	}
    	int num=(int)(cur/9+(n-sum-1)/dig);
    	int which=(int)((n-sum-1)%dig);
    	return (num/(int)Math.pow(10, dig-which-1))%10;
    }
	public static void main(String[] args) {
		num400 sol=new num400();
		System.out.println(sol.findNthDigit(1000000000));
	}

}
