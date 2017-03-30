package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num77 {
	List<List<Integer>> listlist;
    public List<List<Integer>> combine(int n, int k) {
		listlist=new ArrayList<List<Integer>>();
		newCom(n,k,1,new ArrayList<Integer>());
    	return listlist;
    }
    public void newCom(int n,int k,int from,List<Integer> list){
    	if(list.size()==k){
    		listlist.add(list);
    		return;
    	}
    	for(int i=from;i<=n;i++){
    		List<Integer> newList=new ArrayList<Integer>(list);
    		newList.add(i);
    		newCom(n,k,from+1,newList);
    	}
    	
    }
    
    
    
    
    
    
    
    public void com(List<List<Integer>> listlist,ArrayList<Integer> left,ArrayList<Integer> right,int k){
    	if(k==0)
    		listlist.add(right);
    	else{
    		ArrayList<Integer> newleft=(ArrayList<Integer>)left.clone();
	    	for(int num:left){
	    		ArrayList<Integer> newright=(ArrayList<Integer>)right.clone();
	    		newleft.remove(new Integer(num));
	    		newright.add(num);
	    		com(listlist,newleft,newright,k-1);
	    	}
    	}
    }
	public static void main(String[] args) {
		num77 sol=new num77();
		System.out.println(sol.combine(4, 2));
	}

}
