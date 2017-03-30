package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class num392 {
    public boolean isSubsequence(String s, String t) {
    	HashMap<Character,List<Integer>> map=new HashMap<Character,List<Integer>>();
//    	HashMap<Character,Integer> index=new HashMap<Character,Integer>();
    	char[] tarr=t.toCharArray();
    	for(int i=0;i<tarr.length;i++){
    		if(map.containsKey(tarr[i])){
    			map.get(tarr[i]).add(i);
    		}
    		else{
    			List<Integer> tem=new ArrayList<Integer>();
    			tem.add(i);
    			map.put(tarr[i], tem);
    		}
    	}
    	char[] arr=s.toCharArray();
    	int last=-1;
    	for(int i=0;i<arr.length;i++){
    		if(!map.containsKey(arr[i]))
    			return false;
    		List<Integer> tem=map.get(arr[i]);
    		if(last==-1){
    			last=tem.get(0);
    		}
    		else{
    			int index=bsearch(tem,last);
    			if(index==tem.size())
    				return false;
    			last=tem.get(index);
    		}
    		
    	}
    	
    	return true;
    }
    public int bsearch(List<Integer> nums, int target){
    	int high=nums.size()-1;
    	int low=0;
    	int mid=(low+high)/2;
    	while(low<=high){
    		if(nums.get(mid)<target){
    			low=mid+1;
    		}
    		else if(nums.get(mid)>target)
    			high=mid-1;
    		else
    			return mid+1;
    		mid=(low+high)/2;
    	}
    	return low;
    }
	public static void main(String[] args) {
		num392 sol=new num392();
		System.out.println(sol.isSubsequence("aabas", "yyyyyyyayyyyyyayyyyyyybyyyyyyayyyyysyyyyyyy"));

	}

}
