package leedcode;

import java.util.HashMap;

public class num387 {
    public int firstUniqChar(String s) {
    	char[] arr=s.toCharArray();
    	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    	for(char each:arr){
    		map.put(each, map.getOrDefault(each, 0)+1);
    	}
    	for(int i=0;i<arr.length;i++){
    		if(map.get(arr[i])==1)
    			return i;
    	}
    	
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
