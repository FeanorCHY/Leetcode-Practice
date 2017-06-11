
public class num041 {
	//Time O(N) Space O(1)
    // public int firstMissingPositive(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 1;
    //     int min=Integer.MAX_VALUE,max=0;
    //     for(int num:nums){
    //         if(num>0){
    //             min=Math.min(min,num);
    //             max=Math.max(max,num);
    //         }
    //     }
    //     if(max==0||min>1)
    //         return 1;
    //     for(int i=0;i<nums.length;i++){
    //         while(nums[i]>0&&nums[i]!=i+min&&nums[i]-min<nums.length&&nums[i]!=nums[nums[i]-min]){
    //             int tem=nums[nums[i]-min];
    //             nums[nums[i]-min]=nums[i];
    //             nums[i]=tem;
    //         }
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]!=i+min)
    //             return i+min;
    //     }
    //     return max+1;
        
    // }
    
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0)
            return 1;
        int idx=0;
        while(idx<nums.length){
            if(nums[idx]!=idx+1&&nums[idx]>0&&nums[idx]-1<nums.length&&nums[nums[idx]-1]!=nums[idx]){
                int tem=nums[nums[idx]-1];
                nums[nums[idx]-1]=nums[idx];
                nums[idx]=tem;
            }
            else
                idx++;
                
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
        
    }
	public static void main(String[] args) {
		String str="ababcdababce";
		int x=str.indexOf("ababce");
		int[] test={2,1};
		num041 sol=new num041();
		System.out.println(sol.firstMissingPositive(test));
	}

}
