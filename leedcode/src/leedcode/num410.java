package leedcode;

public class num410 {
	int m;
	int nums[];
	public int splitArray(int[] nums, int m) {
		this.nums=nums;
		this.m=m;
		long r=0;
		long l=0;
		for(int each:nums){
			r+=each;
			l=Math.max(l, each);
		}
		while(l<=r){
			long mid=(l+r)/2;
			if(valid(mid))
				r=mid-1;
			else
				l=mid+1;
		}
		
		return (int)l;
	}
	boolean valid(long target){
		int count=1;
		int cur=0;
		for(int each:nums){
			cur+=each;
			if(cur>target){
				count++;
				cur=each;
				if(count>m)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] test={7,2,5,10,8};
		num410 sol=new num410();
		System.out.println(sol.splitArray(test, 3));
	}

}
