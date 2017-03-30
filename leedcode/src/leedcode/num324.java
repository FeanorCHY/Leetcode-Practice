package leedcode;

import java.util.Arrays;

public class num324 {
    public void wiggleSort(int[] nums) {
    	int[] copy=new int[nums.length];
    	Arrays.sort(nums);
    	int mid=(nums.length-1)/2;
    	int high=nums.length-1;
    	int k=0;
    	while(k<nums.length||mid>=0||high>(nums.length-1)/2){
    		copy[k++]=nums[mid--];
    		if(k<nums.length)
    			copy[k++]=nums[high--];
    	}
 	   for(int p=0;p<nums.length;p++)
 		   nums[p]=copy[p];
    }
	public static void main(String[] args) {
		int[] test={1,2,3,4,5};
		num324 sol=new num324();
		sol.wiggleSort(test);
		System.out.println(Arrays.toString(test));
	   
	}

}

//for(int i=0;i<nums.length-1;i++){
//	if(nums[i]==nums[i+1]){
//		for(int j=(i+2)%nums.length;j!=i;j=(j+1)%nums.length){
//			if(nums[j]!=nums[i+1]){
//				int tem=nums[j];
//				nums[j]=nums[i+1];
//				nums[i+1]=tem;
//				break;
//			}
//		}
//	}
//}
//for(int i=0;i<nums.length-1;i++){
//
//	if(nums[i]==nums[i+1]){
//		for(int j=(i+2)%nums.length;j!=i;j=(j+1)%nums.length){
//			if(nums[j]!=nums[i+1]){
//				if(j>0&&j-1!=i+1&&nums[j-1]==nums[i+1])
//					continue;
//				if(j<nums.length-1&&j+1!=i+1&&nums[j+1]==nums[i+1])
//					continue;
//				int tem=nums[j];
//				nums[j]=nums[i+1];
//				nums[i+1]=tem;
//				if(j<i){
//					if(j>0){
//			        	if(((j-1)%2==0&&nums[j-1]>nums[j])||((j-1)%2==1&&nums[j-1]<nums[j])){
//		        			int tem1=nums[j-1];
//		        			nums[j-1]=nums[j];
//		        			nums[j]=tem1;
//			        	}
//					}
//		        	if((j%2==0&&j!=nums.length-1&&nums[j]>nums[j+1])||(j%2==1&&j!=nums.length-1&&nums[j]<nums[j+1])){
//	        			int tem1=nums[j];
//	        			nums[j]=nums[j+1];
//	        			nums[j+1]=tem1;
//		        	}
//				}
//				
//				break;
//			}
//		}
//	}
//	if(i%2==0){
//		if(nums[i]>nums[i+1]){
//			int tem=nums[i];
//			nums[i]=nums[i+1];
//			nums[i+1]=tem;
//		}
//	}
//	else{
//		if(nums[i]<nums[i+1]){
//			int tem=nums[i];
//			nums[i]=nums[i+1];
//			nums[i+1]=tem;
//		}
//	}
//}