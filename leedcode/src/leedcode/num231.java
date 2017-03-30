package leedcode;

public class num231 {
    public boolean isPowerOfTwo(int n) {
    	int last=n&(-n);
    	if((last&n)!=n||last<=0)
    		return false;
    	
    	
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
