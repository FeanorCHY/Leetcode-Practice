import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class num327 {

    //Binary Search Tree Time O(nlogn) Space O(n^2)
    // public int countRangeSum(int[] nums, int lo, int up) {
    //     long lower=lo;
    //     long upper=up;
    //     if(nums==null||lower>upper||nums.length==0)
    //         return 0;
    //     int res=0;
    //     long sum=0;
    //     TreeMap<Long,Integer> map=new TreeMap<Long,Integer>();
    //     for(int i=0;i<nums.length;i++){
    //         sum+=(long)nums[i];
    //         if(sum>=lower&&sum<=upper)
    //             res++;
    //         Map<Long, Integer> sub=map.subMap(sum-upper,true,sum-lower,true);
    //         for(Map.Entry<Long,Integer> entry : sub.entrySet()){
    //             res+=entry.getValue();
    //         }
    //         if(!map.containsKey(sum))
    //             map.put(sum,0);
    //         map.put(sum,map.get(sum)+1);
    //     }
    //     return res;
    // }
    
    
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null||lower>upper||nums.length==0)
            return 0;
        long[] sums=new long[nums.length+1];
        for(int i=0;i<nums.length;i++)
            sums[i+1]=sums[i]+nums[i];
        return mergeSearch(sums,0,nums.length,lower,upper);
    }
    private int mergeSearch(long[] sums,int start,int end,long lower,long upper){
        if(start>=end)
            return 0;
        int mid=(start+end)/2;
        int count=mergeSearch(sums,start,mid,lower,upper)+mergeSearch(sums,mid+1,end,lower,upper);
        long[] cache=new long[end-start+1];
        int idx=0,x=mid+1,y=mid+1;
        for(int i=start,j=mid+1;i<=mid;i++){
            while(x<=end&&sums[x]-sums[i]<lower)
                x++;
            while(y<=end&&sums[y]-sums[i]<=upper)
                y++;
            while(j<=end&&sums[j]<=sums[i])
                cache[idx++]=sums[j++];
            cache[idx++]=sums[i];
            count+=y-x;
        }
        for(int i=0;i<idx;i++)
            sums[i+start]=cache[i];
        return count;
    }
	public static void main(String[] args) {
		int[] test={-2,5,-1};
		num327 sol=new num327();
		System.out.println(sol.countRangeSum(test, -2, 2));
	}

}
