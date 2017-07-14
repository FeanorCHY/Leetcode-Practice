
public class num037 {

    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    private boolean dfs(char[][] board,int x){
        for(int i=x;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    boolean[] visit=new boolean[9];
                    int xx=3*(i/3);
                    int yy=3*(j/3);
                    for(int k=0;k<9;k++){
                        // System.out.println("i:"+i+"  j:"+j);
                        if(board[k][j]!='.')
                            visit[board[k][j]-'1']=true;
                        if(board[i][k]!='.')
                            visit[board[i][k]-'1']=true;
                        if(board[xx+k/3][yy+k%3]!='.')
                            visit[board[xx+k/3][yy+k%3]-'1']=true;
                    }
                    for(int k=0;k<9;k++){
                        if(!visit[k]){
                            board[i][j]=(char)('1'+k);
                            if(dfs(board,x))
                                return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
