package leedcode;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	StringBuilder result=new StringBuilder();
    	for(int i=0;i<strs.size();i++){
    		char[] arr=strs.get(i).toCharArray();
    		StringBuilder tem=new StringBuilder();
    		for(char ch:arr){
    			tem.append(ch);
    			if(ch=='/')
    				tem.append(ch);
    		}
    		result.append('/');
    		result.append(tem.length());
    		result.append('/');
			result.append(tem.toString());
//			tem=new StringBuilder();
    	}
    	
    	
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	List<String> list=new ArrayList<String>();
    	char[] arr=s.toCharArray();
    	for(int i=0;i<arr.length;i++){
			if(arr[i]=='/'){
				if(arr[i+1]=='/'){
					i=i+2;
				}
				else{
					i++;
					int len=0;
					while(arr[i]!='/'){
						len=len*10+arr[i]-'0';
						i++;
					}
					
					if(len==0)
						list.add("");
					else{
						list.add(s.substring(i+1,i+1+len).replace("//", "/"));
					}
					i=i+len;
				}
			}
    		
    	}
    	
        return list;
    }

}
