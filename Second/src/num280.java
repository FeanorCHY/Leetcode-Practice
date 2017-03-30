
public class num280 {

    //duplicates?
    //O(NlogN)
    // public void wiggleSort(int[] nums) {
    //     if(nums==null)
    //         return;
    //     Arrays.sort(nums);
    //     if(nums.length<=2)
    //         return;
    //     int low=1;
    //     int high=nums.length%2==0?nums.length-2:nums.length-1;
    //     while(low<high){
    //         nums[low]^=nums[high];
    //         nums[high]^=nums[low];
    //         nums[low]^=nums[high];
    //         low=low+2;
    //         high=high-2;
    //     }
    // }
    
    //one pass O(N)
    public void wiggleSort(int[] nums) {
        if(nums==null)
            return;
        boolean less=true;
        for(int i=1;i<nums.length;i++){
            if(less){
                if(nums[i-1]>nums[i]){
                    nums[i-1]^=nums[i];
                    nums[i]^=nums[i-1];
                    nums[i-1]^=nums[i];
                }
            }
            else{
                if(nums[i-1]<nums[i]){
                    nums[i-1]^=nums[i];
                    nums[i]^=nums[i-1];
                    nums[i-1]^=nums[i];
                }
            }
            less=!less;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
