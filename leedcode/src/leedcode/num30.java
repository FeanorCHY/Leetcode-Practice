package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num30 {
    public List<Integer> findSubstring(String s, String[] words) {
    	HashMap<String,Integer> map=new HashMap<String,Integer>();
    	HashMap<String,Integer> cur=new HashMap<String,Integer>();
    	List<Integer> result=new ArrayList<Integer>();
    	if(words.length==0||s.length()==0)
    		return result;
    	int len=words[0].length();
    	for(String each:words){
    		if(map.containsKey(each))
    			map.put(each, map.get(each)+1);
    		else
    			map.put(each,1);
    	}
    	
    	for(int i=0;i<len;i++){
    		int left=i;
    		int count=0;
    		for(int j=i;j<=s.length()-len;j+=len){
    			String sub=s.substring(j,j+len);
    			if(map.containsKey(sub)){
					count++;
    				if(cur.containsKey(sub))
    					cur.put(sub, cur.get(sub)+1);
    				else
    					cur.put(sub, 1);
    				if(cur.get(sub)>map.get(sub)){
    					while(cur.get(sub)>map.get(sub)){
    						String tem=s.substring(left,left+len);
							count--;
    						cur.put(tem, cur.get(tem)-1);
    						left+=len;
    					}
    				}
    				else if(count==words.length){
    						result.add(left);
    						String tem=s.substring(left,left+len);
    						cur.put(tem,cur.get(tem)-1);
    						count--;
    						left+=len;
    				}
    			}
    			else{
    				left=j+len;
    				cur.clear();
    				count=0;
    			}
    		}
    		cur.clear();
    	}
    	
    	return result;
    	
    }
	public static void main(String[] args) {
		num30 sol=new num30();
		String test[]={"word","good","best","good"};
		System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", test));
	}

}
