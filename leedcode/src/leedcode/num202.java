package leedcode;

import java.util.HashSet;

public class num202 {
    public boolean isHappy(int n) {
    	HashSet<Integer> set=new HashSet<Integer>();
    	while(n!=1){
    		if(set.contains(n))
    			return false;
    		set.add(n);
    		char[] arr=Integer.toString(n).toCharArray();
    		int next=0;
    		for(char c:arr){
    			next+=(c-'0')*(c-'0');
    		}
    		n=next;
    	}

    	
    	
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
