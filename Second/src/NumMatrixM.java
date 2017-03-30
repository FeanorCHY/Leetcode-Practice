
public class NumMatrixM {
    //Space O(mn)
    int[][] matrix;
    int[][] sum;
    int m;
    int n;
    //Time O(mnlogm+mnlogn)
    public NumMatrixM(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return;
        this.matrix=matrix;
        this.m=matrix.length;
        this.n=matrix[0].length;
        this.sum=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int num=j+1;
                while(num<=n){
                    sum[i+1][num]+=matrix[i][j];
                    num+=lowbit(num);
                }
            }
        }
        int[][] sum2=new int[m+1][n+1];
        for(int j=1;j<=n;j++){
            for(int i=1;i<=m;i++){
                int num=i;
                while(num<=m){
                    sum2[num][j]+=sum[i][j];
                    num+=lowbit(num);
                }
            }
        }
        this.sum=sum2;
        // for(int i=0;i<=m;i++){
        //     System.out.println(Arrays.toString(sum[i]));
        // }
    }
    private int lowbit(int num){
        return num&(-num);
    }
    //O(logm*logn)
    public void update(int row, int col, int val) {
        int dif=val-matrix[row][col];
        matrix[row][col]=val;
        for(int i=row+1;i<=m;i+=lowbit(i)){
            for(int j=col+1;j<=n;j+=lowbit(j)){
                sum[i][j]+=dif;
            }
        }
    }
    //O(logm*logn)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumup(row2,col2)-sumup(row2,col1-1)-sumup(row1-1,col2)+sumup(row1-1,col1-1);
    }
    private int sumup(int row,int col){
        int res=0;
        for(int i=row+1;i>0;i-=lowbit(i)){
            for(int j=col+1;j>0;j-=lowbit(j)){
                res+=sum[i][j];
            }
        }
        // System.out.println(res);
        return res;
    }

}
