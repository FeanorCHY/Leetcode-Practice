package leedcode;

public class num275 {
    public int hIndex(int[] citations) {
    	
    	int high=citations.length-1;
    	int low=0;
    	int mid=(high+low)/2;
    	while(low<=high){
    		if(citations[mid]>citations.length-mid){
    			high=mid-1;
    		}
    		else if(citations[mid]<citations.length-mid)
    			low=mid+1;
    		else
    			return citations.length-mid;
    		mid=(high+low)/2;
    	}
	    return citations.length-low;
	}

	public static void main(String[] args) {
		int[] test={1,1,2,3,4,5,7};
		num275 sol=new num275();
		System.out.println(sol.hIndex(test));
	}

}
