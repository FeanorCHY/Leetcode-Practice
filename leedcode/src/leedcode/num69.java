package leedcode;

public class num69 {
    public int mySqrt(int x) {
    	long low=0;
    	long high=(x+1)/2;
    	long mid=(low+high)/2;
    	while(low<=high){
    		long tem=(long)mid*(long)mid;
    		if(tem>x)
    			high=mid-1;
    		else if(tem<x)
    			low=mid+1;
    		else
    			return (int)mid;
    		mid=(low+high)/2;
    		
    	}
    	return (int)high;
    }
	public static void main(String[] args) {
		num69 sol=new num69();
		System.out.println(sol.mySqrt(2147483647));
	}

}
