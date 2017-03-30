package leedcode;

public class num55 {
    public boolean canJump(int[] nums) {
    	if(nums.length==1){
    		return true;
    	}
    	else if(nums[0]==0)
    		return false;
    	int cur=0;
    	while(true){
        	if(nums[cur]==0)
        		return false;
        	int far=0;
        	int farIndex=0;
        	for(int i=1;i<=nums[cur];i++){
        		if(cur+i+nums[cur+i]>=nums.length-1)
        			return true;
        		if(i+nums[cur+i]>far){
        			far=i+nums[cur+i];
        			farIndex=i;
        		}
        	}
        	cur=cur+far;
        	if(cur>=nums.length-1)
        		return true;
    	}
    }
	public static void main(String[] args) {
		num55 sol=new num55();
		int[] test={2,1,2,1,2,1};
		System.out.println(sol.canJump(test));
	}

}
