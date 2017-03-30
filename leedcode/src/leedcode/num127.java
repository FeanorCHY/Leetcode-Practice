package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num127 {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	int path=2;
    	wordList.remove(beginWord);
    	ArrayList<String> linked=new ArrayList<String>();
    	Set<String> searched=new HashSet<String>();
    	linked.add(beginWord);
    	while(!linked.isEmpty()){
	    	for(String each:linked){
	    		char[] arr=each.toCharArray();
	    		for(int i=0;i<each.length();i++){
	    			char tem=arr[i];
		    		for(int j='a';j<'z';j++){
		    			arr[i]=(char)j;
		    			String arrStr=new String(arr);
		    			if(arrStr.equals(endWord))
		    				return path;
		    			else if(wordList.contains(arrStr)){
		    				searched.add(arrStr);
		    				wordList.remove(arrStr);
		    			}
		    		}
		    		arr[i]=tem;
	    		}
	    	}
			linked.clear();
			linked.addAll(searched);
			searched.clear();
			path++;
    	}
    	
    	
    	return 0;
    }
    
    public boolean similar(String str1,String str2){
    	if(str1.equals(str2))
    		return false;
    	if(str1.length()==1)
    		return true;
    	for(int i=0;i<str1.length();i++){
    		String str1sub1=str1.substring(0,i);
    		String str1sub2=str1.substring(i+1,str1.length());
    		String str2sub1=str2.substring(0,i);
    		String str2sub2=str2.substring(i+1,str2.length());
    		if(str1sub1.equals(str2sub1)&&str1sub2.equals(str2sub2))
    			return true;
    		if(!str1sub1.equals(str2sub1)&&!str1sub2.equals(str2sub2))
    			return false;
    	}
    	return false;
    }
	public static void main(String[] args) {
//		char[] k={'1','r','e'};
//		System.out.println(new String(k));
		String test[]={"hot","dot","dog","lot","log"};
		Set<String> wordList=new HashSet<String>(Arrays.asList(test));
		num127 sol=new num127();
		System.out.println(sol.ladderLength("hit", "cog", wordList));
		
	}

}



//wordList.add(endWord);
//ArrayList<String> linked=new ArrayList<String>();
//int path=1;
//linked.add(beginWord);
//wordList.remove(beginWord);
//while(linked.size()!=0){
//	path++;
//	Set<String> temSet=new HashSet<String>();
//	while(!linked.isEmpty()){
//		String tem=linked.remove(0);
//		for(String str:wordList){
//			if(similar(tem,str)){
//				temSet.add(str);
//			}
//		}
//		wordList.removeAll(temSet);
//		if(temSet.contains(endWord))
//			return path; 
//	}
//	wordList.removeAll(temSet);
//	linked.addAll(temSet);
//}
//return 0;
