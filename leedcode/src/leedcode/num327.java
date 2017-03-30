package leedcode;

public class num327 {
	long lower;
	long upper;
	long sums[];
	public int countRangeSum(int[] nums, int lower, int upper) {
		this.lower=lower;
		this.upper=upper;
		sums=new long[nums.length+1];
		for(int i=0;i<nums.length;i++){
			sums[i+1]=sums[i]+nums[i];
		}
		return mergecount(0,sums.length);
	}
	private int mergecount(int begin,int end){
		if(end-begin<=1)
			return 0;
		int mid=(begin+end)/2;
		int count=mergecount(begin,mid)+mergecount(mid,end);
		int low=mid;
		int high=mid;
		int pos=mid;
		int idx=0;
		long[] cache=new long[end-begin];
		for(int i=begin;i<mid;i++){
			while(low<end&&sums[low]-sums[i]<lower)
				low++;
			while(high<end&&sums[high]-sums[i]<=upper)
				high++;
			while(pos<end&&sums[pos]<sums[i])
				cache[idx++]=sums[pos++];
			cache[idx++]=sums[i];
			count+=high-low;
		}
		for(int i=0;i<idx;i++){
			sums[begin++]=cache[i];
		}
		return count;
	}

	public static void main(String[] args) {
		int[] test={2147483647,-2147483648,-1,0};//{1,2,5,6,7};
		num327 sol=new num327();
		System.out.println(sol.countRangeSum(test, -1,0));
	}

}




//public int countRangeSum(int[] nums, int lower, int upper) {
//    int n = nums.length;
//    long[] sums = new long[n + 1];
//    for (int i = 0; i < n; ++i)
//        sums[i + 1] = sums[i] + nums[i];
//    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
//}
//
//private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
//    if (end - start <= 1) 
//    	return 0;
//    int mid = (start + end) / 2;
//    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
//              + countWhileMergeSort(sums, mid, end, lower, upper);
//    int j = mid, k = mid, t = mid;
//    long[] cache = new long[end - start];
//    for (int i = start, r = 0; i < mid; ++i) {
//        while (k < end && sums[k] - sums[i] < lower) 
//        	k++;
//        while (j < end && sums[j] - sums[i] <= upper) 
//        	j++;
//        while (t < end && sums[t] < sums[i]) 
//        	cache[r++] = sums[t++];
//        cache[r++] = sums[i];
//        count += j - k;
//    }
//    System.arraycopy(cache, 0, sums, start, t - start);
//    return count;
//}



//public int countRangeSum(int[] nums, int lower, int upper) {
//	int count=0;
//	for(int i=0;i<nums.length;i++){
//		long sum=0;
//		for(int j=i;j<nums.length;j++){
//			sum+=nums[j];
//			if(sum>=(long)lower&&sum<=(long)upper)
//				count++;
//		}
//	}
//	return count;
//}
