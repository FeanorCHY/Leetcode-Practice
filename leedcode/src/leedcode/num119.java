package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num119 {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res=new ArrayList<Integer>();
		res.add(1);
    	if(rowIndex==1){
    		res.add(1);
    		return res;
    	}
    	long num=1;
    	long idx=1;
    	while(rowIndex>=1){
    		num=num*(long)rowIndex/idx;
    		idx++;
    		rowIndex--;
    		res.add((int)num);
    	}
    	
    	
        return res;
    }
	public static void main(String[] args) {
		num119 sol=new num119();
		System.out.println(sol.getRow(4));
	}

}
