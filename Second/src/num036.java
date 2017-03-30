
public class num036 {

    
    //boolean array with one pass
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9)
            return false;
        for(int i=0;i<9;i++){
            boolean[] row=new boolean[9];
            boolean[] col=new boolean[9];
            boolean[] cell=new boolean[9];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'&&(board[i][j]>'9'||board[i][j]<'1'||row[board[i][j]-'1']))
                    return false;
                if(board[j][i]!='.'&&(board[j][i]>'9'||board[j][i]<'1'||col[board[j][i]-'1']))
                    return false;
                int x=(i/3)*3+j/3;
                int y=(i%3)*3+j%3;
                System.out.println("x: "+x);
                System.out.println("y: "+y);
                System.out.println("(board[x][y]: "+board[x][y]);
                if(board[x][y]!='.'&&(board[x][y]>'9'||board[x][y]<'1'||cell[board[x][y]-'1']))
                    return false;
                if(board[i][j]!='.')
                    row[board[i][j]-'1']=true;
                if(board[j][i]!='.')
                    col[board[j][i]-'1']=true;
                if(board[x][y]!='.')
                    cell[board[x][y]-'1']=true;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		char[][] test={"...5..8..".toCharArray(),"......41.".toCharArray(),"3.9...7..".toCharArray(),"...6.8...".toCharArray(),".1...7..4".toCharArray(),".5.......".toCharArray(),".........".toCharArray(),"...2.....".toCharArray(),"...81...4".toCharArray()};
		num036 sol=new num036();
		System.out.println(sol.isValidSudoku(test));
	}

}
