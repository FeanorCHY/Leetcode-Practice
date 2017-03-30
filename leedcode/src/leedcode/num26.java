package leedcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class num26 {
    public static int removeDuplicates(int[] nums) {
    	if(nums.length==1)
    		return 1;
        int unique=1;
        int uniIndex=1;
    	for(int i=1;i<nums.length;i++)
        {
        	if(nums[i]!=nums[i-1]){
        		unique++;
        		if(i!=uniIndex)
        		    nums[uniIndex]=nums[i];
        		uniIndex++;
        	}
        }
    	return unique;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,3,4,5,5,5,6,7,7,7};
		System.out.println(removeDuplicates(arr));
		System.out.println(Arrays.toString(arr));
	}

}
