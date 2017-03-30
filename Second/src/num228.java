import java.util.ArrayList;
import java.util.List;

public class num228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<String>();
        if(nums==null||nums.length==0)
            return res;
        for(int i=0,j=0;j<nums.length;j++){
            if(j+1<nums.length&&nums[j+1]==nums[j]+1)
                continue;
            if(i==j)
                res.add(""+nums[i]);
            else
                res.add(nums[i]+"->"+nums[j]);
            i=j+1;
        }
        return res;
    }
    // public List<String> summaryRanges(int[] nums) {
    //     List<String> res=new ArrayList<String>();
    //     if(nums==null||nums.length==0)
    //         return res;
    //     int left=nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]!=nums[i-1]+1){
    //             if(left==nums[i-1]){
    //                 res.add(""+left);
    //             }
    //             else{
    //                 res.add(left+"->"+nums[i-1]);
    //             }
    //             left=nums[i];
    //         }
    //     }
    //     if(left==nums[nums.length-1])
    //         res.add(""+left);
    //     else
    //         res.add(left+"->"+nums[nums.length-1]);
    //     return res;
    // }   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
