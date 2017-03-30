package leedcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class num189 {
    public void rotate(int[] nums, int k) {
    	k=k%nums.length;
    	reverse(nums,0,nums.length-1);
    	reverse(nums,0,k-1);
    	reverse(nums,k,nums.length-1);
    }
    private void reverse(int[] nums,int from,int to){
    	while(from<to){
    		int tem=nums[from];
    		nums[from]=nums[to];
    		nums[to]=tem;
    		from++;
    		to--;
    	}
    }
	public static void main(String[] args) {
		int[] test={1,2};
		num189 sol=new num189();
		sol.rotate(test, 1);
		System.out.println(Arrays.toString(test));
	}

}
