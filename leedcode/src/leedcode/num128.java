package leedcode;

import java.util.HashMap;

public class num128 {
    public int longestConsecutive(int[] nums) {
    	int max=1;
    	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		hm.put(nums[i], 0);
    	}
    	for(int i=0;i<nums.length;i++){
    		if(hm.get(nums[i])==0){
    			int count=1;
    			while(hm.get(nums[i]-count)!=null&&hm.get(nums[i]-count)!=-1){
    				hm.put(nums[i]-count, -1);
    				count++;
    			}
    			int count2=1;
    			while(hm.get(nums[i]+count2)!=null&&hm.get(nums[i]+count2)!=-1){
    				hm.put(nums[i]+count2, -1);
    				count2++;
    			}
    			hm.put(nums[i], count+count2-1);
    			max=Math.max(max, count+count2-1);
    		}
    	}
//    	for(int i=0;i<nums.length;i++){
//    		if(hm.containsKey(nums[i]-1)){
//    			hm.put(nums[i],hm.get(nums[i]-1)+1);
//    			max=Math.max(max, hm.get(nums[i]-1)+2);
//    		}
//    	}
    	return max;
    }
	public static void main(String[] args) {
		num128 sol=new num128();
		int[] test={4,2,2,-4,0,-2,4,-3,-4,-4,-5,1,4,-9,5,0,6,-8,-1,-3,6,5,-8,-1,-5,-1,2,-9,1};
		System.out.println(sol.longestConsecutive(test));
	}

}
