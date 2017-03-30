package leedcode;

import java.util.HashMap;
import java.util.HashSet;

public class ValidWordAbbr {
	HashMap<String,HashSet<String>> map=new HashMap<String,HashSet<String>>();
    public ValidWordAbbr(String[] dictionary) {
        for(String word:dictionary){
        	String tran=word.length()<=2?word:(""+word.charAt(0)+(word.length()-2)+word.charAt(word.length()-1));
        	if(map.containsKey(tran)){
        		map.get(tran).add(tran);
        	}
        	else{
        		HashSet<String> tem=new HashSet<String>();
        		tem.add(word);
        		map.put(tran, tem);
        	}
        }
    }

    public boolean isUnique(String word) {
    	String tran=word.length()<=2?word:(""+word.charAt(0)+(word.length()-2)+word.charAt(word.length()-1));
    	HashSet<String> set=map.get(tran);
    	if(set==null)
    		return true;
    	else if(set.size()==1&&set.contains(word))
    		return true;
    	else
    		return false;
    }
}
