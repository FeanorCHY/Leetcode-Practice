
public class num644 {
    //sliding failed
	//  public double findMaxAverage(int[] nums, int k) {
	//      if(nums==null||nums.length==0||k>nums.length)
	//          return -1.0;
	//      if(nums.length==100&&k==70)
	//          return 47.05882352941177;
	//      double avg=0;
	//      int idx=0;
	//      if(k<=0)
	//          k=1;
	//      for(;idx<k;idx++)
	//          avg+=nums[idx]*1.0;
	//      double sum=avg;
	//      avg/=k*1.0;
	//      int left=0;
	//      double tail=sum,res=avg;
	//      while(idx<nums.length){
	//          sum+=nums[idx]*1.0;
	//          tail+=nums[idx]*1.0;
	//          tail-=nums[idx-k]*1.0;
	//          while(idx-left>=k&&nums[left]*1.0<sum/((idx-left+1)*1.0))
	//              sum-=nums[left++]*1.0;
	//          if(tail/(k*1.0)>sum/((idx-left+1)*1.0)){
	//              sum=tail;
	//              left=idx-k+1;
	//          }
	//          res=Math.max(res,sum/((idx-left+1)*1.0));
	//          idx++;
	//      }
	//      return res;
	//  }
	//  public double findMaxAverage2(int[] nums, int k) {
	//  	double res=Integer.MIN_VALUE;
	//  	for(int i=0;i<=nums.length-k;i++){
	//  		double sum=0;
	//  		for(int j=i;j<nums.length;j++){
	//  			sum+=nums[j]*1.0;
	//  			if(j-i+1>=k)
	//  				res=Math.max(res, sum/((j-i+1)*1.0));
	////    			if(sum/((j-i+1)*1.0)==47.05882352941177)
	////    				System.out.println("i: "+i+" j: "+j);
	//  		}
	//  	}
	//  	return res;
	//  }
	 
	 
	 //Binary Search Time O(nlogMax)
	 public double findMaxAverage(int[] nums, int k) {
	     if(nums==null||nums.length==0||k>nums.length)
	         return -1.0;
	     double l=Integer.MIN_VALUE,r=Integer.MAX_VALUE;
	     while(r-l>0.00001){
	         double mid=(l+r)/2;
	         if(check(nums,k,mid))
	             l=mid;
	         else
	             r=mid;
	     }
	     return r;
	 }
	 private boolean check(int[] nums,int k,double x){
	     double[] avgs=new double[nums.length];
	     for(int i=0;i<nums.length;i++){
	         avgs[i]=nums[i]*1.0-x;
	     }
	     double cur=0,tail=0;
	     for(int i=0;i<nums.length;i++){
	         cur+=avgs[i];
	         if(i>=k-1){
	             if(cur>=0)
	                 return true;
	             tail+=avgs[i-k+1];
	             if(tail<0){
	                 cur-=tail;
	                 tail=0;
	             }
	         }
	     }
	     return false;
	 }
	public static void main(String[] args) {
		int[] test
			={1,12,-5,-6,50,3};
//			={65,91,27,13,3,39,78,76,0,60,27,63,36,36,47,75,38,93,35,53,71,51,5,17,72,57,90,14,20,62,53,37,6,80,2,9,71,80,38,24,40,65,39,77,53,87,4,44,32,40,49,4,43,6,73,15,63,15,81,35,78,34,24,84,67,26,45,90,6,83,66,99,1,6,76,6,45,32,50,29,72,99,33,15,5,6,82,21,74,15,56,52,50,81,88,69,7,85,59,66};
//			={1,12,-5,-6,50,3};
		num644 sol=new num644();
		System.out.println(sol.findMaxAverage(test, 4));
	}

}
