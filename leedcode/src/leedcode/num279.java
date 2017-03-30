package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class num279 {
    public int numSquares(int n) {
    	if(n==0)
    		return 0;
//    	HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();  
    	TreeSet<Integer> keys=new TreeSet<Integer>();
        int sq=(int)Math.sqrt(n);
        if(sq*sq==n)
        	return 1;
        for(int i=1;i<=sq;i++){
        	keys.add(i*i);
        }
        for(int i=2;i<=n-sq*sq+1;i++){
        	TreeSet<Integer> tem=new TreeSet<Integer>();
        	for(int j=sq;j>=1;j--){
        		for(Integer key:keys){
        			if(key+j*j>n)
        				break;
        			else if(key+j*j==n)
        				return i;
        			else{
        				tem.add(key+j*j);
        			}
        		}
        	}
        	keys=tem;
        }
        return 0;
    }
	public static void main(String[] args) {
		num279 sol=new num279();
		System.out.println(sol.numSquares(12));
	}

}
