package leedcode;

import java.util.HashMap;

public class num291 {
	HashMap<Character,String> map=new HashMap<Character,String>();
    public boolean wordPatternMatch(String pattern, String str) {
    	if(pattern.length()==0&&str.length()==0)
    		return true;
    	else if(!(pattern.length()!=0&&str.length()!=0))
    		return false;
    	char ch=pattern.charAt(0);
    	StringBuilder sb=new StringBuilder();
    	char arr[]=str.toCharArray();
    	if(map.containsKey(ch)){
    		char[] key=map.get(ch).toCharArray();
    		for(int i=0;i<key.length;i++){
    			if(i>=arr.length||key[i]!=arr[i])
    				return false;
    		}
    		if(wordPatternMatch(pattern.substring(1),str.substring(key.length)))
    			return true;
    	}
    	else{
    		for(int i=0;i<arr.length;i++){
    			sb.append(arr[i]);
    			if(map.values().contains(sb.toString()))
    				continue;
    			map.put(ch, sb.toString());
    			if(wordPatternMatch(pattern.substring(1),str.substring(i+1)))
    				return true;
    			map.remove(ch);
    		}
    	}
        return false;
    }
	public static void main(String[] args) {
		String pat="ab";
		String test="aa";
		num291 sol=new num291();
		System.out.println(sol.wordPatternMatch(pat, test));
	}

}
