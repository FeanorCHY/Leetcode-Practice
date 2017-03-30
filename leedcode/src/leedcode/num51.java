package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num51 {
	List<List<String>> listlist=new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
    	char[][] board=new char[n][n];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			board[i][j]='.';
    		}
    	}
    	tryGo(board,0);
        return listlist;
    }
    public boolean tryGo(char[][] board,int row){
    	if(row==board.length){
    		List<String> list=new ArrayList<String>();
    		for(int i=0;i<board.length;i++){
    			list.add(new String(board[i]));
    		}
    		listlist.add(list);
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
	public static void main(String[] args) {
		num51 sol=new num51();
		System.out.println(sol.solveNQueens(4));
	}

}
