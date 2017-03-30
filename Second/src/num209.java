
public class num209 {

    //will the sum over Integer Limit?
    //sliding window O(N)
    // public int minSubArrayLen(int s, int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int left=0;
    //     int sum=0;
    //     int min=Integer.MAX_VALUE;
    //     for(int i=0;i<nums.length;i++){
    //         sum+=nums[i];
    //         if(sum>=s){
    //             while(sum-nums[left]>=s)
    //                 sum-=nums[left++];
    //             min=Math.min(min,i-left+1);
    //         }
    //     }
    //     if(min>nums.length)
    //         return 0;
    //     return min;
    // }
    
    //Binary search window O(NlogN)
    int [] nums;
    int s;
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        this.nums=nums;
        this.s=s;
        int l=0;
        int r=nums.length;
        while(l<=r){
            int mid=(l+r)/2;
            if(search(mid)){
                r=mid-1;
            }
            else
                l=mid+1;
        }
        if(l>nums.length)
            return 0;
        return l;
    }
    private boolean search(int size){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i>=size)
                sum-=nums[i-size];
            if(sum>=s)
                return true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
