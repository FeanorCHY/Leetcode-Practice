package leedcode;

public class num374 {
	private int guess(int num){
		return 0;
	}
    public int guessNumber(int n) {
    	long l=1,r=n;
    	while(l<=r){
    		int mid=(int)((l+r)/2);
//    		System.out.println(mid+" guess:"+guess(mid));
    		if(guess(mid)<0)
    			r=mid-1;
    		else if(guess(mid)>0)
    			l=mid+1;
    		else
    			return mid;
    	}
    	return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
