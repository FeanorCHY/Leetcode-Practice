package leedcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class num442 {
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> res=new ArrayList<Integer>();
    	int[] arr=new int[nums.length+1];
    	for(int each:nums){
    		if(arr[each]!=0)
    			res.add(each);
    		else
    			arr[each]=each;
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
