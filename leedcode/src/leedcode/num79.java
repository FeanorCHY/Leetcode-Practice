package leedcode;

public class num79 {
	char[][] boardW;
	String match;
    public boolean exist(char[][] board, String word) {
    	boardW=board;
    	match=word;
    	char first=word.substring(0,1).toCharArray()[0];
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(board[i][j]==first){
        			if((""+board[i][j]).equals(match))
        				return true;
    				char[][] newBoard=new char[board.length][];
    				for(int k=0;k<board.length;k++){
    					newBoard[k]=board[k].clone();
    				}
//    				System.arraycopy(board, 0, newBoard,0, board.length);
	    			newBoard[i][j]=' ';
    				if(tryExist(newBoard,""+board[i][j],i,j))
    					return true;
    			}
    		}
    	}
    	return false;
    }
    public boolean tryExist(char[][] board,String word,int x,int y){
    	if(x>0){
    		if(board[x-1][y]!=' '){
    			String newWord=word+board[x-1][y];
    			if(newWord.equals(match))
    				return true;
    			if(newWord.length()<match.length()){
        			if(match.substring(0,newWord.length()).equals(newWord))
	    			{
        				char[][] newBoard=new char[board.length][];
        				for(int k=0;k<board.length;k++){
        					newBoard[k]=board[k].clone();
        				}
		    			newBoard[x-1][y]=' ';
		    			if(tryExist(newBoard,newWord,x-1,y))
		    				return true;
	    			}
    			}
    		}
    	}
    	if(x<board.length-1){
    		if(board[x+1][y]!=' '){
    			String newWord=word+board[x+1][y];
    			if(newWord.equals(match))
    				return true;
    			if(newWord.length()<match.length()){
        			if(match.substring(0,newWord.length()).equals(newWord))
	    			{
		    			char[][] newBoard=new char[board.length][];
        				for(int k=0;k<board.length;k++){
        					newBoard[k]=board[k].clone();
        				}
		    			newBoard[x+1][y]=' ';
		    			if(tryExist(newBoard,newWord,x+1,y))
		    				return true;
	    			}
    			}
    		}
    	}
    	if(y>0){
    		if(board[x][y-1]!=' '){
    			String newWord=word+board[x][y-1];
    			if(newWord.equals(match))
    				return true;
    			if(newWord.length()<match.length()){
        			if(match.substring(0,newWord.length()).equals(newWord))
	    			{
		    			char[][] newBoard=new char[board.length][];
        				for(int k=0;k<board.length;k++){
        					newBoard[k]=board[k].clone();
        				}
		    			newBoard[x][y-1]=' ';
		    			if(tryExist(newBoard,newWord,x,y-1))
		    				return true;
	    			}
    			}
    		}
    	}
    	if(y<board[0].length-1){
    		if(board[x][y+1]!=' '){
    			String newWord=word+board[x][y+1];
    			if(newWord.equals(match))
    				return true;
    			if(newWord.length()<match.length()){
        			if(match.substring(0,newWord.length()).equals(newWord))
	    			{
		    			char[][] newBoard=new char[board.length][];
        				for(int k=0;k<board.length;k++){
        					newBoard[k]=board[k].clone();
        				}
		    			newBoard[x][y+1]=' ';
		    			if(tryExist(newBoard,newWord,x,y+1))
		    				return true;
	    			}
    			}
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
//		char[][] test={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char[][] test={"ABCE".toCharArray(),"SFES".toCharArray(),"ADEE".toCharArray()};
		num79 sol=new num79();
		System.out.println(sol.exist(test, "ABCESEEEFS"));
	}

}
