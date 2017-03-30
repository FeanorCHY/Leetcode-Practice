
public class num053 {

    //divide and conquer
	int[] nums;
    public int maxSubArray(int[] nums) {
    	this.nums=nums;
        return Subarray(0 ,nums.length -1 );
    }
    private int Subarray(int left,int right){
        if(left==right) return nums[left];
        int mid=left+(right-left)/2;
        int leftSum=Subarray(left,mid);
        int rightSum=Subarray(mid+1,right);
        int crossSum=crossSum(left,right);
    	return Math.max(rightSum,Math.max(leftSum,crossSum));
    }
    private int crossSum(int left,int right){
        int mid=left+(right-left)/2;
        int leftSum=nums[mid];
        int rightSum=nums[mid+1];
        int sum=leftSum;
        for(int i=mid-1;i>=left;i--){
            sum+=nums[i];
            if(sum>leftSum)
                leftSum=sum;
        }
        sum=rightSum;
        for(int i=mid+2;i<=right;i++){
            sum+=nums[i];
            if(sum>rightSum)
                rightSum=sum;
        }
        return rightSum+leftSum;
    }
    //DP
    // public int maxSubArray(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     int max=Integer.MIN_VALUE;
    //     int cur=0;
    //     for(int i=0;i<nums.length;i++){
    //         cur+=nums[i];
    //         max=Math.max(max,cur);
    //         if(cur<0){
    //             cur=0;
    //         }
    //     }
    //     return max;
    // }
	public static void main(String[] args) {
		int[] test={-2,1,-3,4,-1,2,1,-5,4};
		num053 sol=new num053();
		System.out.println(sol.maxSubArray(test));
	}

}
