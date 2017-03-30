package leedcode;

public class num397 {
    public int integerReplacement(int n) {
    	long t=n;
    	int rep=0;
    	while(t>1){
    		if(t%2==0)
    			t=t>>1;
			else{
				if(t==3)
					return 2+rep;
//				int plus=lastone((long)n+1);
//				int minus=lastone((long)n-1);
				t=lastone(t+1)>lastone(t-1)?(t+1):(t-1);
			}
    		rep++;
    	}
    	
    	
        return rep;
    }
    public long lastone(long num){
    	return num&((~num)+1);
    }
	public static void main(String[] args) {
		num397 sol=new num397();
		System.out.println(sol.integerReplacement(Integer.MAX_VALUE));
	}

}
