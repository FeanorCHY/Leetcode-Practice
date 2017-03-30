package leedcode;

import java.util.HashMap;

public class num409 {
    public int longestPalindrome(String s) {
    	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    	char[] arr=s.toCharArray();
    	for(char each:arr){
    		map.put(each, map.getOrDefault(each, 0)+1);
    	}
    	int res=0;
    	int plus=0;
    	for(int each:map.values()){
    		if(each%2==1)
    			plus=1;
    		res+=(each/2)*2;
    	}
    	
        return res+plus;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
