package leedcode;

import java.util.Arrays;

public class num384 {

	public static void main(String[] args) {
		int[] test={1,2,3,4,5,6,7,8,9,10};
		Solution384 sol=new Solution384(test);
		for(int i=0;i<10;i++)
			System.out.println(Arrays.toString(sol.shuffle()));
	}

}
