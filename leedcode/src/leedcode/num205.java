package leedcode;

import java.util.HashMap;

public class num205 {
    public boolean isIsomorphic(String s, String t) {
    	HashMap<Character, Integer> map=new HashMap<Character, Integer>();
    	if(s.length()!=t.length())
    		return false;
    	char[] arrs=s.toCharArray();
    	char[] arrt=t.toCharArray();
    	int[] arr=new int[arrs.length];
    	for(int i=0;i<arrs.length;i++){
    		if(map.containsKey(arrs[i])){
    			arr[i]=map.get(arrs[i]);
    		}
    		else{
    			arr[i]=map.size();
    			map.put(arrs[i], map.size());
    			
    		}
    	}
    	map.clear();
    	for(int i=0;i<arrt.length;i++){
    		if(map.containsKey(arrt[i])){
    			if(map.get(arrt[i])!=arr[i])
    				return false;
    		}
    		else{
    			if(arr[i]!=map.size())
    				return false;
    			map.put(arrt[i], map.size());
    		}
    	}
    	
        return true;
    }
	public static void main(String[] args) {
		num205 sol=new num205();
		System.out.println(sol.isIsomorphic("aa", "ab"));
	}

}
