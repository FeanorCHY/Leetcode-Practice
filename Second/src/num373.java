import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class num373 {
    //if k is invalid...
    //PriorityQueue Time: O(NlogN) Space: O(N)
    // class Pair{
    //     int idx1;
    //     int idx2;
    //     int val;
    //     public Pair(int idx1,int idx2,int val){
    //         this.idx1=idx1;
    //         this.idx2=idx2;
    //         this.val=val;
    //     }
    // }
    // public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     List<int[]> res=new ArrayList<int[]>(k+1);
    //     if(nums1==null||nums2==null||nums1.length==0||nums2.length==0||k==0)
    //         return res;
    //     k=Math.min(k,nums1.length*nums2.length);
    //     PriorityQueue<Pair> pq=new PriorityQueue<Pair>(nums1.length+nums2.length,new Comparator<Pair>(){
    //         @Override
    //         public int compare(Pair p1,Pair p2){
    //             return p1.val-p2.val;
    //         }
    //     });
    //     for(int i=0;i<nums2.length;i++){
    //         pq.add(new Pair(0,i,nums1[0]+nums2[i]));
    //     }
    //     for(int i=0;i<k;i++){
    //         Pair p=pq.poll();
    //         res.add(new int[]{nums1[p.idx1],nums2[p.idx2]});
    //         p.idx1++;
    //         if(p.idx1<nums1.length){
    //             p.val=nums1[p.idx1]+nums2[p.idx2];
    //             pq.add(p);
    //         }
    //     }
    //     return res;
    // }
    
    
    
    
    
    
    //if k is invalid...
    //Optimized PriorityQueue Time: O(NlogN) Space: O(N)
    class Pair{
        int idx1;
        int idx2;
        int val;
        public Pair(int idx1,int idx2,int val){
            this.idx1=idx1;
            this.idx2=idx2;
            this.val=val;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res=new ArrayList<int[]>(k+1);
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0||k==0)
            return res;
        k=Math.min(k,nums1.length*nums2.length);
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(nums1.length+nums2.length,new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2){
                return p1.val-p2.val;
            }
        });
        pq.add(new Pair(0,0,nums1[0]+nums2[0]));
        int len=0;
        // for(int i=0;i<nums2.length;i++){
        //     pq.add(new Pair(0,i,nums1[0]+nums2[i]));
        // }
        for(int i=0;i<k;i++){
            Pair p=pq.poll();
            if(p.idx2==len&&len+1<nums2.length){
                pq.add(new Pair(p.idx1,++len,nums1[p.idx1]+nums2[p.idx2+1]));
            }
            res.add(new int[]{nums1[p.idx1],nums2[p.idx2]});
            p.idx1++;
            if(p.idx1<nums1.length){
                p.val=nums1[p.idx1]+nums2[p.idx2];
                pq.add(p);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		List<int[]> res=new ArrayList<int[]>();
		res.add(new int[]{1,2});
	}

}
