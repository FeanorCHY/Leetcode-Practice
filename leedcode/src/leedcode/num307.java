package leedcode;

public class num307 {

	public static void main(String[] args) {
		int[] nums={7,2,7,2,0};
		 NumArray numArray = new NumArray(nums);
		 System.out.println(numArray.sumRange(0, 2));
		 numArray.update(4, 6);
		 System.out.println(numArray.sumRange(0, 4));
		 numArray.update(0, 2);
		 numArray.update(0, 9);
		 System.out.println(numArray.sumRange(0, 4));
		 numArray.update(3, 8);
		 System.out.println(numArray.sumRange(0, 4));
		 numArray.update(4, 1);
		 System.out.println(numArray.sumRange(0, 4));
		 numArray.update(0, 4);
	}

}
