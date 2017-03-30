package leedcode;

import java.util.Arrays;

public class num473 {
	int[] nums;
	int len;
	boolean[] visit;
    public boolean makesquare(int[] nums) {
    	int sum=0;
    	this.nums=nums;
    	for(int each:nums){
    		sum+=each;
    	}
    	if(sum%4!=0)
    		return false;
    	len=sum/4;
    	visit=new boolean[nums.length];
    	Arrays.sort(nums);
    	return search(0,0,0);
    }
    private boolean search(int index,int pre,int count){
    	for(int i=index;i<nums.length;i++){
    		if(visit[i])
    			continue;
    		visit[i]=true;
    		if(nums[i]+pre==len){
    			if(count==3)
    				return true;
    			else if(search(0,0,count+1))
    				return true;
        		visit[i]=false;
    				
    		}
    		else if(nums[i]+pre>len){
    			visit[i]=false;
    			return false;
    		}
    		else{
    			if(search(i,nums[i]+pre,count))
    				return true;
    			visit[i]=false;
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
		int test[]={3,3,3,3,4};
		num473 sol=new num473();
		System.out.println(sol.makesquare(test));
	}

}
