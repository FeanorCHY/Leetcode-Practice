package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class num90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

    	ArrayList<List<Integer>> listlist=new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	int count=1;
    	for(int num:nums){
    		List<List<Integer>> tem=new ArrayList<List<Integer>>();
    		for(List<Integer> list:listlist){
    			tem.add(new ArrayList<Integer>(list));
    		}
    		boolean con=false;
			List<Integer> inTem=new ArrayList<Integer>();
			inTem.add(num);
			if(listlist.contains(inTem)){
				con=true;
				for(int i=1;i<count;i++)
					inTem.add(num);
				count++;
			}
			else
				count=1;

			String inString=inTem.toString();
			inString=inString.substring(1,inString.length()-1);
    		for(List<Integer> list:tem){
    			if(con){
    				String listStr=list.toString();
	    			if(listStr.contains(inString)){
	    				list.add(new Integer(num));
	    			}
	    			else
	    				listlist.remove(list);
    			}
    			else{
    				list.add(new Integer(num));
    			}
    		}
    		List<Integer> temList=new ArrayList<Integer>();
    		temList.add(new Integer(num));
    		if(!con)
    			tem.add(temList);
    		listlist.addAll(tem);
    	}
    	listlist.add(new ArrayList<Integer>());
    	return listlist;
    }
	public static void main(String[] args) {
		num90 sol=new num90();
		int test[]={2,1,2,2};
		System.out.println(sol.subsetsWithDup(test));

	}

}
