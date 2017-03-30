import java.util.LinkedList;
import java.util.List;

public class num442 {

    //two pass
    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> res=new LinkedList<Integer>();
    //     if(nums==null||nums.length==0)
    //         return res;
    //     for(int i=0;i<nums.length;i++){
    //         int tem=nums[i];
    //         if(tem!=i+1){
    //             if(nums[tem-1]!=tem){
    //                 nums[tem-1]^=nums[i];
    //                 nums[i]^=nums[tem-1];
    //                 nums[tem-1]^=nums[i];
    //                 i--;
    //             }
    //         }
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]!=i+1){
    //             res.add(nums[i]);
    //         }
    //     }
    //     return res;
    // }
    
    
    //one pass without modifying the array
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new LinkedList<Integer>();
        if(nums==null||nums.length==0)
            return res;
        for(int i=0;i<nums.length;i++){
            int tem=Math.abs(nums[i])-1;
            if(nums[tem]<0)
                res.add(tem+1);
            nums[tem]=-nums[tem];
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
