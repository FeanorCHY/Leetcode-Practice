package leedcode;

import java.util.HashMap;

public class num246 {
    public boolean isStrobogrammatic(String num) {
    	char[] arr=num.toCharArray();
    	HashMap<Character,Character> map=new HashMap<Character,Character>();
    	map.put('0', '0');
    	map.put('1', '1');
    	map.put('9', '6');
    	map.put('6', '9');
    	map.put('8', '8');
    	for(int i=0;i<(num.length()+1)/2;i++){
    		
    		if(!map.containsKey(arr[i])||map.get(arr[i])!=arr[arr.length-1-i])
    			return false;
    	}
    	
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
