package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class num321 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] res=new int[k];
		for(int i=Math.max(k-nums2.length,0);i<=Math.min(nums1.length,k);i++){
			int[] tem=merge(getArr(nums1,i),getArr(nums2,k-i));
			if(greater(tem,0,res,0))
				res=tem;
		}
		
		return res;
	}
	private int[] merge(int[] nums1,int[] nums2){
		int[] res=new int[nums1.length+nums2.length];
		int s1=0;
		int s2=0;
		for(int i=0;i<res.length;i++){
			if(s1==nums1.length)
				res[i]=nums2[s2++];
			else if(s2==nums2.length)
				res[i]=nums1[s1++];
			else{
				res[i]=greater(nums1,s1,nums2,s2)?nums1[s1++]:nums2[s2++];
			}
		}
		return res;
	}
	private boolean greater(int[] nums1,int s1,int[] nums2,int s2){
		while(s1<nums1.length&&s2<nums2.length&&nums1[s1]==nums2[s2]){
			s1++;
			s2++;
		}
		if(s1==nums1.length)
			return false;
		else if(s2==nums2.length)
			return true;
		else if(nums1[s1]>nums2[s2])
			return true;
		else
			return false;
		
	}
	private int[] getArr(int[] nums,int count){
		int res[]=new int[count];
		int ridx=0;
		for(int i=0;i<nums.length;i++){
			while(nums.length-i>count-ridx&&ridx>0&&res[ridx-1]<nums[i])
				ridx--;
			if(ridx<res.length)
				res[ridx++]=nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test1={3, 4, 6, 5};
		int[] test2={9, 1, 2, 5, 8, 3};
//		int[] test1={1,2};
//		int[] test2={};
		num321 sol=new num321();
		System.out.println(Arrays.toString(sol.maxNumber(test1, test2, 6)));
	}

}

//public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//    int n = nums1.length;
//    int m = nums2.length;
//    int[] ans = new int[k];
//    for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
//        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
//        if (greater(candidate, 0, ans, 0)) ans = candidate;
//    }
//    return ans;
//}
//private int[] merge(int[] nums1, int[] nums2, int k) {
//    int[] ans = new int[k];
//    for (int i = 0, j = 0, r = 0; r < k; ++r)
//        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
//    return ans;
//}
//public boolean greater(int[] nums1, int i, int[] nums2, int j) {
//    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
//        i++;
//        j++;
//    }
//    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
//}
//public int[] maxArray(int[] nums, int k) {
//    int n = nums.length;
//    int[] ans = new int[k];
//    for (int i = 0, j = 0; i < n; ++i) {
//        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) 
//        	j--;
//        if (j < k) 
//        	ans[j++] = nums[i];
//    }
//    return ans;
//}


//
//int[] nums1;
//int[] nums2;
//public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//	this.nums1=nums1;
//	this.nums2=nums2;
//	Stack<Integer> st1=new Stack<Integer>();
//	Stack<Integer> st2=new Stack<Integer>();
//	ArrayList<Integer>[] list1=new ArrayList[10];
//	ArrayList<Integer>[] list2=new ArrayList[10];
//	for(int i=0;i<10;i++){
//		list1[i]=new ArrayList<Integer>();
//		list2[i]=new ArrayList<Integer>();
//	}
//	for(int i=0;i<nums1.length;i++){
//		list1[nums1[i]].add(i);
//	}
//	for(int i=0;i<nums2.length;i++){
//		list2[nums2[i]].add(i);
//	}
//	int idx1=0;
//	int idx2=0;
//	ArrayList<Integer> res=new ArrayList<Integer>(k);
////	Stack<Integer> pos=new Stack<Integer>();
////	boolean res[]=new boolean[nums1.length+nums2.length];
//	for(int i=0;i<k;i++){
//		int max1=-1;
//		int max2=-1;
//		if(idx1<nums1.length)
//			max1=getMax(list1,idx1);
//		if(idx2<nums2.length){
//			max2=getMax(list2,idx2);
//		}
//		if(max2<0&&max1<0){
//			idx1=!st1.isEmpty()?st1.pop():0;
//			idx2=!st2.isEmpty()?st2.pop():0;
//			i--;
//		}
//		else if(max1<0){
//			res[max2+nums1.length]=true;
//			st2.push(idx2);
//			idx2=max2;
//			list2[nums2[max2]].remove(new Integer(max2));
//		}
//		else if(max2<0){
//			res[max1]=true;
//			st1.push(idx1);
//			idx1=max1;
//			list1[nums1[max1]].remove(new Integer(max1));
//		}
//		else{
//			if(nums1[max1]>nums2[max2]){
//				res[max1]=true;
//    			st1.push(idx1);
//    			idx1=max1;
//    			list1[nums1[max1]].remove(new Integer(max1));
//			}
//			else{
//				res[max2+nums1.length]=true;
//    			st2.push(idx2);
//    			idx2=max2;	
//    			list2[nums2[max2]].remove(new Integer(max2));
//			}
//		}		
//	}
//	int[] out=new int[k];
//	int idx=0;
//	for(int i=0;i<res.length;i++){
//		if(res[i])
//			out[idx++]=(i>=nums1.length?nums2[i-nums1.length]:nums1[i]);
//			
//	}
//	return out;
//}
//public int getMax(ArrayList<Integer>[] list,int index){
//	for(int i=9;i>=0;i--){
//		int pos=list[i].size()-1;
//		if(pos==-1)
//			continue;
//		for(int j=0;j<list[i].size();j++){
//			if(list[i].get(j)>=index){
//				return list[i].get(j);
//			}
//		}
//	}
//	return -1;
//}