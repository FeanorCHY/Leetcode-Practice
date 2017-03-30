package leedcode;

public class num238 {
    public int[] productExceptSelf(int[] nums) {
    	int product=1;
    	int zero=-1;
    	int zero2=-1;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]!=0)
    			product=product*nums[i];
    		else{
    			if(zero==-1)
    				zero=i;
    			else
    				zero2=i;
    		}
    	}
    	int[] result=new int[nums.length];
    	if(zero2!=-1){
    		return result;
    	}
    	if(zero!=-1){
    		result[zero]=product;
    		return result;
    	}
    	for(int i=0;i<result.length;i++){
			result[i]=product/nums[i];
    	}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
