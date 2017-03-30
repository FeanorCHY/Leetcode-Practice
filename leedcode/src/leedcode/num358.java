package leedcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num358 {
    public String rearrangeString(String str, int k) {
    	char[] arr=str.toCharArray();
    	if(k<=1)
    		return str;
	    int[] count=new int[26];
	    int[] next=new int[26];
	    for(int i=0;i<arr.length;i++){
    		count[arr[i]-'a']++;
    	}
	    StringBuilder sb=new StringBuilder();
	    for(int i=0;i<arr.length;i++){
	    	int max=0;
	    	int pos=-1;
	    	for(int j=0;j<count.length;j++){
	    		if(count[j]>max&&i>=next[j]){
	    			max=count[j];
	    			pos=j;
	    		}
	    	}
	    	if(pos==-1)
	    		return "";
	    	next[pos]=i+k;
	    	count[pos]--;
	    	sb.append((char)(pos+'a'));
	    }
	    
	    
    	return sb.toString();
    }
	public static void main(String[] args) {
		num358 sol=new num358();
		System.out.println(sol.rearrangeString("aaabbcc", 3));
	}

}
