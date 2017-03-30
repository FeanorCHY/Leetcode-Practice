
public class num031 {

    //what for 551->515
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)
            return;
        int i=nums.length-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1])
                break;
        }
        int l=i+1,r=nums.length-1;
        while(l<r){
            nums[l]^=nums[r];
            nums[r]^=nums[l];
            nums[l]^=nums[r];
            l++;
            r--;
        }
        
        if(i>=0){
            int x=i;
            while(x<nums.length&&nums[x]<=nums[i])
                x++;
            nums[x]^=nums[i];
            nums[i]^=nums[x];
            nums[x]^=nums[i];
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
