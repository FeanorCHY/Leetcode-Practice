package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num187 {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> list=new ArrayList<String>();
    	if(s.length()<11)
    		return list;
    	HashMap<Integer,Boolean> hm=new HashMap<Integer,Boolean>();
    	for(int i=0;i<=s.length()-10;i++){
    		String sub=s.substring(i,i+10);
    		int subInt=0;
    		char[] arr=sub.toCharArray();
    		for(int j=0;j<arr.length;j++){
    			if(arr[j]=='A')
    				subInt=subInt*10+1;
    			else if(arr[j]=='G')
    				subInt=subInt*10+2;
    			else if(arr[j]=='C')
    				subInt=subInt*10+3;
    			else if(arr[j]=='T')
    				subInt=subInt*10+4;
    		}
    		if(hm.containsKey(subInt)){
    			if(!hm.get(subInt)){
    				hm.replace(subInt, true);
    				list.add(sub);
    			}
    		}
    		else
    			hm.put(subInt,false);
    	}
    	
    	
    	
    	return list;
    	
    	
    }
	public static void main(String[] args) {
		num187 sol=new num187();
		System.out.println(sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}





//List<Integer> dup=new ArrayList<Integer>();
//List<String> list=new ArrayList<String>();
//char[] arr=s.toCharArray();
//if(arr.length<11)
//	return list;
//for(int i=0;i<=arr.length-10;i++){
//	boolean bigSucc=false;
//	if(dup.contains(i))
//		continue;
//	for(int j=i+1;j<=arr.length-10;j++){
//		boolean succ=true;
//		int index1=i;
//		int index2=j;
//		while(index2<j+10){
//			if(arr[index1]!=arr[index2]){
//				succ=false;
//				break;
//			}
//			index1++;
//			index2++;
//		}
//		if(succ==true){
//			dup.add(j);
//			if(bigSucc==false){
//				StringBuffer result=new StringBuffer();
//				for(int t=i;t<i+10;t++){
//					result.append(arr[t]);
//				}
//				list.add(result.toString());
//				bigSucc=true;
//			}
//		}
//	}
//}
//return list;