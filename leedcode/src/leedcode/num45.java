package leedcode;

public class num45 {
    public int jump(int[] nums) {
    	if(nums.length<=1)
    		return 0;
    	int last=0;
    	int count=1;
    	while(nums[last]+last<nums.length-1){
    		count++;
        	int max=0;
        	int pos=-1;
	    	for(int i=last+1;i<=last+nums[last];i++){
	    		if(nums[i]+i-last>max){
	    			pos=i;
	    			max=nums[i]+i-last;
	    		}
	    	}
	    	last=pos;
    	}
    	
    	
        return count;
    }
	public static void main(String[] args) {
		int test[]={2,3,1,1,4};
		num45 sol=new num45();
		System.out.println(sol.jump(test));
	}

}
