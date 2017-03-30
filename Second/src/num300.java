import java.util.Arrays;

public class num300 {
    // class LISNode{
    //     int val;
    //     LISNode next=null;
    //     public LISNode(int val){
    //         this.val=val;
    //     }
    // }
    //ListNode Time: O(N^2) Space O(N)
    // public int lengthOfLIS(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     LISNode head=null;
    //     int len=1;
    //     for(int each:nums){
    //         if(head==null)
    //             head=new LISNode(each);
    //         else{
    //             LISNode node=head;
    //             LISNode last=null;
    //             while(node!=null&&each>node.val){
    //                 last=node;
    //                 node=node.next;
    //             }
    //             if(node==null){
    //                 last.next=new LISNode(each);
    //                 len++;
    //             }
    //             else{
    //                 node.val=each;
    //             }
    //         }
    //     }
    //     return len;
    // }
    
    
    
    
    //dynamic programming Time: O(N^2) Space O(N)
    // public int lengthOfLIS(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int[] dp=new int[nums.length];
    //     dp[0]=1;
    //     int len=1;
    //     for(int i=1;i<nums.length;i++){
    //         int max=0;
    //         for(int j=0;j<nums.length;j++){
    //             if(nums[i]>nums[j]){
    //                 max=Math.max(max,dp[j]);
    //             }
    //             dp[i]=max+1;
    //             len=Math.max(len,dp[i]);
    //         }
    //     }
    //     return len;
    // }
    
    
    
    
    //dynamic programming with binary search: O(N^2) Space O(N)
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int[] dp=new int[nums.length];
        int len=0;
        for(int each:nums){
            int low=0;
            int high=len-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(nums[mid]>=each)
                    high=mid-1;
                else if(nums[mid]<each)
                    low=mid+1;
            }
            if(low==len)
                len++;
            nums[low]=each;
        }
        return len;
    }
	public static void main(String[] args) {
		num300 sol=new num300();
		int[] test={10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(sol.lengthOfLIS(test));
	}

}
