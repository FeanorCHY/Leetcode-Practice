package leedcode;

public class TicTacToe {
	int[] hor;
	int[] ver;
	int[] dia;
	int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n=n;
        hor=new int[n*2];
        ver=new int[n*2];
        dia=new int[4];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
    	hor[row+(player-1)*n]++;
    	ver[col+(player-1)*n]++;
    	if(row==col){
    		dia[(player-1)*2]++;
    	}
    	if(row==n-col-1){
    		dia[(player-1)*2+1]++;
    	}
    	if(hor[row+(player-1)*n]==n||ver[col+(player-1)*n]==n||dia[(player-1)*2]==n||dia[(player-1)*2+1]==n)
    		return player;
    	return 0;
    }
}