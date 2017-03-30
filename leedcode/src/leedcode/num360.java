package leedcode;

import java.util.Arrays;

public class num360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    	int result[]=new int[nums.length];
    	if(a==0){
    		if(b==0){
    			for(int i=0;i<nums.length;i++){
    				result[i]=c;
    			}
    		}
    		if(b>0){
    			for(int i=0;i<nums.length;i++){
    				result[i]=b*nums[i]+c;
    			}
    		}
    		else{
    			int index=0;
    			for(int i=nums.length-1;i>=0;i--){
    				result[i]=b*nums[index++]+c;
				}
    		}
    	}
    	double mid=-((double)b/(double)(2*a));
    	int right=nums.length-1;
    	for(int i=0;i<nums.length;i++){
    		if((double)nums[i]>=mid){
    			right=i;
    			break;
    		}
    	}
    	if(a>0){
    		int index=0;
    		int left=right-1;
    		while(left>=0||right<=nums.length-1){
    			if(left<0){
    				result[index++]=nums[right++];
    			}
    			else if(right>nums.length-1){
    				result[index++]=nums[left--];
    			}
    			else if(mid-(double)nums[left]>(double)nums[right]-mid){
    				result[index++]=nums[right++];
    			}
    			else{
    				result[index++]=nums[left--];
    			}
    			result[index-1]=result[index-1]*result[index-1]*a+b*result[index-1]+c;
    		}
    	}
    	else if(a<0){

    		int index=nums.length-1;
    		int left=right-1;
    		while(left>=0||right<=nums.length-1){
    			if(left<0){
    				result[index--]=nums[right++];
    			}
    			else if(right>nums.length-1){
    				result[index--]=nums[left--];
    			}
    			else if(mid-(double)nums[left]>(double)nums[right]-mid){
    				result[index--]=nums[right++];
    			}
    			else{
    				result[index--]=nums[left--];
    			}
    			result[index+1]=result[index+1]*result[index+1]*a+b*result[index+1]+c;
    		}
    	}
    	
    	
        return result;
    }
	public static void main(String[] args) {
		int test[]={-4, -2, 2, 4};
		num360 sol=new num360();
		System.out.println(Arrays.toString(sol.sortTransformedArray(test, 1, 3, 5)));
	}

}
