package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num60 {
    public String getPermutation(int n, int k) {
    	int fac=1;
    	for(int i=2;i<n;i++){
    		fac=fac*i;
    	}
    	List<Integer> list=new ArrayList<Integer>();
    	for(int i=0;i<n;i++){
    		list.add(i+1);
    	}
    	int index=0;
    	String result="";
    	k=k-1;
    	int div=k/fac;
    	int mod=k%fac;
    	while(index<n){
    		result=result+list.remove(div);
    		index++;
    		if(index==n)
    			fac=fac/(n-index+1);
    		else
    			fac=fac/(n-index);
    		div=mod/fac;
    		mod=mod%fac;
    	}
    	return result;   
    }
	public static void main(String[] args) {
		num60 sol=new num60();
		System.out.println(sol.getPermutation(5, 3));

	}

}
