package leedcode;

public class num376 {
    public int wiggleMaxLength(int[] nums) {
    	if(nums.length<=1)
    		return nums.length;
    	if(nums.length==2&&nums[1]!=nums[0])
    		return 2;
    	else if(nums.length==2&&nums[1]==nums[0])
    		return 1;
    	int count=1;
    	int lastdif=0;
    	boolean begin=true;
    	for(int i=1;i<nums.length;i++){
    		if(begin){
    			lastdif=nums[i]-nums[i-1];
    		}
    		if(lastdif==0)
    			continue;
    		else{
    			if(begin){
    				count++;
    				begin=false;
    			}
    			if((nums[i]-nums[i-1])*lastdif<0){
    				lastdif=nums[i]-nums[i-1];
    				count++;
    			}
    		}
    	}
    	
    	
        return count;
    }
	public static void main(String[] args) {
		int test[]={1,1,1,7,4,4,4,9,2,5};
		num376 sol=new num376();
		System.out.println(sol.wiggleMaxLength(test));
	}

}
