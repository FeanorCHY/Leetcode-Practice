package leedcode;

public class num53 {
    public int maxSubArray(int[] nums) {
    	int largest=Integer.MIN_VALUE;
    	
    	for(int i=0;i<nums.length;i++){
	    	if(nums[i]>largest)
	    		largest=nums[i];
    	}
    	int sum_max=0;
    	int sum_now=0;
    	for(int i=0;i<nums.length;i++)
    	{
    		sum_now=sum_now+nums[i];
    		if(sum_now<0)
    			sum_now=0;
    		if(sum_max<sum_now)
    			sum_max=sum_now;
    	}
    	if(sum_max==0)
        	return largest;
    	return sum_max;
    }
	public static void main(String[] args) {
		num53 sol=new num53();
		int[] test={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(sol.maxSubArray(test));
	}

}

//int sum=0;
//if(nums.length==1){
//	return nums[0];
//}
//int largest=Integer.MIN_VALUE;
//for(int i=0;i<nums.length;i++){
//	sum=sum+nums[i];
//	if(nums[i]>largest)
//		largest=nums[i];
//}
//int low=0;
//int high=nums.length-1;
//int indexLow=low;
//int indexHigh=high;
//int sumLow=nums[low];
//int sumHigh=nums[high];
//while(indexLow<=indexHigh){
//	if(sumLow<0&&sumHigh<0){
//		if(sumLow<sumHigh){
//			indexLow++;
//			low=indexLow;
//			sum=sum-sumLow;
//			if(indexLow<=nums.length-1)
//				sumLow=nums[low];
//		}
//		else{
//			indexHigh--;
//			high=indexHigh;
//			sum=sum-sumHigh;
//			if(indexHigh>=0)
//				sumHigh=nums[high];
//		}
//	}
//	else if(sumLow<0){
//		indexLow++;
//		low=indexLow;
//		sum=sum-sumLow;
//		sumLow=nums[low];
//	}
//	else if(sumHigh<0){
//		indexHigh--;
//		high=indexHigh;
//		sum=sum-sumHigh;
//		sumHigh=nums[high];
//	}
//	else{
//		indexHigh--;
//		indexLow++;
//		if(indexLow<=nums.length-1)
//			sumLow=sumLow+nums[indexLow];
//		if(indexHigh>=0)
//			sumHigh=sumHigh+nums[indexHigh];
//	}
//}
//if(low>=high||sum<largest)
//	return largest;
//
//return sum;