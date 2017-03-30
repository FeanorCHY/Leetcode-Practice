package leedcode;

import java.util.Arrays;

public class num453 {
	int[] nums;
    public int minMoves(int[] nums) {
    	int min=Integer.MAX_VALUE;
    	for(int each:nums){
    		min=Math.min(each, min);
    	}
    	int res=0;
    	for(int each:nums){
    		res+=each-min;
    	}
        return res;
    }
	public static void main(String[] args) {
		num453 sol=new num453();
		int[] test={1,2,3};
		System.out.println(sol.minMoves(test));
	}

}
