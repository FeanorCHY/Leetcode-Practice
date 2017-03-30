//what if nif not valid? if there are more than one player?
//Space O(N)
public class TicTacToe {
    int[] r;
    int[] c;
    int[] dia;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        dia=new int[2];
        r=new int[n];
        c=new int[n];
        this.n=n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    //time: O(1)
    public int move(int row, int col, int player) {
        if(player==1){
            r[row]++;
            c[col]++;
            if(r[row]==n||c[col]==n)
                return player;
            if(row==col)
                dia[0]++;
            if(row==n-col-1)
                dia[1]++;
            if(dia[0]==n||dia[1]==n)
                return player;
            return 0;
        }
        else{
            r[row]--;
            c[col]--;
            if(r[row]==-n||c[col]==-n)
                return player;
            if(row==col)
                dia[0]--;
            if(row==n-col-1)
                dia[1]--;
            if(dia[0]==-n||dia[1]==-n)
                return player;
            return 0;
        }
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */