package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num89 {

    public List<Integer> grayCode(int n) {
    	List<Integer> list=new ArrayList<Integer>();
    	list.add(0);
    	int add=1;
    	for(int i=0;i<n;i++){
    		for(int j=list.size()-1;j>=0;j--){
    			list.add(list.get(j)+add);
    		}
			add=add<<1;
    	}
        return list;
    }
	public static void main(String[] args) {
		num89 sol=new num89();
		System.out.println(sol.grayCode(2));
	}

}
