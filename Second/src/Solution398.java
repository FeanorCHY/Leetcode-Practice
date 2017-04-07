import java.util.Random;

public class Solution398 {
    //Space O(1)
    int[] nums;
    Random ran=new Random();
    public Solution398(int[] nums) {
        this.nums=nums;
    }
    //O(N)
    public int pick(int target) {
        int res=-1;
        int count=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==target&&ran.nextInt(++count)==0)
                res=i;
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */