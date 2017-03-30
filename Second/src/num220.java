import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class num220 {

    
    //TreeSet
    //O(nlog(min(n,k)))
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     if(nums==null||nums.length==0||k<=0||t<0)
    //         return false;
    //     TreeSet<Long> set=new TreeSet<Long>();
    //     for(int i=0;i<nums.length;i++){
    //         Long c=set.ceiling((long)nums[i]);
    //         Long f=set.floor((long)nums[i]);
    //         if((c!=null&&c<=(long)nums[i]+(long)t)||(f!=null&&f>=(long)nums[i]-(long)t))
    //             return true;
    //         if(i>=k)
    //             set.remove((long)nums[i-k]);
    //         set.add((long)nums[i]);
    //     }
    //     return false;
    // }
    
    //Bucket Sort
    //O(n)
    private long getNum(long x,long w){
        return x<0?((x+1)/w-1):x/w;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length==0||k<=0||t<0)
            return false;
        HashMap<Long,Long> map=new HashMap<Long,Long>();
        int w=t+1;
        for(int i=0;i<nums.length;i++){
            long num=getNum((long)nums[i],w);
            if(map.containsKey(num))
                return true;
            // System.out.println(map);
            if((map.containsKey(num-1)&&(long)nums[i]-map.get(num-1)<=t)||(map.containsKey(num+1)&&map.get(num+1)-(long)nums[i]<=t))
                return true;
            if(i>=k)
                map.remove(getNum((long)nums[i-k],w));
            map.put(num,(long)nums[i]);
        }
        return false;
            
    }
    
    
    //does the set have duplicate? 
    //O(nlog(min(n,k)))
    //The number might larger than Integer limit
    //TreeMap
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     if(nums==null||nums.length==0||k<=0||t<0)
    //         return false;
    //     TreeMap<Long,Integer> map=new TreeMap<Long,Integer>();
    //     for(int i=0;i<Math.min(nums.length,k);i++){
    //         if(map.containsKey((long)nums[i])){
    //             map.put((long)nums[i],map.get((long)nums[i])+1);
    //         }
    //         else
    //             map.put((long)nums[i],1);
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         map.put((long)nums[i],map.get((long)nums[i])-1);
    //         if(map.get((long)nums[i])==0)
    //             map.remove((long)nums[i]);
    //         if(i+k<nums.length&&map.containsKey((long)nums[i+k])){
    //             map.put((long)nums[i+k],map.get((long)nums[i+k])+1);
    //         }
    //         else if(i+k<nums.length)
    //             map.put((long)nums[i+k],1);
    //         if(i-k-1>=0){
    //             map.put((long)nums[i-k-1],map.get((long)nums[i-k-1])-1);
    //             if(map.get((long)nums[i-k-1])==0)
    //                 map.remove((long)nums[i-k-1]);
    //         }
    //         // System.out.println(map);
    //         if(map.subMap((long)nums[i]-(long)t,(long)nums[i]+(long)t+(long)1).size()!=0)
    //             return true;
    //         if(map.containsKey((long)nums[i])){
    //             map.put((long)nums[i],map.get((long)nums[i])+1);
    //         }
    //         else
    //             map.put((long)nums[i],1);
    //     }
    //     return false;
    // }
	public static void main(String[] args) {
		TreeSet<Integer> set=new TreeSet<Integer>();
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		set.add(1);
		set.add(1);
		
	}

}
