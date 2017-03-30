package leedcode;

public class num419 {
    public int countBattleships(char[][] board) {
    	if(board.length==0||board==null)
    		return 0;
    	int count=0;
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(board[i][j]=='X'){
    				if((i==0||(i>0&&board[i-1][j]!='X'))&&(j==0||(j>0&&board[i][j-1]!='X'))){
						count++;
    				}
    			}
    		}
    	}
    	return count;
    }
	public static void main(String[] args) {
		char[][] test={"..".toCharArray(),"XX".toCharArray()};
		num419 sol=new num419();
		System.out.println(sol.countBattleships(test));
	}

}
