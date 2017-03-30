package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class num402 {
    public String removeKdigits(String num, int k) {
    	if(k>=num.length())
    		return "";
    	char[] arr=num.toCharArray();
    	List<Character> list=new LinkedList<Character>();
    	for(int i=0;i<arr.length;i++)
    		list.add(arr[i]);
    	for(int step=0;step<k;step++){
    		int index=0;
    		boolean remove=false;
    		while(index<list.size()-1){
    			if(list.get(index)>list.get(index+1)){
    				list.remove(index);
    				remove=true;
    				break;
    			}
    			index++;
    		}
    		if(!remove){
    			list.remove(index);
    		}
    		while(index==0&&list.size()>1&&list.get(index)=='0')
    			list.remove(index);
    		index=Math.max(0, index-1);
    	}
    	StringBuilder sb=new StringBuilder();
    	for(Character each:list){
    		sb.append(each);
    	}
    	
    	return sb.toString();
    }
	public static void main(String[] args) {
		num402 sol=new num402();
		System.out.println(sol.removeKdigits("112", 1));
	}

}
