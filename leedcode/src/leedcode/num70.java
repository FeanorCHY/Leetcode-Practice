package leedcode;

public class num70 {

    public int climbStairs(int n) {
    	if(n==1)
    		return 1;
    	else if(n==2)
    		return 2;

    	int last1=2;
    	int last2=1;
    	int cur=3;
    	n=n-2;
        while(n!=1){
        	last2=last1;
        	last1=cur;
        	cur=last1+last2;
        	n--;
        }
        return cur;
    }
	public static void main(String[] args) {
		num70 sol=new num70();
		System.out.println(sol.climbStairs(5));
	}

}
