package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num254 {
	List<List<Integer>> listlist=new ArrayList<List<Integer>>(); 
    public List<List<Integer>> getFactors(int n) {
    	
    	
    	find(1,n,new ArrayList<Integer>());
    	return listlist;
        
    }
    public void find(int last,int n,List<Integer> list){
    	for(int i=Math.max(2,last);i<=Math.sqrt(n);i++){
    		if(n%i==0){
    			List<Integer> tem=new ArrayList<Integer>(list);
    			tem.add(i);
    			find(i,n/i,new ArrayList<Integer>(tem));
    			tem.add(n/i);
    			listlist.add(tem);
    		}
    	}
    }
	public static void main(String[] args) {
		num254 sol=new num254();
		System.out.println(sol.getFactors(64));
	}

}
