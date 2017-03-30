package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num241 {
    public List<Integer> diffWaysToCompute(String input) {
    	List<Integer> result=new ArrayList<Integer>(); 
    	boolean has=false;
    	char[] arr=input.toCharArray();
    	for(int i=0;i<arr.length;i++){
    		if(arr[i]>='0'&&arr[i]<='9'){
    		}
    		else{
    			has=true;
    			if(arr[i]=='+'||arr[i]=='-'||arr[i]=='*'){
    				List<Integer> left=diffWaysToCompute(input.substring(0,i));
    				List<Integer> right=diffWaysToCompute(input.substring(i+1));
    				for(int l:left){
    					for(int r:right){
    						if(arr[i]=='+'){
    							result.add(l+r);
    						}
    						else if(arr[i]=='-'){
    							result.add(l-r);
    						}
    						else if(arr[i]=='*'){
    							result.add(l*r);
    						}
    					}
    				}
    			}
    		}
    	}
    	if(!has){
    		result.add(Integer.parseInt(input));
    	}
    	
    	return result;
    }
	public static void main(String[] args) {
		num241 sol=new num241();
		System.out.println(sol.diffWaysToCompute("2*3-4*5"));
	}

}
