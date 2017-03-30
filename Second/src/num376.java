
public class num376 {

    //Time: O(N) Space O(1)
    // public int wiggleMaxLength(int[] nums) {
    //     if(nums==null)
    //         return 0;
    //     if(nums.length<=1)
    //         return nums.length;
    //     int last=nums[0];
    //     boolean large=false;
    //     int res=1;
    //     for(int i=1;i<nums.length;i++){
    //         if(res==1){
    //             if(nums[i]!=nums[i-1]){
    //                 res++;
    //                 large=nums[i]<nums[i-1];
    //             }
    //             continue;
    //         }
    //         if(large&&nums[i]>nums[i-1]){
    //             res++;
    //             large=false;
    //         }
    //         else if(!large&&nums[i]<nums[i-1]){
    //             res++;
    //             large=true;
    //         }
    //     }
    //     return res;
    // }
    
    
    
    //greedy
    public int wiggleMaxLength(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length<=1)
            return nums.length;
        int l=1,d=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])
                l=d+1;
            else if(nums[i]<nums[i-1])
                d=l+1;
        }
        return Math.max(l,d);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
