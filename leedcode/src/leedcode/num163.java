package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	List<String> list =new ArrayList<String>();
    	
        if(nums.length==0){
        	if(lower!=upper){
	        	list.add(lower+"->"+upper);
        	}
        	else{
        		list.add(lower+"");
        	}
    		return list;
        }
        if(nums[0]>lower)
        	if((long)nums[0]-(long)lower==1)
        		list.add(lower+"");
        	else if((long)nums[0]-(long)lower>1)
        		list.add(lower+"->"+(nums[0]-1));
        if(nums.length==1){
        	if((long)upper-(long)nums[0]==1)
        		list.add(upper+"");
        	else if((long)upper-(long)nums[0]>1)
        		list.add((nums[0]+1)+"->"+upper);
    		return list;
        }
        	
        for(int i=1;i<nums.length;i++){
        	if((long)nums[i]-(long)nums[i-1]>1){
        		if((long)nums[i]-(long)nums[i-1]==2)
        			list.add((nums[i-1]+1)+"");
        		else
        			list.add((nums[i-1]+1)+"->"+(nums[i]-1));
        	}
        }

    	if((long)upper-(long)nums[nums.length-1]==1)
    		list.add(upper+"");
    	else if((long)upper-(long)nums[nums.length-1]>1)
    		list.add((nums[nums.length-1]+1)+"->"+upper);
    	
    	return list;
    }
	public static void main(String[] args) {
		int test[]={-1};
		num163 sol=new num163();
		System.out.println(sol.findMissingRanges(test, -1, 0));
	}

}
