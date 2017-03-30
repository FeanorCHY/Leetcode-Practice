package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num228 {
    public List<String> summaryRanges(int[] nums) {
    	List<String> list=new ArrayList<String>();
    	if(nums.length==0)
    		return list;
    	if(nums.length==1){
    		list.add(nums[0]+"");
    		return list;
    	}
    	int last=nums[0];
    	for(int i=1;i<nums.length;i++){
    		if(i==nums.length-1){
    			if(nums[i]-nums[i-1]==1){
    				list.add(last+"->"+nums[i]);
    			}
    			else{
        			if(last!=nums[i-1])
        				list.add(last+"->"+nums[i-1]);
        			else
        				list.add(last+"");
        			list.add(nums[i]+"");
        			return list;
    			}
    		}
    		if(nums[i]-nums[i-1]==1)
    			continue;
    		else{
    			if(last!=nums[i-1])
    				list.add(last+"->"+nums[i-1]);
    			else
    				list.add(last+"");
    			last=nums[i];
    		}
    	}
    	
    	return list;
    }
	public static void main(String[] args) {
		int[] test={1,3};
		num228 sol=new num228();
		System.out.println(sol.summaryRanges(test));
	}

}
