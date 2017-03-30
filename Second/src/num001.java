import java.util.Arrays;
import java.util.HashMap;

public class num001 {
    //what if the input is invalid? is there negative input? 
    //Time O(N) Space O(N)
    // public int[] twoSum(int[] nums, int target) {
    //     HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    //     for(int i=0;i<nums.length;i++){
    //         if(map.containsKey(target-nums[i]))//search if there is a previously searched element add current number to target
    //             return new int[]{i,map.get(target-nums[i])};
    //         map.put(nums[i],i);
    //     }
    //     return new int[0];
    // }
    
    
    //Binary Search
    //Time O(NlogN) Space O(N)
    // public int[] twoSum(int[] nums, int target) {
    //     if(nums==null||nums.length<2)
    //         return new int[0];
    //     int[] copy=nums.clone();
    //     Arrays.sort(nums);
    //     int l=0,r=nums.length-1;
    //     while(l<r){//avoid reach the same indices
    //         if(nums[l]+nums[r]==target){
    //             int[] res=new int[2];
    //             int pos=0;
    //             for(int i=0;i<copy.length&&pos<2;i++){
    //                 if(copy[i]==nums[l]||copy[i]==nums[r])
    //                     res[pos++]=i;
    //             }
    //             return res;
    //         }
    //         else if(nums[l]+nums[r]>target)
    //             r--;
    //         else
    //             l++;
    //     }
    //     return new int[0];//if the result doest not exist
    // }
    
    
    //Binary Search with Space O(1)
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length<2)
            return new int[0];
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*n+(nums[i]>0?i:-i);
        }
        Arrays.sort(nums);
        
        int l=0,r=nums.length-1;
        while(l<r){//avoid reach the same indices
            int sum=nums[l]/n+nums[r]/n;
            if(sum==target)
                return new int[]{nums[l]>0?nums[l]%n:-nums[l]%n,nums[r]>0?nums[r]%n:-nums[r]%n};
            else if(sum>target)
                r--;
            else 
                l++;
            
        }
        return new int[0];//if the result doest not exist
    }

}
