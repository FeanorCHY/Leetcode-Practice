package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
	HashMap<String,List<Integer>> ht=new HashMap<String,List<Integer>>(); 
    public WordDistance(String[] words) {
    	for(int i=0;i<words.length;i++){
    		if(ht.containsKey(words[i])){
    			ht.get(words[i]).add(i);
    		}
    		else{
    			List<Integer> list=new ArrayList<Integer>();
    			list.add(i);
    			ht.put(words[i], list);
    		}	
    	}
    }

    public int shortest(String word1, String word2) {
    	List<Integer> list1=ht.get(word1);
    	List<Integer> list2=ht.get(word2);
    	int shor=Integer.MAX_VALUE;
    	int i1=list1.get(0);
		int i2=list2.get(0);
		int index1=1;
		int index2=1;
    	while(true){
    		if(i1>i2){
    			if(shor>i1-i2)
    				shor=i1-i2;
    			if(index2==list2.size())
    				break;
    			i2=list2.get(index2++);
    		}
    		else{
    			if(shor>i2-i1)
    				shor=i2-i1;
    			if(index1==list1.size())
    				break;
    			i1=list1.get(index1++);
    		}
    	}
    	return shor;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//for(int i=1;i<words.length;i++){
//	for(int j=0;j<words.length-i;j++){
//		if(!words[j+i].equals(words[j])){
//			String word=words[j].compareTo(words[j+i])>0?words[j]+"-"+words[j+i]:words[j+i]+"-"+words[j];
//			if(!ht.containsKey(word))
//			{
//				ht.put(word, i);
//			}
//		}
//	}
//}