import java.util.Arrays;
import java.util.Comparator;

public class num274 {

    //Sort O(NlogN) Space O(1)
    // public int hIndex(int[] cits) {
    //     if(cits==null||cits.length==0)
    //         return 0;
    //     Arrays.sort(cits);
    //     for(int i=0;i<cits.length;i++){
    //         if(cits[cits.length-1-i]<i+1)
    //             return i;
    //     }
    //     return cits.length;
    // }
    
    
    //Binary Search O(NlogN) Space O(1)
    // public int hIndex(int[] cits) {
    //     if(cits==null||cits.length==0)
    //         return 0;
    //     int l=0;
    //     int r=cits.length;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         int count=count(cits,mid);
    //         if(count>=mid)
    //             l=mid+1;
    //         else
    //             r=mid-1;
    //     }
    //     return r;
    // }
    // private int count(int[] cits,int target){
    //     int res=0;
    //     for(int cit:cits){
    //         if(cit>=target)
    //             res++;
    //     }
    //     return res;
    // }
    
    
    
    //store HIndex in array Time O(N) Space O(N)
    public int hIndex(int[] cits) {
        if(cits==null||cits.length==0)
            return 0;
        int[] degree=new int[cits.length+1];
        for(int cit:cits){
            if(cit>=cits.length)
                degree[cits.length]++;
            else
                degree[cit]++;
        }
        int sum=0;
        for(int i=degree.length-1;i>0;i--){
            sum+=degree[i];
            if(sum>=i)
                return i;
        }
        return 0;
    }
	public static void main(String[] args) {
	}

}
