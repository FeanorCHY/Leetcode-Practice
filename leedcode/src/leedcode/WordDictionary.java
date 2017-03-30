package leedcode;

import java.util.LinkedList;
import java.util.List;

class TrieNode2 {
    // Initialize your data structure here.
	char content;
	List<TrieNode2> list;
	List<Character> charList;
	boolean end;
    public TrieNode2() {
    	list=new LinkedList<TrieNode2>();
    	charList=new LinkedList<Character>();
    	content=0;
    	end=false;
    }
}

public class WordDictionary {

    private TrieNode2 root;
    public WordDictionary() {
        root = new TrieNode2();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] arr=word.toCharArray();
        TrieNode2 node=root;
        for(int i=0;i<arr.length;i++){
        	if(!node.charList.contains(arr[i])){
	        	node.charList.add(arr[i]);
	        	TrieNode2 newNode=new TrieNode2();
	        	newNode.content=arr[i];
	        	node.list.add(newNode);
	        	node=newNode;
        	}
        	else{
        		node=node.list.get(node.charList.indexOf(arr[i]));
        	}
        }
        node.end=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	char[] arr=word.toCharArray();
    	TrieNode2 node=root;
    	
    	
//    	for(int i=0;i<arr.length;i++){
//    		if(!node.charList.contains(arr[i])&&arr[i]!='.')
//    			return false;
//    		else{
//    			if(arr[i]!='.')
//    				node=node.list.get(node.charList.indexOf(arr[i]));
//    		}
//    	}

    	return subSearch(arr,0,node);
    }
    public boolean subSearch(char[] word,int index,TrieNode2 node) {
    	if(!node.charList.contains(word[index])&&word[index]!='.')
    		return false;
    	else{
    		if(word[index]!='.'){
    			TrieNode2 node2=node.list.get(node.charList.indexOf(word[index]));
    			if(index==word.length-1){
    				if(node2.end)
    					return true;
    				else
    					return false;
    			}
    			else
    				return subSearch(word,index+1,node2);
    		}
    		else{
    			if(index==word.length-1){
        			for(TrieNode2 each:node.list){
        				if(each.end)
        					return true;
        			}
        			return false;
    			}
    			for(TrieNode2 each:node.list){
    				if(subSearch(word,index+1,each))
    					return true;
    			}
    			return false;
    		}
    		
    	}
    }
}
