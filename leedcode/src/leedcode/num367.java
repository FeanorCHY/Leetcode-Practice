package leedcode;

public class num367 {
    public boolean isPerfectSquare(int num) {
    	if(num==1)
    		return true;
    	long low=2;
    	long high=num/2;
    	long mid=(low+high)/2;
    	while(low<=high){
    		long pro=mid*mid;
    		if(pro==(long)num)
    			return true;
    		else if(pro>(long)num)
    			high=mid-1;
    		else
    			low=mid+1;
    		mid=(low+high)/2;
    	}
        return false;
    }
	public static void main(String[] args) {
		num367 sol=new num367();
		System.out.println(sol.isPerfectSquare(808201));
	}

}
