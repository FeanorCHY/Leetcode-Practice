
public class num498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return new int[0];
        int m=matrix.length,n=matrix[0].length;
        int res[]=new int[m*n];
        int i=0,j=0;
        boolean up=true;
        int idx=0;
        while(i<m&&j<n){
            if(up){
                while(i>=0&&j<n)
                    res[idx++]=matrix[i--][j++];
                i++;
                j--;
                if(j+1<n)
                    j++;
                else
                    i++;
            }
            else{
                while(i<m&&j>=0)
                    res[idx++]=matrix[i++][j--];
                i--;
                j++;
                if(i+1<m)
                    i++;
                else
                    j++;
            }
            up=!up;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
