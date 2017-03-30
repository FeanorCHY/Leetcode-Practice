package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num249 {
    public List<List<String>> groupStrings(String[] strings) {
    	List<List<String>> res=new ArrayList<List<String>>();
    	HashMap<String,List<String>> map=new HashMap<String,List<String>>();
    	for(String each:strings){
    		char[] arr=each.toCharArray();
    		StringBuilder sb=new StringBuilder(arr.length);
    		for(int i=1;i<arr.length;i++){
    			sb.append(" "+(arr[i]-arr[i-1]+26)%26);
    		}
    		if(map.containsKey(sb.toString())){
    			map.get(sb.toString()).add(each);
    		}
    		else{
    			List<String> list=new ArrayList<String>();
    			list.add(each);
    			map.put(sb.toString(), list);
    			res.add(list);
    		}	
    	}
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
