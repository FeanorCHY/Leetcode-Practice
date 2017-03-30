package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class num49 {

    public List<List<String>> groupAnagrams(String[] strs) {
    	HashMap<String,List<String>> hs=new HashMap<String,List<String>>();
    	for(int i=0;i<strs.length;i++)
    	{
        	char[] char1=strs[i].toCharArray();
        	Arrays.sort(char1);
        	String st1=new String(char1);
        	if(hs.containsKey(st1)){
        		List<String> temlist=hs.get(st1);
        		temlist.add(strs[i]);
        	}
        	else{
        		List<String> newlist=new ArrayList<String>();
        		newlist.add(strs[i]);
        		hs.put(st1, newlist);
        	}
    	}
    	List<List<String>> listlist=new ArrayList<List<String>>(hs.values());
    	return listlist;
    	
    	
    }

//	List<List<String>> listlist=new ArrayList<List<String>>();
//	if(strs.length==0)
//		return null;
//	List<String> list=new ArrayList<String>();
//	char[] char1=strs[0].toCharArray();
//	Arrays.sort(char1);
//	String st1=new String(char1);
//	if(strs.length==1){
//    	list.add(strs[0]);
//		listlist.add(list);
//		return listlist;
//	}
//	list.add(st1);
//	list.add(strs[0]);
//	listlist.add(list);
//	for(int i=1;i<strs.length;i++)
//	{
//		boolean find=true;
//		for(int j=0;j<listlist.size()&&find;j++){
//			List<String> each=listlist.get(j);
//			if(isGram(each.get(0),strs[i])){
//				each.add(strs[i]);
//				find=false;
//			}
//		}
//		if(find==true){
//	    	char[] char2=strs[i].toCharArray();
//	    	Arrays.sort(char2);
//	    	String tem=new String(char2);
//			List<String> newlist=new ArrayList<String>();
//			newlist.add(tem);
//			newlist.add(strs[i]);
//			listlist.add(newlist);
//		}	
//	}
//	for(List<String> each:listlist){
//		each.remove(0);
//	}
//    return listlist;
//    public boolean isGram(String str1,String str2){
//    	if(str1.length()!=str2.length())
//    		return false;
//    	char[] char2=str2.toCharArray();
//    	Arrays.sort(char2);
//    	String st2=new String(char2);
//    	if(str1.equals(st2))
//    		return true;
//    	else{
//    		return false;
//    	}
////    	list.toArray(char1);
////    	if(str1.length()!=str2.length())
////    		return false;
////    	if(str1.length()==0&&str2.length()==0)
////    		return true;
////    	for(int i=0;i<str1.length();i++)
////    	{
////    		if((str1.substring(i,str1.length())+str1.substring(0,i)).equals(str2))
////    			return true;
////    	}
////    	return false;
//    }
	public static void main(String[] args) {
		num49 sol = new num49();
		String[] test={"tea","and","ate","eat","dan"};
		List<List<String>> listlist=sol.groupAnagrams(test);
		System.out.println(listlist);

	}

}
