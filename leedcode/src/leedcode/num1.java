package leedcode;

import java.util.Arrays;

public class num1 {
    static int[] twoSum(int[] nums, int target) {
    	int[] tem=new int[2];
        for(int i=0;i<nums.length;i++)
        	for(int j=i+1;j<nums.length;j++)
        	{
        		if(nums[i]+nums[j]==target)
        		{
        			tem[0]=i;
        			tem[1]=j;
        			return tem;
        		}
        	}
        return tem;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test={2,7,11,15};
		System.out.println(Arrays.toString(twoSum(test,9)));
	}

}
