
public class num413 {
    //will the difference over the Integer Limit?
    //O(N)
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length<3)
            return 0;
        int l=0,res=0;
        while(l<A.length-2){
            int dif=A[l+1]-A[l];
            int r=l+2;
            while(r<A.length){
                if(A[r]-A[r-1]==dif){
                    res+=r-l-1;
                    r++;
                }
                else
                    break;
            }
            l=r-1;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
