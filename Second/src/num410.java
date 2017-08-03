
public class num410 {

    //search by possible average failed
//  public int splitArray(int[] nums, int m) {
//      if(nums==null||m<=0||nums.length==0)
//          return 0;
//		long[] sums=new long[nums.length];
//		sums[0]=nums[0];
//		for(int i=1;i<sums.length;i++)
//			sums[i]=(long)sums[i-1]+(long)nums[i];
//      long avg=sums[sums.length-1];
//      if(avg%m!=0)
//      	avg=avg/m+1;
//      else
//      	avg=avg/m;
//      return (int)search((long)0,0,nums,avg,m,sums);
//  }
//  private long search(long cur,int idx,int[] nums,long avg,int rest,long[] sums){
//      if(idx==nums.length){
//          if(rest==0)
//              return cur;
//          else
//              return Integer.MAX_VALUE;
//      }
//      else if(rest==0)
//          return Integer.MAX_VALUE;
//      long offset=idx==0?0:sums[idx-1];
//      int pos=Bsearch(idx,sums,avg+offset);
//      long sum=pos==-1?0:sums[pos]-offset;
//      pos++;
     
//      return Math.min(search(Math.max(cur,sum),pos,nums,avg,rest-1,sums),(pos<nums.length&&sum<=avg)?search(Math.max(cur,sum+nums[pos]),pos+1,nums,avg,rest-1,sums):Integer.MAX_VALUE);
//  }
//  private int Bsearch(int l,long[] sums,long target){
//  	int r=sums.length-1;
//  	while(l<=r){
//  		int mid=(l+r)/2;
//  		if(target<sums[mid])
//  			r=mid-1;
//  		else
//  			l=mid+1;
//  	}
//  	return r;
//  }
 
 //Binary Search Time O(nlogSum) Space O(1)
 // public int splitArray(int[] nums, int m) {
 //     if(nums==null||m<=0||nums.length==0)
 //         return 0;
 //     long sum=0,max=0;
 //     for(int each:nums){
 //         sum+=(long)each;
 //         max=Math.max(max,(long)each);
 //     }
 //     if(m==1)
 //         return (int)sum;
 //     long l=max,r=sum;
 //     while(l<=r){
 //         long mid=(l+r)/2;
 //         if(valid(mid,nums,m))
 //             r=mid-1;
 //         else
 //             l=mid+1;
 //     }
 //     return (int)l;
 // }
 // private boolean valid(long target,int[] nums,int m){
 //     int count=1;
 //     long sum=0;
 //     for(int each:nums){
 //         if(sum+(long)each>target){
 //             count++;
 //             if(count>m)
 //                 return false;
 //             sum=(long)each;
 //         }
 //         else
 //             sum+=(long)each;
 //     }
 //     return count<=m;
 // }
 
 
 
	//dynamic programming Time O(n^3) spcae O(n)
	public int splitArray(int[] nums, int m)
	{
   if(nums==null||m<=0||nums.length==0)
 	  return 0;
   int[] sums=new int[nums.length+1];
   int dp[]=new int[nums.length];
   for(int i=0;i<nums.length;i++){
 	  sums[i+1]=sums[i]+nums[i];
   }
   for(int i=0;i<dp.length;i++){
 	  dp[i]=sums[sums.length-1]-sums[i];
   }
   for(int cut=1;cut<m;cut++){
 	  for(int i=0;i<nums.length-cut;i++){
 		  dp[i]=Integer.MAX_VALUE;
 		  for(int j=i;j<nums.length-cut;j++){
 			  int t=Math.max(dp[j+1], sums[j+1]-sums[i]);
 			  if(t<=dp[i])
 				  dp[i]=t;
 			  else
 				  break;
 		  }
 	  }
   }
   return dp[0];
	}
  
	public static void main(String[] args) {
		num410 sol=new num410();
		int[] test
//			={10,2,3};
//			={1,Integer.MAX_VALUE};
			={10,5,13,4,8,4,5,11,14,9,16,10,20,8};
//			={7,6,5,4,3,2,1};
//			={7,2,5,10,8};
		System.out.println(sol.splitArray(test, 8));
	}

}
