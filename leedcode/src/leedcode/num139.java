package leedcode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class num139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	List<Integer> list=new ArrayList<Integer>();
    	for(int i=s.length()-1;i>=0;i--){
    		String sub=s.substring(i);
    		if(wordDict.contains(sub)){
    			list.add(i);
    		}
    		else{
    			for(Integer x:list){
    				if(wordDict.contains(s.substring(i, x)))
    					list.add(i);
    			}
    		}
    	}
    	if(list.isEmpty()){
    		return false;    		
    	}
    	if(list.get(list.size()-1)==0)
    		return true;
    	return false;
    }
//    public boolean find(int index){
//    	String cur="";
//    	for(int i=index;i<arr.length;i++){
//    		cur=cur+arr[i];
//    		if(dic.contains(cur)){
//    			if(i==arr.length-1)
//    				return true;
//    			if(find(i+1))
//    				return true;
//    		}
//    	}
//    	return false;
//    }
	public static void main(String[] args) {
	}

}
