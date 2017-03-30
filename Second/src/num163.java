import java.util.LinkedList;
import java.util.List;

public class num163 {

    //Integer Limit!!! duplicates!!!
    // public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    //     List<String> res=new LinkedList<String>();
    //     if(nums==null||lower>upper)
    //         return res;
    //     if(nums.length==0){
    //         if(lower==upper)
    //             res.add(lower+"");
    //         else
    //             res.add(lower+"->"+upper);
    //         return res;
    //     }
    //     if(nums[0]>lower){
    //         if(nums[0]==lower+1)
    //             res.add(lower+"");
    //         else
    //             res.add(lower+"->"+(nums[0]-1));
    //     }
    //     for(int i=1;i<nums.length;i++){
    //         if((long)nums[i]>(long)nums[i-1]+1){
    //             if(nums[i]==nums[i-1]+2)
    //                 res.add((nums[i-1]+1)+"");
    //             else
    //                 res.add((nums[i-1]+1)+"->"+(nums[i]-1));
    //         }
    //     }
    //     if(upper>nums[nums.length-1]){
    //         if(upper==nums[nums.length-1]+1)
    //             res.add(upper+"");
    //         else
    //             res.add((nums[nums.length-1]+1)+"->"+upper);
            
    //     }
    //     return res;
    // }
    
    
 
    //concise one
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res=new LinkedList<String>();
        if(nums==null||lower>upper)
            return res;
        long pre=(long)lower-1;
        for(int i=0;i<=nums.length;i++){
            long after=i==nums.length?(long)upper+1:nums[i];
            if(pre+2==after)
                res.add((pre+1)+"");
            else if(pre+2<after)
                res.add((pre+1)+"->"+(after-1));
            pre=after;
        }
        return res;
    }   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
