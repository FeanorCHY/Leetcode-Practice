package leedcode;

import java.util.HashMap;

public class num343 {
    public int integerBreak(int n) {
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int i=1;i<=n;i++){
    		
    		int max=i;
    		if(i==n)
    			max=-1;
    		for(int j=1;j<=i/2;j++){
    			int product=map.get(j)*map.get(i-j);
    			if(product>max){
    				max=product;
    			}
    		}
    		map.put(i, max);
    	}
        return map.get(n);
    }
	public static void main(String[] args) {
		num343 sol=new num343();
		System.out.println(sol.integerBreak(10));
	}

}
