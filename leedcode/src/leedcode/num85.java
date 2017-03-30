package leedcode;

public class num85 {
	char[][] matrix;
	int max=0;
    public int maximalRectangle(char[][] matrix) {
    	this.matrix=matrix;
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			if(matrix[i][j]=='1')
    				tryGo(matrix[0].length-1,i,j,1);
    		}
    	}
    	
        return max;
    }
    public void tryGo(int last,int x,int y,int deep){
    	int i=y;
    	for(;i<=last;i++){
    		if(matrix[x][i]=='1')
    			max=Math.max(max,deep*(i-y+1));
    		else
    			break;
    	}
    	if(x+1<matrix.length&&matrix[x+1][y]=='1')
    		tryGo(i-1,x+1,y,deep+1);
    }
	public static void main(String[] args) {
		char[][] test={"10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()};
		num85 sol=new num85();
		System.out.println(sol.maximalRectangle(test));
	}

}
