
public class num055 {

    //negative number? null input or zero length input? 
    //one pass.O(N)
    // public boolean canJump(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return false;
    //     if(nums.length==1)
    //         return true;
    //     int dis=1;
    //     for(int i=nums.length-2;i>=0;i--){
    //         if(nums[i]>=dis)
    //             dis=0;
    //         dis++;
    //     }
    //     return dis==1;
    // }
    
    //greedy O(N^2)
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)
            return false;
        if(nums.length==1)
            return true;
        int index=0;
        while(index<nums.length){
            int max=Integer.MIN_VALUE;
            int next=0;
            for(int i=index+1;i<=index+nums[index];i++){
                if(i==nums.length-1)
                    return true;
                if(max<nums[i]+i){
                    max=nums[i]+i;
                    next=i;
                }
            }
            if(next==0)
                return false;
            index=next;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
