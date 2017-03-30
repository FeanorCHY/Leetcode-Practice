
public class num419 {

    public int countBattleships(char[][] board) {
        int count=0;
        if(board==null||board.length==0||board[0].length==0)
            return 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'&&(i==0||board[i-1][j]=='.')&&(j==0||board[i][j-1]=='.')){
                    count++;
                    // int add=0;
                    // if((i==0||board[i-1][j]=='.')&&i+1<board.length&&board[i+1][j]=='X')
                    //     add++;
                    // if((j==0||board[i][j-1]=='.')&&j+1<board[0].length&&board[i][j+1]=='X')
                    //     add++;
                    // if(add==0&&((i==0||board[i-1][j]=='.')&&(j==0||board[i][j-1]=='.')))
                    //     add++;
                    // count+=add;
                    
                }
                
            }
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
