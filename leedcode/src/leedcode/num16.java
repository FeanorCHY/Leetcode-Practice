package leedcode;

import java.util.Arrays;

public class num16 {

    // public int threeSumClosest(int[] nums, int target) {
    //     Arrays.sort(nums);
    //     int diff = Integer.MAX_VALUE, closest = 0;
    //     for (int k=0; k<nums.length-2; ++k) {
    //         for (int i=k+1, j=nums.length-1; i<j; ) {
    //             int sum = nums[k] + nums[i] + nums[j];
    //             if (sum == target) { return target; }
    //             else if (sum > target) {
    //                 if (sum-target < diff) {
    //                     diff = sum-target;
    //                     closest = sum;
    //                 }
    //                 --j;
    //             } else {
    //                 if (target-sum < diff) {
    //                     diff = target-sum;
    //                     closest = sum;
    //                 }
    //                 ++i;
    //             }
    //         }
    //     }
    //     return closest;
    // }
    
    
    //do you allow me to change the input? will the sum over Integer input? 
    //O(N^2)
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3)
            return 0;
        Arrays.sort(nums);
        int res=0;
        int dif=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            int val=nums[i];
            while(l<r){
                int sum=val+nums[l]+nums[r];
                // if(Math.abs(res-target)>Math.abs(sum-target))
                //     res=sum;
                if(sum>target){
                    if(sum-target<dif){
                        dif=sum-target;
                        res=sum;
                    }
                    r--;
                }
                else if(sum<target){
                    if(target-sum<dif){
                        dif=target-sum;
                        res=sum;
                    }
                    l++;
                }
                else
                    return target;
            }
        }
        return res;
    }
}
