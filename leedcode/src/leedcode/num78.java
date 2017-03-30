package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num78 {
    public List<List<Integer>> subsets(int[] nums) {
    	ArrayList<List<Integer>> listlist=new ArrayList<List<Integer>>();
    	for(int num:nums){
    		List<List<Integer>> tem=new ArrayList<List<Integer>>();
    		for(List<Integer> list:listlist){
    			tem.add(new ArrayList<Integer>(list));
    		}
    		for(List<Integer> list:tem){
    			list.add(new Integer(num));
    		}
    		List<Integer> temList=new ArrayList<Integer>();
    		temList.add(new Integer(num));
    		tem.add(temList);
    		listlist.addAll(tem);
    	}
    	listlist.add(new ArrayList<Integer>());
    	return listlist;
    }
	public static void main(String[] args) {
		num78 sol=new num78();
		int[] test={1,2};
		System.out.println(sol.subsets(test));

	}

}
