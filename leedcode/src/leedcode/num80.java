package leedcode;

public class num80 {
    public int removeDuplicates(int[] nums) {
    	int count=0;
    	int insert=2;
    	if(nums.length<=2)
    		return nums.length;
    	for(int i=2;i<nums.length;i++){
    		if(nums[insert-2]==nums[i]&&nums[insert-1]==nums[i]){
    			if(i==nums.length-1)
    				return insert;
    			else{
    				nums[insert]=nums[i+1];
    			}
    		}
    		else{
    			nums[insert]=nums[i];	
    			insert++;
    		}
    	}
    	
    	
        return insert;
    }

	public static void main(String[] args) {

	}

}
