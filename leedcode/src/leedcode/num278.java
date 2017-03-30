package leedcode;

public class num278 {
	boolean isBadVersion(int version){
		if(version>=1702766719)
			return true;
		else
			return false;
	}
    public int firstBadVersion(int n) {
    	long l=1;
    	long r=n;
    	while(l<=r){
    		long mid=(l+r)/2;
    		if(isBadVersion((int)mid))
    			r=mid-1;
    		else
    			l=mid+1;
    	}
    	return (int)l;
    }
	public static void main(String[] args) {
		num278 sol=new num278();
		System.out.println(sol.firstBadVersion(2126753390));
	}

}
