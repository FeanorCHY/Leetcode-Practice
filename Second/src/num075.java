
public class num075 {

    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int i=0;
        while(i<=right){
            if(nums[i]==0)
                swap(nums,left++,i++);
            else if(nums[i]==2)
                swap(nums,i,right--);
            else
                i++;
        }
    }
    private void swap(int[] nums,int i,int j){
        if(i==j)
            return;
        nums[i]^=nums[j];
        nums[j]^=nums[i];
        nums[i]^=nums[j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
