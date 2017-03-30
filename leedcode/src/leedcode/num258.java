package leedcode;

import java.util.HashMap;

public class num258 {
    public int addDigits(int num) {
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	while(num>9){
    		int cur=num%100;
    		if(map.containsKey(cur)){
    			num=num/100+map.get(cur);
    		}
    		else{
	    		while(cur>9){
	    			cur=cur/10+cur%10;
	    		}
	    		num=num/100+cur;
    		}
    	}
        return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
