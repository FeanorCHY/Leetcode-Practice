package leedcode;

public class NumMatrix {
	int sum[][];
    public NumMatrix(int[][] matrix) {
        if(matrix.length!=0){
	        sum=new int[matrix.length][matrix[0].length];
	        for(int i=0;i<matrix.length;i++){
	        	for(int j=0;j<matrix[0].length;j++){
	        		if(j==0){
	        			if(i==0){
	        				sum[i][j]=matrix[i][j];
	        			}
	        			else
	        				sum[i][j]=sum[i-1][j]+matrix[i][j];
	        		}
	        		else{
	        			if(i==0)
	        				sum[i][j]=sum[i][j-1]+matrix[i][j];
	        			else
	        				sum[i][j]=sum[i-1][j]+sum[i][j-1]+matrix[i][j]-sum[i-1][j-1];
	        		}
	        	}
	        }
        }
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(row1!=0&&col1!=0){
    		return sum[row2][col2]-sum[row1-1][col2]-sum[row2][col1-1]+sum[row1-1][col1-1];
    	}
    	else if(row1==0&&col1==0)
    		return sum[row2][col2];
    	else if(row1==0)
    		return sum[row2][col2]-sum[row2][col1-1];
    	else if(col1==0)
    		return sum[row2][col2]-sum[row1-1][col2];
    	return 0;
    }
        
    
}
