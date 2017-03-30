package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num93 {
	List<String> list;
	String input;
    public List<String> restoreIpAddresses(String s) {
    	list=new ArrayList<String>();
    	if(s.length()>12||s.length()<4)
    		return list;
    	input=s;
    	pickIP(0,0,"");
        return list;
    }
    public void pickIP(int start,int index,String IP){
    	if(index==4&&start==input.length()){
    		list.add(IP.substring(1));
    	}
    	for(int i=start+1;i<=start+3&&i<=input.length();i++){
    		String sub=input.substring(start,i);
    		int subInt=Integer.parseInt(sub);
    		if(!Integer.toString(subInt).equals(sub))
    			continue;
    		if(subInt<=255){
    			pickIP(i,index+1,IP+"."+sub);
    		}
    	}
    }
	public static void main(String[] args) {
		num93 sol=new num93();
		System.out.println(sol.restoreIpAddresses("010010"));
	}

}
