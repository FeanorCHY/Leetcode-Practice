package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class num39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> listlist=new ArrayList<List<Integer>>();
    	List<Integer> list=new ArrayList<Integer>();
    	HashSet<List<Integer>> hs= new HashSet<List<Integer>>();
    	listlist=find(candidates,target,0,list,listlist,hs);
        return listlist;
    }
    public List<List<Integer>> find(int[] candidates,int target,int sum,List<Integer> list,List<List<Integer>> listlist,HashSet<List<Integer>> hs){
    	for(int candi:candidates){
    		boolean ok=true;
    		if(!list.isEmpty()){
    			if(list.get(list.size()-1)<=candi){
    				ok=true;
    			}
    			else
    				ok=false;
    		}
    		if(ok){
	    		if(sum+candi==target){
	    			List<Integer> newlist=new ArrayList<Integer>();
	    			newlist.addAll(list);
	    			newlist.add(candi);
	//    			Collections.sort(newlist);
	//    			if(!hs.contains(newlist)){
	    				listlist.add(newlist);
	//;    				hs.add(newlist);
	//    			}
	    		}
	    		else if(sum+candi<target){
	//    			list.
	    			List<Integer> newlist=new ArrayList<Integer>();
	    			newlist.addAll(list);
	    			newlist.add(candi);
	//    			Collections.sort(newlist);
	//    			if(!hs.contains(newlist)){
	//    				hs.add(newlist);
	        			listlist=find(candidates,target,sum+candi,newlist,listlist,hs);
	//    			}
	    		}
    		}
    		
    	}
    	return listlist;
    }
	public static void main(String[] args) {
		num39 sol=new num39();
		int[] test={2,3,6,7};
		System.out.println(sol.combinationSum(test, 7));
//		ArrayList<Integer> list1=new ArrayList<Integer>();
//		list1.add(1);
//		list1.add(3);
//		list1.add(2);
//		ArrayList<Integer> list2=new ArrayList<Integer>();
//		list2.add(1); 
//		list2.add(2);
//		list2.add(3);
////		Collections.sort(list1);
//		HashSet<ArrayList<Integer>> hs=new HashSet<ArrayList<Integer>>();
//		hs.add(list1);
//		hs.add(list2);
//		System.out.println(hs);
	}

}
