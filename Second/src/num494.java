import java.util.Arrays;
import java.util.HashMap;

public class num494 {
    //stupid traverse with pruning time O(2^N)  Space O(1)
    // int res=0;
    // public int findTargetSumWays(int[] nums, int S) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int dif=0;
    //     for(int num:nums)
    //         dif+=num;
    //     if(dif<S)
    //         return 0;
    //     Arrays.sort(nums);
    //     dif=dif-S;
    //     traverse(nums,dif,0);
    //     return res;
    // }
    // private void traverse(int[] nums,int rest,int cur){
    //     if(rest==0){
    //         res++;
    //     }
    //     for(int i=cur;i<nums.length;i++){
    //         if(2*nums[i]>rest)
    //             return;
    //         traverse(nums,rest-2*nums[i],i+1);
    //     }
    // }
    
    
    //traverse with memorization Time O(l*n) Space O(l*n)
    // public int findTargetSumWays(int[] nums, int S) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int[][] memo=new int[nums.length][2000];
    //     for(int[] me:memo){
    //         Arrays.fill(me,-1);
    //     }
    //     return check(nums,S,memo,0,0);
    // }
    // private int check(int[] nums,int S,int[][] memo,int cur,int index){
    //     if(index==nums.length){
    //         if(cur==S)
    //             return 1;
    //         else
    //         return 0;
    //     }
    //     if(memo[index][cur+1000]>=0)
    //         return memo[index][cur+1000];
    //     int add=check(nums,S,memo,cur+nums[index],index+1);
    //     int minus=check(nums,S,memo,cur-nums[index],index+1);
    //     memo[index][cur+1000]=add+minus;
    //     return memo[index][cur+1000];
    // }
    
    
    //dynamic programming using hashmap
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0)
            return 0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer> tem=new HashMap<Integer,Integer>();
            for(int key:map.keySet()){
                if(tem.containsKey(nums[i]+key)){
                    tem.put(nums[i]+key,tem.get(nums[i]+key)+map.get(key));
                }
                else
                    tem.put(nums[i]+key,map.get(key));
                if(tem.containsKey(key-nums[i])){
                    tem.put(key-nums[i],tem.get(key-nums[i])+map.get(key));
                }
                else
                    tem.put(key-nums[i],map.get(key));
            }
            map=tem;
        }
        if(!map.containsKey(S))
            return 0;
        return map.get(S);
    }
	public static void main(String[] args) {
		num494 sol=new num494();
		int[] nums={1,1,1,1,1};
//		int[] nums={1,0};
		System.out.println(sol.findTargetSumWays(nums, 3));
	}

}
