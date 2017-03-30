import java.util.ArrayList;
import java.util.List;

public class num392 {
    // one pass O(T)
    // HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
    // public boolean isSubsequence(String s, String t) {
    //     if(s==null||t==null)
    //         return false;
    //     char[] arrs=s.toCharArray();
    //     char[] arrt=t.toCharArray();
    //     if(arrs.length==0)
    //         return true;
    //     if(arrt.length==0)
    //         return false;
    //     int i=0,j=0;
    //     for(;i<arrs.length&j<arrt.length;j++){
    //         if(arrs[i]==arrt[j])
    //             i++;
    //     }
    //     return i==arrs.length;
    // }
    
    //Binary Search Time O(N+SlogN) Space O(N)
    public boolean isSubsequence(String s, String t) {
        if(s==null||t==null)
            return false;
        char[] arrs=s.toCharArray();
        char[] arrt=t.toCharArray();
        if(arrs.length==0)
            return true;
        if(arrt.length==0)
            return false;
        List<Integer> lists[]=new List[256];
        for(int i=0;i<arrt.length;i++){
            if(lists[arrt[i]]==null)
                lists[arrt[i]]=new ArrayList<Integer>();
            lists[arrt[i]].add(i);
        }
        int idx=0;
        for(int i=0;i<arrs.length;i++){
            if(lists[arrs[i]]==null)
                return false;
            int tem=BSearch(lists[arrs[i]],idx);
            if(tem==-1)
                return false;
            idx=tem+1;
        }
        return true;
        
    }
    private int BSearch(List<Integer> list,int target){
        int l=0,r=list.size()-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(list.get(mid)==target)
                return mid;
            else if(list.get(mid)>target)
                r=mid-1;
            else
                l=mid+1;
        }
        if(l==list.size())
            return -1;
        return list.get(l);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
