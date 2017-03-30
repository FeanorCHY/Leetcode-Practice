package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    	List<List<Integer>> listlist=new ArrayList<List<Integer>>();
    	List<Integer> list=new ArrayList<Integer>();
    	for(int k:candidates)
    	{
    		list.add(k);
    	}
    	List<Integer> right=new ArrayList<Integer>();
    	listlist=per(list,right,target,0,listlist);
    	return listlist;
    }
    public List<List<Integer>> per(List<Integer> left,List<Integer> right,int target,int sum,List<List<Integer>> listlist){
		List<Integer> left2=new ArrayList<Integer>();
		left2.addAll(left);
    	for(Integer candi:left){
    		if(left2.contains(candi)){
	    		if(sum+candi==target){
	    	    	List<Integer> newright=new ArrayList<Integer>();
	//    	    	List<Integer> newleft=new ArrayList<Integer>();
	//    	    	newleft.remove(candi);
	    	    	newright.addAll(right);
	    	    	newright.add(candi);
	    	    	listlist.add(newright);
	    		}
	    		else if(sum+candi<target){
	    	    	List<Integer> newright=new ArrayList<Integer>();
	    	    	List<Integer> newleft=new ArrayList<Integer>();
	    	    	newright.addAll(right);
	    	    	newleft.addAll(left2);
	    	    	newleft.remove(candi);
	    	    	newright.add(candi);
	    	    	listlist=per(newleft,newright,target,sum+candi,listlist);
	    			
	    		}
	    		else{
	    			left2.remove(candi);
	    		}
	    		while(left2.contains(candi))
	    			left2.remove(candi);
    		}
    	}
    	return listlist;
    }
    
	public static void main(String[] args) {
		num40 sol=new num40();
		int[] test={1,1};
		System.out.println(sol.combinationSum2(test, 1));
//		List<Integer> list=new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(2);
//		Integer x=2;
//		list.remove(x);
//		list.remove(x);
//		System.out.println(list);
		
	}

}
