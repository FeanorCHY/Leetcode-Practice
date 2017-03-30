
public class NumMatrix {

    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        if(matrix==null)
            return;
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=matrix[row2][col2];
        if(col1>0){
            res-=matrix[row2][col1-1];
        }
        if(row1>0)
            res-=matrix[row1-1][col2];
        if(col1>0&&row1>0)
            res+=matrix[row1-1][col1-1];
        return res;
    }
}
