package leedcode;

import java.util.Arrays;

public class num164 {
	public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
        	min=Math.min(min, num);
        	max=Math.max(max, num);
        }
        int gap=(int)Math.ceil(((double)(max-min))/(double)(nums.length-1));
        int[] Bmax=new int[nums.length];
        int[] Bmin=new int[nums.length];
        for(int i=0;i<nums.length;i++){
        	Bmax[i]=Integer.MIN_VALUE;
        	Bmin[i]=Integer.MAX_VALUE;
        }
        for(int num:nums){
        	if(num==min||num==max)
        		continue;
        	int to=(num-min)/gap;
        	Bmax[to]=Math.max(Bmax[to], num);
        	Bmin[to]=Math.min(Bmin[to], num);
        }
        int last=min;
        int res=0;
        for(int i=0;i<nums.length;i++){
        	if(Bmax[i]==Integer.MIN_VALUE&&Bmin[i]==Integer.MAX_VALUE)
        		continue;
        	res=Math.max(res, Bmin[i]-last);
        	last=Bmax[i];
        	
        }
        res=Math.max(res, max-last);
        return res;
    }
	public static void main(String[] args) {
		int test[]={1,10000};//5,9,13,17,21//{4,1,6,8,2,3};
		num164 sol=new num164();
		System.out.println(sol.maximumGap(test));
	}

}
