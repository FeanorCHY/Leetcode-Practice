package leedcode;

public class num48 {

    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length/2;i++){
        	for(int j=0;j<(matrix.length+1)/2;j++){
    			int x=i;
    			int y=j;
    			int newx=y;
    			int newy=matrix.length-1-x;
    			int tem=matrix[x][y];
        		for(int k=0;k<4;k++){
        			int newtem=matrix[newx][newy];
        			matrix[newx][newy]=tem;
        			tem=newtem;
        			x=newx;
        			y=newy;
        			newx=y;
        			newy=matrix.length-1-x;
        		}
        	}
        }
    }
	public static void main(String[] args) {
		int test[][]={{1,2},{3,4}};
		num48 sol=new num48();
		sol.rotate(test);
	}

}
