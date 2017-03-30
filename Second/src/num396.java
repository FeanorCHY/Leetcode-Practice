
public class num396 {

    public int maxRotateFunction(int[] A) {
        if(A==null||A.length==0)
            return 0;
        int sum=0;
        for(int a:A)
            sum+=a;
        int cur=0;
        for(int i=0;i<A.length;i++){
            cur+=i*A[i];
        }
        int res=cur;
        for(int i=A.length-1;i>0;i--){
            cur=cur+sum-A.length*A[i];
            res=Math.max(res,cur);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
