package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class num277 {

    HashMap<Integer,Set<Integer>> arr=new HashMap<Integer,Set<Integer>>();
    public int findCelebrity(int n) {
    	HashSet<Integer> li=new HashSet<Integer>();
		li.add(1);
		arr.put(0,li);li=new HashSet<Integer>();
		li.add(0);
		arr.put(1,li);
    	if(n<=1)
    		return -1;
    	int[] no=new int[n];
    	int[] yes=new int[n];
    	int[] acq=new int[n];
    	for(int i=0;i<n;i++){
//    		if(no[i]>0)
//    			continue;
    		for(int j=0;j<n;j++){
    			if(no[i]>0&&no[j]>0){
    				continue;
    			}
    			if(i==j)
    				continue;
    			if(knows(i,j)){
    				yes[j]++;
    				acq[i]++;
    			}
    			else
    				no[j]++;
    		}
    	}
    	for(int i=0;i<n;i++){
    		if(acq[i]==0&&yes[i]==n-1)
    			return i;
    	}
    	return -1;
    }
    
    public boolean knows(int a,int b){
    	if(arr.get(a).contains(b))
    		return true;
    	else 
    		return false;
    }
	public static void main(String[] args) {
		num277 sol=new num277();
		System.out.println(sol.findCelebrity(2));
	}

}




//Set<Integer> s=new HashSet<Integer>();
//Set<Integer> can=new HashSet<Integer>();
//Set<Integer> s2=new HashSet<Integer>();
//for(int i=0;i<n;i++){
//	if(s2.contains(i))
//		continue;
//	boolean acq=false;
//	for(int j=0;j<n;j++){
//	    if(i==j)
//	        continue;
//		if(!knows(i,j))
//		{
//			s2.add(j);
//		}
//		else 
//			acq=true;
//	}
//	if(acq){
//		s.add(i);
//	}
//	else
//		can.add(i);
//	if(s2.size()+s.size()==n)
//		return -1;
//}
//for(int each:can){
//	boolean acq=false;
//	for(int each2:s2){
//		if(knows(each2,each)){
//			acq=true;
//			break;
//		}
//		if(acq==false)
//			return each;
//	}
//}