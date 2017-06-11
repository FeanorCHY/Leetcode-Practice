import java.util.HashMap;

public class num128 {
    //HashSet Time O(N) Space O(N)
    // public int longestConsecutive(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     HashSet<Integer> map=new HashSet<Integer>();
    //     for(int num:nums){
    //         map.add(num);
    //     }
    //     int res=1;
    //     for(int each:nums){
    //         if(!map.contains(each))
    //             continue;
    //         int cur=1;
    //         int num=each+1;
    //         while(map.contains(num)){
    //             map.remove(num);
    //             cur++;
    //             num++;
    //         }
    //         num=each-1;
    //         while(map.contains(num)){
    //             map.remove(num);
    //             cur++;
    //             num--;
    //         }
    //         res=Math.max(res,cur);
    //     }
    //     return res;
    // }
    
    //Union Find
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int res=1;
        for(int num:nums){
            if(map.containsKey(num))
                continue;
            int left=map.containsKey(num-1)?map.get(num-1):0;
            int right=map.containsKey(num+1)?map.get(num+1):0;
            int sum=left+right+1;
            res=Math.max(sum,res);
            map.put(num,sum);
            map.put(num-left,sum);
            map.put(num+right,sum);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
