package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CWnode{
	char c;
	HashMap<Character,CWnode> map;
	String word=null;
	public CWnode(char c){
		this.c=c;
		map=new HashMap<Character,CWnode>();
	}
}
public class num472 {
	private void addCWnode(CWnode root,String str){
		char[] arr=str.toCharArray();
		CWnode node=root;
		for(int i=0;i<arr.length;i++){
			if(!node.map.containsKey(arr[i])){
				node.map.put(arr[i], new CWnode(arr[i]));
			}
			node=node.map.get(arr[i]);
		}
		node.word=str;
	}
	CWnode root=new CWnode('\0');
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    	List<String> res=new ArrayList<String>();
    	for(int i=0;i<words.length;i++){
    		addCWnode(root, words[i]);
    	}
    	for(int i=0;i<words.length;i++){
    		if(isConcate(root,words[i].toCharArray(),0,0))
    			res.add(words[i]);
    	}
    	
        return res;
    }
    private boolean isConcate(CWnode node,char[] arr,int index,int cur){
    	if(index==arr.length){
    		if(cur>=2)
    			return true;
    		else
    			return false;
    	}
    	for(int i=index;i<arr.length;i++){
    		if(node.map.containsKey(arr[i])){
    			node=node.map.get(arr[i]);
    			if(node.word!=null&&isConcate(root,arr,i+1,cur+1))
    				return true;
    		}
    		else
    			return false;
    	}
    	return false;
    }
	public static void main(String[] args) {
		String[] test={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		num472 sol=new num472();
		System.out.println(sol.findAllConcatenatedWordsInADict(test));
	}

}
