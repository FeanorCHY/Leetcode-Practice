package leedcode;

import java.util.LinkedList;
import java.util.List;

class TrieNode {
    // Initialize your data structure here.
	char content;
	List<TrieNode> list;
	List<Character> charList;
	boolean end;
    public TrieNode() {
    	list=new LinkedList<TrieNode>();
    	charList=new LinkedList<Character>();
    	content=0;
    	end=false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] arr=word.toCharArray();
        TrieNode node=root;
        char ch=arr[0];
        for(int i=0;i<arr.length;i++){
        	if(!node.charList.contains(arr[i])){
	        	node.charList.add(arr[i]);
	        	TrieNode newNode=new TrieNode();
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	char[] arr=word.toCharArray();
    	TrieNode node=root;
    	for(int i=0;i<arr.length;i++){
    		if(!node.charList.contains(arr[i]))
    			return false;
    		else{
    			node=node.list.get(node.charList.indexOf(arr[i]));
    		}
    	}

    	if(node.end)
    		return true;
    	else
    		return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	char[] arr=prefix.toCharArray();
    	TrieNode node=root;
    	for(int i=0;i<arr.length;i++){
    		if(!node.charList.contains(arr[i]))
    			return false;
    		else{
    			node=node.list.get(node.charList.indexOf(arr[i]));
    		}
    	}
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");