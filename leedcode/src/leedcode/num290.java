package leedcode;

import java.util.HashMap;
import java.util.HashSet;

public class num290 {
    public boolean wordPattern(String pattern, String str) {
    	char[] arr1=pattern.toCharArray();
    	char[] arr2=str.toCharArray();
    	HashMap<Character, String> map=new HashMap<Character, String>();
    	HashSet<String> set=new HashSet<String>();
    	int idx=0;
    	for(int i=0;i<arr1.length;i++){
    		if(map.containsKey(arr1[i])){
    			char[] tem=map.get(arr1[i]).toCharArray();
    			for(char c:tem){
    				if(idx>=arr2.length||c!=arr2[idx++])
    					return false;
    			}
    			if(idx<arr2.length&&arr2[idx]!=' ')
    				return false;
    			idx++;
    		}
    		else{
    			if(idx>=arr2.length)
    				return false;
    			StringBuilder sb=new StringBuilder();
    			while(idx<arr2.length&&arr2[idx]!=' '){
    				sb.append(arr2[idx++]);
    			}
    			idx++;
    			if(set.contains(sb.toString()))
    				return false;
    			set.add(sb.toString());
    			map.put(arr1[i], sb.toString());
    		}
    	}
    	if(idx<arr2.length)
    		return false;
    	
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
