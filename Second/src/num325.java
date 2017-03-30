import java.util.HashMap;

public class num325 {

    //Time O(N) Space O(N)
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return 0;
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(i>0)
                nums[i]+=nums[i-1];
            int rem=nums[i]-k;
            if(map.containsKey(rem))
                res=Math.max(res,i-map.get(rem));
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
