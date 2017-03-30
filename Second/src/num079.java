
public class num079 {
    //Space O(1)
    char[] arr;
    int dx[]={0,1,-1,0};
    int dy[]={1,0,0,-1};
    char[][] board;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0)
            return false;
        if(word==null||word.length()==0)
            return true;
        this.board=board;
        arr=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==arr[0]){
                    board[i][j]^=256;
                    if(search(i,j,0)){
                        board[i][j]^=256;
                        return true;
                    }
                    board[i][j]^=256;
                }
            }
        }
        return false;
    }
    private boolean search(int x,int y,int index){
        if(index==arr.length-1)
            return true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length&&arr[index+1]==board[nx][ny]){
                board[nx][ny]^=256;
                if(search(nx,ny,index+1)){
                    board[nx][ny]^=256;
                    return true;
                }
                board[nx][ny]^=256;
            }
        }
        return false;
    }
    
    //what if word is empty
    //O(MNK) Space:O(MN)
    // boolean[][] visit;
    // char[] arr;
    // int dx[]={0,1,-1,0};
    // int dy[]={1,0,0,-1};
    // char[][] board;
    // public boolean exist(char[][] board, String word) {
    //     if(board==null||board.length==0||board[0].length==0)
    //         return false;
    //     if(word==null||word.length()==0)
    //         return true;
    //     this.board=board;
    //     this.visit=new boolean[board.length][board[0].length];
    //     arr=word.toCharArray();
    //     for(int i=0;i<board.length;i++){
    //         for(int j=0;j<board[0].length;j++){
    //             visit[i][j]=true;
    //             if(board[i][j]==arr[0]&&search(i,j,0))
    //                 return true;
    //             visit[i][j]=false;
    //         }
    //     }
    //     return false;
    // }
    // private boolean search(int x,int y,int index){
    //     if(board[x][y]!=arr[index])
    //         return false;
    //     // System.out.println(index);
    //     // System.out.println("x:"+x+",y:"+y);
    //     if(index==arr.length-1)
    //         return true;
    //     for(int i=0;i<4;i++){
    //         int nx=x+dx[i];
    //         int ny=y+dy[i];
    //         if(nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length&&!visit[nx][ny]){
    //             visit[nx][ny]=true;
    //             if(search(nx,ny,index+1))
    //                 return true;
    //             visit[nx][ny]=false;
    //         }
    //     }
    //     return false;
    // }

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString((char)(256^'g')));
		System.out.println((char)(256^'g'+1));
	}

}
