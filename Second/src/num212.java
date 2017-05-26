import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class num212 {

	//search along the words
//	     class FWNode{
//	         FWNode next[]=new FWNode[26];
//	         String end=null;
//	         boolean done=false;
//	     }
//	     private void Insert(String str){
//	         FWNode node=root;
//	         for(char c:str.toCharArray()){
//	             if(node.next[c-'a']==null)
//	                 node.next[c-'a']=new FWNode();
//	             node=node.next[c-'a'];
//	         }
//	         node.end=str;
//	     }
//	     class Pos{
//	         int x;
//	         int y;
//	         public Pos(int x,int y){
//	             this.x=x;
//	             this.y=y;
//	         }
//	     }
//	     FWNode root=new FWNode();
//	     public List<String> findWords(char[][] board, String[] words) {
//	         if(board==null||board.length==0||board[0].length==0||words.length==0)
//	             return new ArrayList<String>();
//	         List<String> res=new ArrayList<String>(words.length);
//	         for(String word:words)
//	             Insert(word);
//	         HashSet<Pos> poss[]=new HashSet[26];
//	         for(int i=0;i<26;i++)
//	             poss[i]=new HashSet<Pos>();
//	         for(int i=0;i<board.length;i++){
//	             for(int j=0;j<board[0].length;j++){
//	                 poss[board[i][j]-'a'].add(new Pos(i,j));
//	             }
//	         }
//	         find(board,poss,res);
//	         return res;
//	     }
//	     private void find(char[][] board,HashSet<Pos> poss[],List<String> res){
//	         FWNode node=root;
//	         for(int i=0;i<26;i++){
//	             if(node.next[i]==null)
//	                 continue;
//	             for(Pos p:poss[i]){
//	                 char c=board[p.x][p.y];
//	                 board[p.x][p.y]='#';
//	                 check(board,p.x,p.y,res,node.next[i]);
//	                 board[p.x][p.y]=c;
//	             }
//	         }
//	     }
//	     private void check(char[][] board,int x,int y,List<String> res,FWNode node){
//	         if(node.end!=null&&!node.done){
//	             node.done=true;
//	             res.add(node.end);
//	         }
//	         int[] dx={1,0,-1,0};
//	         int[] dy={0,1,0,-1};
//	         for(int i=0;i<26;i++){
//	             if(node.next[i]==null)
//	                 continue;
//	             char c=(char)(i+'a');
//	             for(int k=0;k<4;k++){
//	                 int nx=x+dx[k];
//	                 int ny=y+dy[k];
//	                 if(nx>=0&&nx<board.length&&ny>=0&&ny<board[nx].length&&board[nx][ny]==c){
//	                     board[nx][ny]='#';
//	                     check(board,nx,ny,res,node.next[i]);
//	                     board[nx][ny]=c;
//	                 }
//	             }
//	         }
//	     }


	//search along the board
    class FWNode{
        FWNode next[]=new FWNode[26];
        String end=null;
    }
    private void Insert(String str){
        FWNode node=root;
        for(char c:str.toCharArray()){
            if(node.next[c-'a']==null)
                node.next[c-'a']=new FWNode();
            node=node.next[c-'a'];
        }
        node.end=str;
    }
    class Pos{
        int x;
        int y;
        public Pos(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    FWNode root=new FWNode();
    public List<String> findWords(char[][] board, String[] words) {
        if(board==null||board.length==0||board[0].length==0||words.length==0)
            return new ArrayList<String>();
        List<String> res=new ArrayList<String>(words.length);
        for(String word:words)
            Insert(word);
        find(board,res);
        return res;
    }
    private void find(char[][] board,List<String> res){
        FWNode node=root;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(node.next[board[i][j]-'a']!=null){
                    char c=board[i][j];
                    board[i][j]='#';
                    check(board,i,j,res,node.next[c-'a']);
                    board[i][j]=c;
                }
            }
        }
    }
    private void check(char[][] board,int x,int y,List<String> res,FWNode node){
        if(node.end!=null){
            res.add(node.end);
            node.end=null;
        }
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        for(int k=0;k<4;k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0&&nx<board.length&&ny>=0&&ny<board[nx].length&&board[nx][ny]!='#'&&node.next[board[nx][ny]-'a']!=null){
                char c=board[nx][ny];
                board[nx][ny]='#';
                check(board,nx,ny,res,node.next[c-'a']);
                board[nx][ny]=c;
            }
        }
    }
	public static void main(String[] args) {
		char[][] board={"aa".toCharArray()};
		String words[]={"aaa"};
		num212 sol=new num212();
		System.out.println(sol.findWords(board, words));
	}

}
