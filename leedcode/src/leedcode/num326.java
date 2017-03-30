package leedcode;

public class num326 {
    public boolean isPowerOfThree(int n) {
    	if(n%2==0||n<0)
    		return false;
    	while(n>1){
    		if(n%3!=0)
    			return false;
    		n=n/3;
    	}
    	
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
