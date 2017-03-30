package leedcode;

import java.util.Arrays;

public class num4 {
	static int count=0;
	static int left=0;
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//    	if(nums1.length==1&&nums2.length==1)
//	    return ((double)nums1[0]+(double)nums2[0])/2;
	if(nums1.length<=1)
	{
		int[] num=new int[nums1.length+2];
		num[0]=Integer.MIN_VALUE;
		num[num.length-1]=Integer.MAX_VALUE;
		if(nums1.length==1)
			num[1]=nums1[0];
		nums1=num;
	}
	if(nums2.length<=1)
	{
		int[] num=new int[nums2.length+2];
		num[0]=Integer.MIN_VALUE;
		num[num.length-1]=Integer.MAX_VALUE;
		if(nums2.length==1)
			num[1]=nums2[0];
		nums2=num;
	}
	int median=(nums1.length+nums2.length-1)/2;
//	double m1=;
//	System.out.println(count);
//	double m2;
//	if((nums1.length+nums2.length)%2==0)
//		m2=getMedian(nums1,nums2,median+1);
//	else
//		m2=m1;
	return getMedian(nums1,nums2,median);
}
static double getMedian(int[] nums1, int[] nums2,int median)
{
	int med;
	int med1=(nums1.length-1)/2;;
	int med2=(nums2.length-1)/2;;
	int target;
	int pos=-1;
	int len1=nums1.length;
	int len2=nums2.length;
	int low1=0;
	int high1=nums1.length-1;
	int low2=0;
	int high2=nums2.length-1;
	int wPos=-1;
	while(wPos!=median)
	{
// 		count++;
        if(len1>len2)
        {
        	med=med1;
        	target=nums1[med];
        	pos=Binary(nums2,target,low2,high2);
        	wPos=pos+med+1;
        	if(wPos==median)
        	{
        		if((nums1.length+nums2.length)%2==1)
        			return (double)target;
        		else
        		{
	        		if(pos<0){
	        			if(med+1==nums1.length)
	        				return ((double)target+ nums2[0])/2;
	        			else
	        				return ((double)target+(double)Integer.min(nums1[med+1], nums2[0]))/2;
	        		}
//        			if(nums2[med]==nums1[pos])
	        		if(med+pos==(nums1.length+nums2.length-2)/2)
        				return (double)target;
        			else
        			{
        				if(med+1==nums1.length)
        					return ((double)target+(double)nums2[pos+1])/2;
        				else if(pos+1==nums2.length)
        					return ((double)target+(double)nums1[med+1])/2;
        				else
        					return ((double)target+(double)Integer.min(nums1[med+1], nums2[pos+1]))/2;
        			}
        		}
        	}
        	else if(wPos<median)
        	{
        		low1=med1+1;
        		low2=pos+1;
        	}
        	else
        	{
        		high1=med1-1;
        		high2=pos;
        	}
        }
        else
        {
        	med=med2;
        	target=nums2[med];
        	pos=Binary(nums1,target,low1,high1);
        	wPos=pos+med+1;
        	if(wPos==median)
        	{
        		if((nums1.length+nums2.length)%2==1)
        			return (double)target;
        		else
        		{
	        		if(pos<0){
	        			if(med+1==nums2.length)
	        				return ((double)target+ nums1[0])/2;
	        			else
	        				return ((double)target+(double)Integer.min(nums2[med+1], nums1[0]))/2;
	        		}
//        			if(nums2[med]==nums1[pos])
	        		if(med+pos==(nums1.length+nums2.length-2)/2)
        				return (double)target;
        			else
        			{
        				if(med+1==nums2.length)
        					return ((double)target+(double)nums1[pos+1])/2;
        				else if(pos+1==nums1.length)
        					return ((double)target+(double)nums2[med+1])/2;
        				else
        					return ((double)target+(double)Integer.min(nums2[med+1], nums1[pos+1]))/2;
        			}
        		}
        	}
        	else if(wPos<median)
        	{
        		low2=med2+1;
        		low1=pos+1;
        	}
        	else
        	{
        		high2=med2-1;
        		high1=pos;
        	}
        }
        med1=(low1+high1)/2;
        med2=(low2+high2)/2;
        len1=high1-low1+1;
        len2=high2-low2+1;
	}
	return 0;
}
static int Binary(int[] num,int target,int low,int high)
{
	if (low>high){
		return high;
	}
	int med=(low+high)/2;
	
	if(target==num[med])
		return med;
	else if(target<num[med])
		return Binary(num,target,low,med-1);
	else
		return Binary(num,target,med+1,high);
}
//    static void Seperate(int[] num1,int[] num2)
//    {
//    	double med=Median(num1,0,num1.length-1);
//    	if(med<num2[0]);
//    }
//    static double Median(int[] arr,int low,int high)
//    {
//    	return ((double)arr[low+(int)Math.floor(((double)(high-low))/2)]+(double)arr[low+(int)Math.ceil(((double)(high-low))/2)])/2;
//    }

	public static void main(String[] args) {
		int[] test1={0,1,2};
		int[] test2={0,1,2};
		
		
		System.out.println(findMedianSortedArrays(test1,test2));
//		System.out.println(test1.length+"  "+test2.length +"  "+count);
	}

}
