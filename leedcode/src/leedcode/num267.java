package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num267 {
	List<String> list= new ArrayList<String>();
	String mid="";
	public List<String> generatePalindromes(String s) {
    	char[] arr=s.toCharArray();
    	int xor=0;
    	for(char ch:arr){
    		xor^=ch;
    	}
    	if(xor!=0){
	    	int find=0;
	    	for(char ch:arr){
	    		if(ch==xor){
	    			find++;
	    		}
	    	}
	    	if(find==0||find%2==0)
	    		return list;
	    	int pos=s.indexOf((char)xor);
	    	String newS=s.substring(0,pos)+s.substring(pos+1, s.length());
	    	arr=newS.toCharArray();
	    	mid=(char)xor+"";
    	}
		Arrays.sort(arr);
		char arr2[]=new char[arr.length/2];
		for(int i=0;i<arr2.length;i++){
			arr2[i]=arr[i*2];
		}
		build(new String(arr2),"");
        return list;
    }
    public void build(String str,String built){
    	if(str.length()==0)
    		list.add(built+mid+new StringBuilder(built).reverse().toString());
    	char[] arr=str.toCharArray();
    	for(int i=0;i<arr.length;i++){
    		if(i!=0&&arr[i]==arr[i-1]){
    			continue;
    		}
    		build(str.substring(0,i)+str.substring(i+1,str.length()),built+arr[i]);
    	}
    }

	public static void main(String[] args) {
		num267 sol=new num267();
		System.out.println(sol.generatePalindromes("aaa"));
	}

}
