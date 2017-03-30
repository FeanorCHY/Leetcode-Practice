package leedcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class num318 {
    public int maxProduct(String[] words) {
    	int longest=Integer.MIN_VALUE;
    	if(words.length<2)
    		return 0;
    	for(int i=0;i<words.length;i++){
    		char[] arr=words[i].toCharArray();
    		Arrays.sort(arr);
    		words[i]=new String(arr);
    	}
    	int[] bit=new int[words.length];
		int[] index=new int[words.length];
    	for(char ch='a';ch<='z';ch++){
    		for(int i=0;i<words.length;i++){
    			bit[i]<<=1;
    			if(index[i]<words[i].length()&&words[i].charAt(index[i])==ch){
    				bit[i]++;
    				while(index[i]<words[i].length()&&words[i].charAt(index[i])==ch)
    					index[i]++;
    			}
    		}
    	}
    	for(int i=0;i<words.length-1;i++){
    		for(int j=i+1;j<words.length;j++){
	    		if((bit[i]&bit[j])==0){
	    			int product=words[i].length()*words[j].length();
	    			if(product>longest)
	    				longest=product;
	    		}
    		}
    	}
    	if(longest<0)//not found
    		return 0;
    	
        return longest;
    }
	public static void main(String[] args) {
		String[] test={"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
		num318 sol=new num318();
		System.out.println(sol.maxProduct(test));
//		for(int i=0;i<=26;i++)
//			System.out.println(1<<i);
	}

}

//for(int i=0;i<words.length-1;i++){
//	for(int j=i+1;j<words.length;j++){
//		String str1=words[i];
//		String str2=words[j];
//		boolean suc=true;
//		for(char ch='a';ch<='z';ch++){
//			if(str1.contains(ch+"")&&str2.contains(ch+"")){
//				suc=false;
//				break;
//			}
//		}
//		if(suc==true){
//			if(str1.length()*str2.length()>longest)
//				longest=str1.length()*str2.length();
//		}
//		
//	}
//}
//
//if(longest<0)//not found
//	return 0;