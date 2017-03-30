
public class num033 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
        
            if (nums[start] <= nums[mid]){//there should be one part that is continuous
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } 
            else{
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
    //O(NlogN)
    // public int search(int[] nums, int target) {
    //     if(nums==null||nums.length==0)
    //         return -1;
    //     int l=0;
    //     int r=nums.length-1;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         if(target>nums[mid]){
    //             if(nums[r]<nums[mid])
    //                 l=mid+1;
    //             else if(target>nums[r]){
    //                 r=mid-1;
    //             }
    //             else
    //                 l=mid+1;
    //         }
    //         else if(target<nums[mid]){
    //             if(nums[l]>nums[mid])
    //                 r=mid-1;
    //             else if(nums[l]>target)
    //                 l=mid+1;
    //             else
    //                 r=mid-1;
    //         }
    //         else
    //             return mid;
    //     }
    //     return -1;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
