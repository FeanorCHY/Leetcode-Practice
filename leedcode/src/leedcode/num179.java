package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class num179 {
    public String largestNumber(int[] nums) {
    	List<String> list=new ArrayList<String>();
    	for(int each:nums){
    		list.add(Integer.toString(each));
    	}
    	Collections.sort(list,new Comparator<String>(){
    		@Override
    		public int compare(String str1,String str2){
    			if(!str1.substring(0,1).equals(str2.substring(0,1)))
    				return str1.compareTo(str2);
    			else{
    				return (str1+str2).compareTo(str2+str1);
//    				if(str1.length()>str2.length()){
//    					String str=str2;
//    					for(int i=0;i<str1.length()-str2.length();i++){
//    						str=str+str2.substring(0,1);
//    					}
//    					return str1.compareTo(str);
//    				}
//    				else if(str1.length()<str2.length()){
//						String str=str1;
//						for(int i=0;i<str2.length()-str1.length();i++){
//							str=str+str1.substring(0,1);
//						}
//						return str.compareTo(str2);
//    				}
//    				else
//    					return str1.compareTo(str2);
    			}
    		}
    	});
    	boolean begin=false;
    	String result="";
    	for(int i=list.size()-1;i>=0;i--){
    		if(begin==true)
    			result=result+list.get(i);
    		else if(begin==false&&!list.get(i).equals("0")){////////
    			result=result+list.get(i);/////////
    			begin=true;//////////
    		}
    	}
    	
    	if(result=="")////////
    		return "0";//////
    	return result;
    }
	public static void main(String[] args) {
		int[] test={12,121};
		num179 sol=new num179();
		System.out.println(sol.largestNumber(test));
		

	}

}
