package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> res=new ArrayList<Integer>();
    	for(int i=0;i<nums.length;i++){
    		int x=nums[i];
    		while(x!=-1&&nums[x-1]!=x){
    			int tem=nums[x-1];
    			nums[x-1]=x;
    			x=tem;
    		}
    	}

    	for(int i=0;i<nums.length;i++){
    		if(nums[i]!=i+1)
    			res.add(i+1);
    	}
    	
        return res;
    }
	public static void main(String[] args) {
		int[] test={4,3,2,7,8,2,3,1};
		num448 sol=new num448();
		System.out.println(sol.findDisappearedNumbers(test));
	}

}
