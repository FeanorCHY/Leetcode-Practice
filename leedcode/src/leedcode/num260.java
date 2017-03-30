package leedcode;

import java.util.Arrays;

public class num260 {

    public int[] singleNumber(int[] nums) {
    	int xor=0;
    	for(int each:nums){
    		xor=xor^each;
    	}
    	xor=xor&(~(xor-1));
    	int result[]=new int[2];
    	for(int each:nums){
    		if((each&xor)==0)
    			result[0]=result[0]^each;
    		else
    			result[1]=result[1]^each;
    	}
    	return result;
    }
	public static void main(String[] args) {
		int[] test={1, 2, 1, 3, 2, 5};
		num260 sol=new num260();
		System.out.println(Integer.toBinaryString((~5^3)));
		System.out.println(Arrays.toString(sol.singleNumber(test)));
	}

}
