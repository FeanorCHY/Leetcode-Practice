
public class num162 {
    //can the first item count? what if one one item
    //iterative O(N)
    // public int findPeakElement(int[] nums) {
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]<nums[i-1])
    //             return i-1;
    //         // if((i==0||nums[i]>nums[i-1])&&(i==nums.length-1||nums[i]>nums[i+1]))
    //         //     return i;
    //     }
    //     return nums.length-1;
    // }
    
    //Binary Search
    //O(LogN)
    // public int findPeakElement(int[] nums) {
    //     int l=0;
    //     int r=nums.length-1;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         if((mid==0||nums[mid]>nums[mid-1])&&(mid==nums.length-1||nums[mid]>nums[mid+1]))
    //             return mid;
    //         else if(mid!=0&&nums[mid]<=nums[mid-1])
    //             r=mid-1;
    //         else
    //             l=mid+1;
    //     }
    //     return nums.length-1;
    // }
    
    //Optimized Binary Search
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }
        int left = 0, right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
