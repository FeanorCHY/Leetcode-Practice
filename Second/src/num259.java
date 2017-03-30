import java.util.Arrays;

public class num259 {
    //Sort and Binary Search O(N^2*logN)
    //duplicates? over Integer Limit?
    // public int threeSumSmaller(int[] nums, int target) {
    //     if(nums==null||nums.length<3)
    //         return 0;
    //     int res=0;
    //     Arrays.sort(nums);
    //     for(int i=0;i<nums.length-2;i++){
    //         for(int j=i+1;j<nums.length-1;j++){
    //             int sum=target-nums[i]-nums[j];
    //             res+=BSearch(nums,j+1,nums.length-1,sum);
    //         }
    //     }
    //     return res;
    // }
    // private int BSearch(int[] nums,int l,int r,int sum){
    //     int tem=l;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         if(nums[mid]>=sum)
    //             r=mid-1;
    //         else
    //             l=mid+1;
    //     }
    //     return l-tem;
    // }
    
    
    //two pointer O(N^2)
    public int threeSumSmaller(int[] nums, int target) {
        if(nums==null||nums.length<3)
            return 0;
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum=nums[l]+nums[r]+nums[i];
                if(sum>=target)
                    r--;
                else{
                    res+=r-l;
                    l++;
                }
                    
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
