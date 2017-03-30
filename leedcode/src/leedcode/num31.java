package leedcode;

import java.util.Arrays;

public class num31 {
    public void nextPermutation(int[] nums) {
    	if(nums.length<=1)
    		return;
    	int index=nums.length-2;
    	int tail=nums[index+1];
        while(index!=0&&nums[index]>=tail){
        	tail=nums[index];
        	for(int i=index;i<nums.length-1;i++){
        		nums[i]=nums[i+1];
        	}
        	nums[nums.length-1]=tail;
        	index--;
        }
        int change=index;
        while(change!=nums.length&&nums[change]<=nums[index]){
        	change++;
        }
        if(change==nums.length)
        {
        	int tem=nums[index];
        	for(int i=0;i<nums.length-1;i++){
        		nums[i]=nums[i+1];
        	}
        	nums[nums.length-1]=tem;
        }
        else{
        	int tem=nums[index];
        	nums[index]=nums[change];
        	nums[change]=tem;
        }
        
    }

	public static void main(String[] args) {
		num31 sol=new num31();
		int[] test={5,1,1};
		sol.nextPermutation(test);
		System.out.println(Arrays.toString(test));
	}

}
