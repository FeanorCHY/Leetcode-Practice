package leedcode;

public class num169 {

    public int majorityElement(int[] nums) {
    	int count=1;
    	int num=nums[0];
    	for(int i=1;i<nums.length;i++){
    		if(num==nums[i])
    			count++;
    		else{
    			if(count>0)
    				count--;
    			else{
    				count=1;
    				num=nums[i];
    			}
    		}
    	}
    	
        return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
