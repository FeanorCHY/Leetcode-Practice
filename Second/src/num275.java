
public class num275 {

    //Binary Search
    public int hIndex(int[] cits) {
        if(cits==null||cits.length==0)
            return 0;
        int len=cits.length;
        int l=0,r=len-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(cits[mid]>=len-mid)
                r=mid-1;
            else
                l=mid+1;
        }
        return len-l;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
