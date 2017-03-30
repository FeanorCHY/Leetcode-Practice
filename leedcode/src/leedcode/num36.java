package leedcode;

import java.util.ArrayList;
import java.util.Arrays;

public class num36 {
    public boolean isValidSudoku(char[][] board) {
		ArrayList<Character> arrbox=new ArrayList<Character>();
    	for(int i=0;i<board.length;i++){
    		ArrayList<Character> arrRow=new ArrayList<Character>();
    		ArrayList<Character> arrCol=new ArrayList<Character>();
    		for(int j =0;j<board[0].length;j++)
    		{
    			if(board[i][j]!=46)
    			{
    				if(arrRow.contains(board[i][j]))
    					return false;
    				arrRow.add(board[i][j]);
    			}
    			if(board[j][i]!=46)
    			{
    				if(arrCol.contains(board[j][i]))
    					return false;
    				arrCol.add(board[j][i]);
    			}
    			
    			
    			int sum=i*board.length+j;
    			int box=sum/9;
    			int row=(sum-box*9)/3;
    			int col=sum%3;
    			int boxrow=box/3;
    			int boxcol=box%3;
    			int x=boxrow*3+row;
    			int y=boxcol*3+col;
    			if(board[x][y]!=46)
    			{
    				if(arrbox.contains(board[x][y]))
    					return false;
    				arrbox.add(board[x][y]);
    			}
    			if(sum%9==8)
    				arrbox.clear();
    			
    			
    			
    			
    			if(!((board[i][j]>=49&&board[i][j]<=57)||board[i][j]==46))//"\\d"
					return false;
    		}
    	}
    	
    	
        return true;
    }

	public static void main(String[] args) {
		char t='4';
		char[][] arr={"..4...63.".toCharArray(),".........".toCharArray(),"5......9.".toCharArray(),"...56....".toCharArray(),"4.3.....1".toCharArray(),"...7.....".toCharArray(),"...5.....".toCharArray(),".........".toCharArray(),".........".toCharArray()};

    	for(int i=0;i<arr.length;i++)
    		System.out.println(Arrays.toString(arr[i]));
	}

}
