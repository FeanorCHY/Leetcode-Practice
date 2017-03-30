
class TrieNode{
    TrieNode[] next;
    boolean end;
    public TrieNode(){
        next=new TrieNode[26];
        end=false;
    }
}

public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr=word.toCharArray();
        TrieNode node=root;
        for(char c:arr){
            int id=c-'a';
            if(node.next[id]==null)
                node.next[id]=new TrieNode();
            node=node.next[id];
        }
        node.end=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] arr=word.toCharArray();
        TrieNode node=root;
        for(char c:arr){
            int id=c-'a';
            if(node.next[id]==null)
                return false;
            node=node.next[id];
        }
        return node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] arr=prefix.toCharArray();
        TrieNode node=root;
        for(char c:arr){
            int id=c-'a';
            if(node.next[id]==null)
                return false;
            node=node.next[id];
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */