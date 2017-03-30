package leedcode;

public class NumMatrix2D {
	int[][] matrix;
	int[][] sum;
    public NumMatrix2D(int[][] matrix) {
        this.matrix=matrix;
        if(matrix.length==0){
        	return;
        }
        sum=new int[matrix.length][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
        	for(int j=1;j<sum[0].length;j++){
        		int index=j;
        		while(index<sum[0].length){
        			sum[i][index]+=matrix[i][j-1];
        			index+=lowbit(index);
        		}
        	}
        }
        
        
    }

    public void update(int row, int col, int val) {
        int diff=val-matrix[row][col];
        matrix[row][col]=val;
        col=col+1;
        while(col<sum[0].length){
        	sum[row][col]+=diff;
        	col+=lowbit(col);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int res=0;
    	for(int i=row1;i<=row2;i++){
    		res+=sumUp(i,col2+1)-sumUp(i,col1);
    	}
    	
        return res;
    }
    public int sumUp(int row,int col){
    	int res=0;
    	while(col>0){
    		res+=sum[row][col];
    		col-=lowbit(col);
    	}
    	return res;
    }
    private int lowbit(int i){
    	return i&(-i);
    }
}
