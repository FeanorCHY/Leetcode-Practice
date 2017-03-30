package leedcode;

public class num300 {
	public int lengthOfLIS(int[] nums) {
	    int len = 0;
	    int[] a = new int[nums.length];
	    for(int val : nums) {
	        int index = binary(a, 0, len - 1, val);
	        a[index] = val;
	        // 说明这个数字是新加进去这个数组的
	        if(len == index) len ++;
	    }
	    return len;
	}

	// 相当于在left-right的区间内找到val的插入位置。保证升序；
	public int binary(int[] a, int left, int right, int val) {
	    while(left <= right) {
	        int mid = getMid(left, right);
	        if(a[mid] >= val) {
	            right = mid - 1;
	        }
	        // 相等也要替换这个值;
	        else {
	            left = mid + 1;
	        }
	    }
	    return left;
	}
	public int getMid(int left, int right) {
	    return left + (right - left) / 2;
	}
	public static void main(String[] args) {
		int test[]={10,9,2,5,3,7,101,18};
		num300 sol=new num300();
		System.out.println(sol.lengthOfLIS(test));
	}

}



//int step[]=new int[nums.length];
//if(nums.length<=1)
//	return nums.length;
//step[0]=1;
//int g=1;//=Integer.MIN_VALUE
//for(int i=1;i<nums.length;i++){
//	int max=Integer.MIN_VALUE;
//	step[i]=1;
//	for(int j=0;j<i;j++){
//		if(nums[j]<nums[i]&&step[j]+1>max)
//			max=step[j]+1;
//	}
//	if(max>0)
//		step[i]=max;
//	if(max>g)
//		g=max;
//}
//
//
//return g;