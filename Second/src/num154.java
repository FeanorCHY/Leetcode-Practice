
public class num154 {
    //what if empty input
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;
        int lo=0,hi=nums.length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if(nums[mid]>nums[lo]){
                if(nums[mid]<=nums[hi])
                    return nums[lo];
                else
                    lo=mid+1;
            }
            else if(nums[mid]<nums[lo])
                hi=mid;
            else{
                if(nums[mid]<nums[hi])
                    return nums[mid];
                else if(nums[mid]>nums[hi])
                    lo=mid+1;
                else{
                    hi--;
                    // if(nums[mid]==nums[hi])
                        lo++;
                }
            }
                
        }
        return nums[lo];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
