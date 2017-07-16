
public class num045 {

    //greedy Time O(N) Space O(1)
    public int jump(int[] nums) {
        int res=0;
        if(nums==null||nums.length<=1)
            return 0;
        int idx=0;
        int step=nums[0];
        while(idx<nums.length){
            if(step==idx&&nums[idx]==0&&idx!=nums.length-1)
                return -1;
            res++;
            int max=idx;
            for(;idx<=Math.min(nums.length-1,step);idx++)
                max=Math.max(max,idx+nums[idx]);
            step=max;
        }
        return res;
    }
	public static void main(String[] args) {
		int[] test={1,1,0,1};
		num045 sol=new num045();
		System.out.println(sol.jump(test));
	}

}
