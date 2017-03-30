package leedcode;

import java.util.Arrays;

public class num27 {

    public int removeElement(int[] nums, int val) {
        int index1=0;
        int index2=0;
    	while(index2<nums.length){
    		if(nums[index2]!=val){
    			nums[index1]=nums[index2];
    			index1++;
    			index2++;
    		}
    		else{
    			index2++;
    		}
    	}
        return index1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num27 sol=new num27();
		int[] test={3,2,2,3};
		System.out.println(sol.removeElement(test, 3));
		System.out.println(Arrays.toString(test));
	}

}
