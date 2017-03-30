package leedcode;

public class num289 {
	int[][] ma;
	public void gameOfLife(int[][] board) {
		ma=board;
	    for(int i=0;i<board.length;i++){
	    	for(int j=0;j<board[0].length;j++){
	    		if(board[i][j]>=1)
	    			runchange(i,j);
	    	}
	    }
	    for(int i=0;i<board.length;i++){
	    	for(int j=0;j<board[0].length;j++){
	    		if(board[i][j]<0){
	    			if(board[i][j]==-3)
	    				board[i][j]=1;
	    		}
	    		else{
	    			board[i][j]--;
	    			if(board[i][j]==2||board[i][j]==3)
	    				board[i][j]=1;
	    			else if(board[i][j]>3||board[i][j]<2)
	    				board[i][j]=0;
	    		}
	    	}
	    }
    }
	public void runchange(int x,int y){
		change(x-1,y);
		change(x,y-1);
		change(x+1,y);
		change(x,y+1);
		change(x-1,y-1);
		change(x-1,y+1);
		change(x+1,y-1);
		change(x+1,y+1);
	}
	public void change(int x,int y){
		if(x<0||y<0||x==ma.length||y==ma[0].length)
			return;
		if(ma[x][y]>=1)
			ma[x][y]++;
		else
			ma[x][y]--;
	}
	public static void main(String[] args) {
		int[][] test={{1,1},{1,0}};
		num289 sol=new num289();
		sol.gameOfLife(test);
	}

}
