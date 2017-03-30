
public class num287 {

    //O(N)
    public int findDuplicate(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int n=nums.length-1;
        int slow=nums[n]-1;
        int fast=nums[slow]-1;
        while(slow!=fast){
            slow=nums[slow]-1;
            fast=nums[nums[fast]-1]-1;
        }
        slow=n;
        while(slow!=fast){
            slow=nums[slow]-1;
            fast=nums[fast]-1;
        }
        
        return slow+1;
            
    }
    
    
    
    //O(NlogN)
    // public int findDuplicate(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int n=nums.length-1;
    //     int l=1;
    //     int r=n;
    //     while(l<r){
    //         int mid=(l+r)/2;
    //         System.out.println(mid);
    //         int less=0;
    //         int more=0;
    //         for(int num:nums){
    //             if(num>mid&&num<=r)
    //                 more++;
    //             else if(num<=mid&&num>=l)
    //                 less++;
    //         }
    //         if((r-l+1)%2!=0)
    //             more++;
    //         if(more>less)
    //             l=mid+1;
    //         else
    //             r=mid;
    //     }
    //     return r;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
