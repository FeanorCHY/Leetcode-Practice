package leedcode;

public class num413 {
    public int numberOfArithmeticSlices(int[] A) {
    	int count=0;
    	int diff=0;
    	int rep=0;
    	for(int i=1;i<A.length;i++){
    		if(rep==0){
    			diff=A[i]-A[i-1];
    			rep++;
    		}
    		else{
    			if(diff==A[i]-A[i-1]){
    				count+=rep;
    				rep++;
    			}
    			else{
    				diff=A[i]-A[i-1];
    				rep=1;
    			}
    		}
    	}
    	
    	
    	return count;
    }
	public static void main(String[] args) {
		int test[]={1,2,3,4};
		num413 sol=new num413();
		System.out.println(sol.numberOfArithmeticSlices(test));
	}

}
