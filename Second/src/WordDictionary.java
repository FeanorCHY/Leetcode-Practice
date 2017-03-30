//Trie Space O(nk)
public class WordDictionary {

    class Trie{
        Trie[] next=new Trie[26];
        boolean end=false;
    }
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root=new Trie();
    }
    //Time:O(k)
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie node=root;
        char[] arr=word.toCharArray();
        for(char c:arr){
            if(node.next[c-'a']==null)
                node.next[c-'a']=new Trie();
            node=node.next[c-'a'];
        }
        node.end=true;
    }
    //Time:O(nk) 
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie node=root;
        char[] arr=word.toCharArray();
        return find(arr,node,0);
    }
    private boolean find(char[] arr,Trie node,int idx){
        for(int i=idx;i<arr.length;i++){
            if(arr[i]=='.'){
                for(int j=0;j<26;j++){
                    if(node.next[j]!=null&&find(arr,node.next[j],i+1))
                        return true;
                }
                return false;
            }
            else{
                node=node.next[arr[i]-'a'];
                if(node==null)
                    return false;
            }
        }
        return node.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */