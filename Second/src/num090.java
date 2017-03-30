import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num090 {

    //iterative with dp
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     List<List<Integer>> res=new LinkedList<List<Integer>>();
    //     res.add(new LinkedList<Integer>());
    //     if(nums==null||nums.length==0)
    //         return res;
    //     List<List<Integer>> dp[]=new List[nums.length];
    //     for(int i=0;i<dp.length;i++){
    //         dp[i]=new LinkedList<List<Integer>>();
    //     }
    //     Arrays.sort(nums);
    //     for(int i=0;i<nums.length;i++){
    //         if(i>0){
    //             if(nums[i]==nums[i-1]){
    //                 for(List<Integer> list:dp[i-1]){
    //                     List<Integer> tem=new LinkedList<Integer>(list);
    //                     tem.add(nums[i]);
    //                     dp[i].add(tem);
    //                 }
    //             }
    //             else{
    //                 List<Integer> loc=new LinkedList<Integer>();
    //                 loc.add(nums[i]);
    //                 dp[i].add(loc);
    //                 for(int j=0;j<i;j++){
    //                     for(List<Integer> list:dp[j]){
    //                         List<Integer> tem=new LinkedList<Integer>(list);
    //                         tem.add(nums[i]);
    //                         dp[i].add(tem);
    //                     }
    //                 }
    //             }
    //         }
    //         else{
    //             List<Integer> loc=new LinkedList<Integer>();
    //             loc.add(nums[i]);
    //             dp[i].add(loc);
                
    //         }
    //     }
    //     for(List<List<Integer>> listlist:dp)
    //         res.addAll(listlist);
    //     return res;
    // }
    
    
    
    
    
    //recursive
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        this.nums=nums;
        search(new ArrayList<Integer>(),0);
        return res;
    }
    private void search(List<Integer> list,int idx){
        res.add(new LinkedList<Integer>(list));
        while(idx<nums.length){
            list.add(nums[idx]);
            search(list,++idx);
            list.remove(list.size()-1);
            while(idx<nums.length&&nums[idx]==nums[idx-1])
                idx++;
        }
    }
    
    
    //optimized iterative
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Arrays.sort(nums);
    //     List<List<Integer>> res=new ArrayList<List<Integer>>();
    //     res.add(new ArrayList<Integer>());
    //     int start=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(i==0||nums[i]!=nums[i-1])
    //             start=0;
    //         int size=res.size();
    //         for(int j=start;j<size;j++){
    //             List<Integer> tem=new ArrayList<Integer>(res.get(j));
    //             tem.add(nums[i]);
    //             res.add(tem);
    //         }
    //         start=size;
    //     }
    //     return res;
    // }
	public static void main(String[] args) {
	}

}
