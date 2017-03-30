package leedcode;

public class num208 {

	public static void main(String[] args) {
		 Trie trie = new Trie();
		 trie.insert("abc");
		 System.out.println(trie.search("abc"));
		 trie.insert("ab");
		 System.out.println(trie.search("ab"));
	}

}
