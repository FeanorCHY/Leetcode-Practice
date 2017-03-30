package leedcode;

public class num313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
    	int k=primes.length;
    	int result[]=new int[n];
    	result[0]=1;
    	int index[]=new int[k];
    	for(int i=1;i<n;i++){
    		int min=Integer.MAX_VALUE;
    		int key=0;
    		for(int j=0;j<k;j++){
    			if(primes[j]*result[index[j]]<min){
    				min=primes[j]*result[index[j]];
    				key=j;
    			}
    		}
    		for(int j=0;j<k;j++){
    			if(primes[j]*result[index[j]]==min){
    	    		index[j]++;
    			}
    		}
    		result[i]=min;
    	}
    	
        return result[n-1];
    }
	public static void main(String[] args) {
		int[] test={2,3,5};
		num313 sol=new num313();
		System.out.println(sol.nthSuperUglyNumber(10,test));
	}

}
