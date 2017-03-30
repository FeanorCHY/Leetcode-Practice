
public class num080 {

    //O(N)
    // public int removeDuplicates(int[] nums) {
    //     if(nums==null||nums.length<3)
    //         return nums.length;
    //     int idx=1,front=1;
    //     boolean rep=false;
    //     for(;front<nums.length;front++){
    //         if(nums[front]==nums[front-1]&&!rep){
    //             rep=true;
    //             nums[idx++]=nums[front];
    //         }
    //         else if(nums[front]!=nums[front-1]){
    //             nums[idx++]=nums[front];
    //             rep=false;
    //         }
    //     }
    //     return idx;
    // }
    
    
    //short and concise
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length<3)
            return nums.length;
        int idx=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[idx-2])
                nums[idx++]=nums[i];
        }
        return idx;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
