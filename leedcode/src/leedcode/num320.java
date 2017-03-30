package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num320 {
	List<String> list =new ArrayList<String>();
    public List<String> generateAbbreviations(String word) {
    	
    	build(word,"");
    	list.add(word);//itself
        return list;
    }
    public void build(String word,String built){
    		
    	for(int i=1;i<=word.length();i++){
    		for(int j=0;j<=word.length()-i;j++){
    			
    			if(j+i<word.length()){
    		    	if(word.substring(j+i+1).equals("")){
    		    		list.add(built+word.substring(0,j)+i+word.substring(i+j, i+j+1));
    		    	}
    		    	else{
        				list.add(built+word.substring(0,j)+i+word.substring(j+i));
    		    		build(word.substring(j+i+1),built+word.substring(0,j)+i+word.substring(i+j, i+j+1));
		    		}
    			}
    			else
    				list.add(built+word.substring(0,j)+i);
    		}
    	}
    }
	public static void main(String[] args) {
		num320 sol=new num320();		
//		System.out.println("word".substring(3));

		System.out.println(sol.generateAbbreviations("wold"));

	}

}
