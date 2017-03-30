import java.util.Arrays;

public class num324 {

    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        System.out.println(Arrays.toString(nums));
        System.out.println(median);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                exch(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                exch(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.k=k;
        return find(nums,0,nums.length-1);
    }
    private int find(int[] nums,int start,int end){
        if(start==end)
            return nums[start];
        int r=end;
        int l=start;
        int pivot=start++;
        while(start<=end){
            while(start<=end&&nums[start]>=nums[pivot])
                start++;
            while(start<=end&&nums[end]<=nums[pivot])
                end--;
            if(start<end){
                nums[start]^=nums[end];
                nums[end]^=nums[start];
                nums[start]^=nums[end];
            }
        }
        // System.out.println(pivot);
        if(pivot!=end){
            nums[pivot]^=nums[end];
            nums[end]^=nums[pivot];
            nums[pivot]^=nums[end];
        }
        if(end+1==k)
            return nums[end];
        else if(end+1>k){
            return find(nums,l,end-1);
        }
        else
            return find(nums,end+1,r);
    }
    private void exch(int[] a, int i, int j) {
    	if(i==j)
    		return;
        a[i]^=a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }
	public static void main(String[] args) {
		int[] test=
//			{1,1,1,1,2,2,2};
			{6,13,5,4,5,2};
//			{1,5,1,1,6,4};
		num324 sol=new num324();
		sol.wiggleSort(test);
		System.out.println(Arrays.toString(test));
	}

}
