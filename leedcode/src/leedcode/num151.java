package leedcode;

import java.util.Stack;

public class num151 {
    public String reverseWords(String s) {
    	if(s==null)
    		return "";
		if(s.equals(""))
		    return s;
        char[] arr=s.toCharArray();
        String str="";
        String word="";
        for(int i=0;i<arr.length;i++){
        	if(arr[i]!=' '){
        		word=word+arr[i];
        	}
        	else{
        		if(str.equals("")&&!word.equals("")){
        			str=" "+word;
        			word="";
        		}
        		else{
        			if(!word.equals("")){
        				str=" "+word+str;
        				word="";
        			}
        		}
        	}
        }
		if(!word.equals("")){
			str=" "+word+str;
			word="";
		}

    	if(!str.equals(""))
    	    return str.substring(1);
    	else
    	    return "";
    }
	public static void main(String[] args) {
		num151 sol=new num151();
		System.out.println(sol.reverseWords(" "));
	}

}
