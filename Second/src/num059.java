
public class num059 {
    public static int[][] generateMatrix(int n) {
    	int[][] res = new int[n][n];
    	int top=0,left=0,bottom=n-1,right=n-1,count=1;
    	while(left<=right){
    	    for(int i=left;i<=right;i++)
    	        res[top][i]=count++;
	        top++;
            for(int i=top;i<=bottom;i++)
                res[i][right]=count++;
            right--;
            for(int i=right;i>=left;i--)
                res[bottom][i]=count++;
            bottom--;
            for(int i=bottom;i>=top;i--)
                res[i][left]=count++;
            left++;
    	}
    	return res;
    }
    // public int[][] generateMatrix(int n) {
    //     if(n<=0)
    //         return new int[0][0];
    //     int[][] res=new int[n][n];
    //     int x=1;
    //     for(int i=0;i<(n+1)/2;i++){
    //         for(int j=i;j<n-1-i;j++)
    //             res[i][j]=x++;
    //         for(int j=i;j<n-1-i;j++)
    //             res[j][n-1-i]=x++;
    //         for(int j=n-1-i;j>i;j--)
    //             res[n-1-i][j]=x++;
    //         for(int j=n-1-i;j>i;j--)
    //             res[j][i]=x++;
    //     }
    //     if(n%2==1)
    //         res[(n+1)/2-1][(n+1)/2-1]=x++;
    //     return res;
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
