
public class num334 {

    public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length<3)
            return false;
        int min1=nums[0];
        int min2=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>min2)
                return true;
            else if(nums[i]>min1)
                min2=nums[i];
            else
                min1=nums[i];
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
