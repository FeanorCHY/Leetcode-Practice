package leedcode;

import java.util.Arrays;
import java.util.HashMap;

public class num325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;  
        HashMap<Integer, Integer> map = new HashMap<>(); //key:prefix和; value:到第几个数  
        int max=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
        	sum+=nums[i];
        	int lf=sum-k;
        	if(map.containsKey(lf)){
        		max=Math.max(max,i- map.get(lf));
        	}
        	if(!map.containsKey(sum))
        		map.put(sum, i);
        }
        return max; 
    	
    }
	public static void main(String[] args) {
		int[] test={1, -1, 5, -2, 3};
		num325 sol=new num325();
		System.out.println(sol.maxSubArrayLen(test, 2));
	}

}



//int dp[]=new int[nums.length];
//int sum=0;
//for(int each:nums){
//	sum+=each;
//}
//if(sum==k)
//	return nums.length;
//dp[0]=sum;
//for(int i=1;i<nums.length;i++){
//	dp[i]=dp[i-1]-nums[i-1];
//	if(dp[i]==k)
//		return nums.length-i;
//	int last=nums.length-1;
//	for(int j=i-1;j>=0;j--){
//		dp[j]=dp[j]-nums[last--];
//		if(dp[j]==k)
//			return nums.length-i;
//	}
//}
//return 0;



//Arrays.sort(nums);
//int sum=0;
//for(int each:nums){
//	sum+=each;
//}
//if(sum==k)
//	return nums.length;
//int dif=sum-k;
//for(int i=1;i<=nums.length;i++){
//	if(i==1){
//		for(int each:nums){
//			if(each==dif)
//				return nums.length-1;
//		}
//	}
//	else{
//		int low=0;
//		int high[]=new int[i-1];
//		int index=0;
//		int subSum=nums[low];
//		for(int j=0;j<high.length;j++){
//			high[j]=nums.length-i+1+j;
//			subSum+=nums[nums.length-i+1+j];
//		}
//		if(subSum-nums[low]+nums[high[0]-1]<dif)
//			break;
//		if(subSum==dif)
//			return nums.length-i;
//		while(low<high[0]){
//			if(subSum>dif){
//				subSum-=nums[high[index]];
//				high[index]--;
//				if(low<high[0]){
//					subSum+=nums[high[index]];
//					index=(index+1)%high.length;
//				}
//				else
//					break;
//			}
//			else if(subSum<dif){
//				subSum-=nums[low];
//				low++;
//				if(low<high[0])
//					subSum+=nums[low];
//				else
//					break;
//			}
//			if(subSum==dif)
//				return nums.length-i;
//		}
//	}
//}
//
//return 0;