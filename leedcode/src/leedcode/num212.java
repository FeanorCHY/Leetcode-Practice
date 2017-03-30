package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordTree{
	Character cur;
	boolean end=false;
	String word;
	boolean done=false;
//	List<WordTree> wlist=new ArrayList<WordTree>();
	HashMap<Character,WordTree> mp=new HashMap<Character,WordTree>();
	WordTree(Character c){
		this.cur=c;
	}
	static void addWord(WordTree head,char[] word){
		WordTree wt=head;
//		HashMap<Character,List<WordTree>> curmp=head.mp;
		int index=0;
		while(index<word.length&&wt.mp.containsKey(word[index])){
			wt=wt.mp.get(word[index++]);
		}
		if(index==word.length){
			wt.end=true;
			wt.word=new String(word);
		}
		else{
			for(int i=index;i<word.length;i++){
				WordTree next=new WordTree(word[i]);
				wt.mp.put(word[i], next);
				if(i==word.length-1){
					next.end=true;
					next.word=new String(word);
				}
				wt=next;
			}
		}
	}
}
public class num212 {
	char[][] board;
	List<String> res=new ArrayList<String>();
	boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
    	this.board=board;
    	this.visited=new boolean[board.length][board[0].length];
    	WordTree head=new WordTree('\0');
    	for(String each:words){
    		WordTree.addWord(head, each.toCharArray());
    	}
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(head.mp.containsKey(board[i][j])){
    				visited[i][j]=true;
    				tryGo(head.mp.get(board[i][j]),i,j);
    				visited[i][j]=false;
    			}
    		}
    	}
    	
        return res;
    }
    public void tryGo(WordTree node,int x,int y){
    	if(node.end&&!node.done){
    		res.add(node.word);
    		node.done=true;
    	}
    	if(x>0&&!visited[x-1][y]&&node.mp.containsKey(board[x-1][y])){
    		visited[x-1][y]=true;
    		tryGo(node.mp.get(board[x-1][y]),x-1,y);
    		visited[x-1][y]=false;
    	}
    	if(y>0&&!visited[x][y-1]&&node.mp.containsKey(board[x][y-1])){
    		visited[x][y-1]=true;
    		tryGo(node.mp.get(board[x][y-1]),x,y-1);
    		visited[x][y-1]=false;
    	}
    	if(x<board.length-1&&!visited[x+1][y]&&node.mp.containsKey(board[x+1][y])){
    		visited[x+1][y]=true;
    		tryGo(node.mp.get(board[x+1][y]),x+1,y);
    		visited[x+1][y]=false;
    	}
    	if(y<board[0].length-1&&!visited[x][y+1]&&node.mp.containsKey(board[x][y+1])){
    		visited[x][y+1]=true;
    		tryGo(node.mp.get(board[x][y+1]),x,y+1);
    		visited[x][y+1]=false;
    	}
    }
	public static void main(String[] args) {
		char[][] test={{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		num212 sol=new num212();
		String words[]={"oath","oathf","pea","eat","rain"};
		System.out.println(sol.findWords(test, words));
	}

}
