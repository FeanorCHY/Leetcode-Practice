package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num52 {
	int count=0;
    public int totalNQueens(int n) {
    	char[][] board=new char[n][n];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			board[i][j]='.';
    		}
    	}
    	tryGo(board,0);
        return count;
    }
    public boolean tryGo(char[][] board,int row){
    	if(row==board.length){
    		count++;
    	}
    	for(int i=0;i<board.length;i++){
    		if(isValid(board,row,i)){
    			board[row][i]='Q';
    			tryGo(board,row+1);
    			board[row][i]='.';
    		}
    	}
    	return false;
    }
    public boolean isValid(char[][] board,int x,int y){
    	for(int i=0;i<x;i++){
    		if(board[i][y]=='Q')
    			return false;
    	}
    	int pos1=x-1;
    	int pos2=y-1;
    	while(pos1>=0&&pos2>=0){
    		if(board[pos1][pos2]=='Q')
    			return false;
    		pos1--;
    		pos2--;
    	}
    	pos1=x-1;
    	pos2=y+1;
    	while(pos1>=0&&pos2<board.length){
    		if(board[pos1][pos2]=='Q')
    			return false;
    		pos1--;
    		pos2++;
    	}
    	return true;
    }

}
