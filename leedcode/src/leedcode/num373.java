package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class num373 {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> result=new ArrayList<int[]>();
    	k=Math.min(k, nums1.length*nums2.length);
    	int index[]=new int[nums1.length];
    	for(int i=0;i<k;i++){
    		int best=0;
    		int small=Integer.MAX_VALUE;
    		for(int j=0;j<nums1.length;j++){
    			if(index[j]<nums2.length&&nums1[j]+nums2[index[j]]<small){
    				best=j;
    				small=nums1[j]+nums2[index[j]];
    			}
    		}
    		int[] arr={nums1[best],nums2[index[best]]};
    		result.add(arr);
    		index[best]++;
    	}
    	
    	
    	return result;
    }
	public static void main(String[] args) {
		int[] test1={1,1,2};
		int[] test2={1,2,3};
		num373 sol=new num373();
		for(int[] each:sol.kSmallestPairs(test1, test2, 10));
//			System.out.println(Arrays.toString(each)+"  ");
	}

}
