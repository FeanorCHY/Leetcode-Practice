package leedcode;

public class num276 {
    public int numWays(int n, int k) {
    	int[] same=new int[n];
    	int[] dif=new int[n];
    	if(n==0)
    		return 0;
    	if(n==1)
    		return k;
    	if(n==2)
    		return k*k;
    	same[0]=k;
    	dif[0]=k;
    	same[1]=k;
    	dif[1]=k*(k-1);
    	for(int i=2;i<n;i++){
    		same[i]=dif[i-1];
    		dif[i]=(same[i-1]+dif[i-1])*(k-1);
    	}
        return same[n-1]+dif[n-1];
    }
	public static void main(String[] args) {
		num276 sol=new num276();
		System.out.println(sol.numWays(3, 2));
	}

}





//int res=0;
//int n; 
//int k;
//public int numWays(int n, int k) {
//	if(n==0)
//		return 0;
//	if(n==1)
//		return k;
//	this.n=n;
//	this.k=k;
//	find(k,2,false);
//    return res;
//}
//private void find(int pre,int num,boolean same){
//	if(num==n+1){
//		res+=pre;
//		return;
//	}
//	if(same){
//		find(pre*(k-1),num+1,false);
//	}
//	else{
//		find(pre,num+1,true);
//		find(pre*(k-1),num+1,false);
//	}
//}