package leedcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class num220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //input check  
        if(k<1 || t<0 || nums==null || nums.length<2) return false;  
          
        SortedSet<Long> set = new TreeSet<Long>();  
        for(int i=0;i<nums.length;i++){
        	SortedSet<Long> subSet=set.subSet((long)nums[i]-t, (long)nums[i]+t+1);
        	if(!subSet.isEmpty()) return true;
        	if(i>=k)
        		set.remove((long)nums[i-k]);
        	set.add((long)nums[i]);
        }
        return false;
    }
	public static void main(String[] args) {
		num220 sol=new num220();
		int test[]={2,3,6,8,7,9,0,1,2};
		System.out.println(sol.containsNearbyAlmostDuplicate(test, 2, 1));
	}

}

//if(nums.length==0)
//	return false;
//if(nums.length==1)
//// 		if(t!=0)
//		return false;
//// 		else
//// 			return true;
//if(k==0)
//    if(t==0)
//        return true;
//    else
//        return false;
//long dif[]=new long[nums.length-1];
//for(int i=0;i<nums.length-1;i++){
//	dif[i]=(long)nums[i]-(long)nums[i+1];
//	if(Math.abs(dif[i])<=t)
//		return true;
//}
//boolean prune[]=new boolean[nums.length-1];
//long dif2[]=dif.clone();
//for(int i=2;i<=Math.min(k, nums.length-1);i++){
//	for(int j=0;j<nums.length-i;j++){
//		if((dif[j]>0&&dif2[j+1]>0)||(dif[j]<0&&dif2[j+1]<0)){
//			prune[j]=true;
//		}
//		else{
//			if(!prune[j+1]){
//    			dif2[j]=dif[j]+dif2[j+1];
//    			if(Math.abs(dif2[j])<=t)
//    				return true;
//			}
//		}
//	}
//}
//
//return false;