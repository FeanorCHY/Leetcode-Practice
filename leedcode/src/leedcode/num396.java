package leedcode;

public class num396 {
    public int maxRotateFunction(int[] A) {
    	if(A.length==0)
    		return 0;
    	int s=0;
    	for(int i=0;i<A.length;i++){
    		s+=A[i];
    	}
    	int F=0;
    	for(int i=0;i<A.length;i++){
    		F+=i*A[i];
    	}
    	int max=F;
    	for(int i=1;i<A.length;i++){
    		F=F+s-A.length*A[A.length-i];
    		max=Math.max(F, max);
    	}
    	
        return max;
    }
	public static void main(String[] args) {
		num396 sol=new num396();
		int[] test={4, 3, 2, 6};
		System.out.println(sol.maxRotateFunction(test));
	}

}



//public int maxRotateFunction(int[] A) {
//	if(A.length==0)
//		return 0;
//	int max=Integer.MIN_VALUE;
//	for(int start=0;start<A.length;start++){
//		int cur=start;
//		int sum=0;
//		for(int plus=0;plus<A.length;plus++){
//			sum+=A[(cur+plus)%A.length]*plus;
//		}
//		max=Math.max(sum, max);
//	}
//	
//    return max;
//}