package leedcode;

import java.util.Arrays;

public class num259 {
    public int threeSumSmaller(int[] nums, int target) {
    	Arrays.sort(nums);
    	int count=0;
    	for(int i=0;i<nums.length-2;i++){
    		if(nums[i]+nums[i+1]+nums[i+2]>=target)
    			break;
    		int largest=nums.length-1;
    		for(int j=i+1;j<=nums.length-2;j++){
    			if(nums[i]+nums[j]+nums[j+1]>=target)
    				break;
    			if(nums[i]+nums[j]+nums[largest]<target)
    				count=count+largest-j;
    			else{
    				largest=Bsearch(j+1,largest-1,nums,target-nums[i]-nums[j]-1);
    				count=count+largest-j;
    			}
    		}
    	}
    	return count;
    }
    public int Bsearch(int low,int high,int nums[],int target){
    	int mid=(low+high)/2;
    	while(low<=high){
    		if(nums[mid]>target){
    			high=mid-1;
    		}
    		else if(nums[mid]<target){
    			low=mid+1;
    		}
    		else{
    	    	while(mid<=high){
    	    		if(nums[mid+1]==nums[mid])
    	    			mid++;
    	    		else
    	    			break;
    	    	}
    			return mid;
			}
    		mid=(low+high)/2;
    	}
    	while(high<=nums.length-1){
    		if(nums[high+1]==nums[high])
				high++;
    		else
    			break;
    	}
    	return high;
    }
    
	public static void main(String[] args) {
		int test[]={3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1};
		num259 sol=new num259();
		System.out.println(sol.threeSumSmaller(test, 3));
	}

}
