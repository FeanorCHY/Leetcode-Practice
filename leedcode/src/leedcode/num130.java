package leedcode;

import java.util.Arrays;

public class num130 {
    public void solve(char[][] board) {
        if(board.length<3)
            return;
        if(board[0].length<3)
            return;
        int[][] record=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='X')
        			record[i][j]=1;
        		else{
        			if(i==0||j==0||i==board.length-1||j==board[0].length-1){
        				record[i][j]=0;
        			}
        			else{
        				if(record[i-1][j]==0||record[i][j-1]==0){
        					record[i][j]=0;
        				}
        				else
        					record[i][j]=2;
        			}
        		}
        	}
        }
        for(int k=0;k<3;k++){
	        for(int i=board.length-1;i>=0;i--){
	        	for(int j=board[0].length-1;j>=0;j--){
	    			if(i==0||j==0||i==board.length-1||j==board[0].length-1){
	    			}
	    			else{
	    				if(record[i][j]==2)
		    				if((record[i+1][j]==0||record[i][j+1]==0)){
		    					record[i][j]=0;
		    				}
	    			}
	        	}
	        }
	        for(int i=0;i<board.length;i++){
	        	for(int j=0;j<board[0].length;j++){
	    			if(i==0||j==0||i==board.length-1||j==board[0].length-1){
	    			}
	    			else{
	    				if(record[i][j]==2)
		    				if((record[i-1][j]==0||record[i][j-1]==0)){
		    					record[i][j]=0;
		    				}
	    			}
	        	}
	        }
        }
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(record[i][j]==2)
        			board[i][j]='X';
        	}
        }
    }
	public static void main(String[] args) {
		char board[][]={"XOXOXOOOXO".toCharArray(),"XOOXXXOOOX".toCharArray(),"OOOOOOOOXX".toCharArray(),"OOOOOOXOOX".toCharArray(),"OOXXOXXOOO".toCharArray(),"XOOXXXOXXO".toCharArray(),"XOXOOXXOXO".toCharArray(),"XXOXXOXOOX".toCharArray(),"OOOOXOXOXO".toCharArray(),"XXOXXXXOOO".toCharArray()};
//		char board[][]={"OXXXXXOO".toCharArray(),"OOOXXXXO".toCharArray(),"XXXXOOOO".toCharArray(),"XOXOOXXX".toCharArray(),"OXOXXXOO".toCharArray(),"OXXOOXXO".toCharArray(),"OXOXXXOO".toCharArray(),"OXXXXOXX".toCharArray()};
		num130 sol=new num130();

		for(int i=0;i<board.length;i++){
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
		sol.solve(board);
		for(int i=0;i<board.length;i++){
			System.out.println(Arrays.toString(board[i]));
		}
		
	}

}
