
public class num378 {

    int[][] matrix;
    int k;
    public int kthSmallest(int[][] matrix, int k) {
        this.matrix=matrix;
        int low=matrix[0][0];
        int len=matrix.length;
        int high=matrix[len-1][len-1];
        while(low<=high){
            int mid=(int)(((long)low+(long)high)/2);
            int count=search(mid);
            if(count>=k)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
    private int search(int target){
        int x=matrix.length-1;
        int y=0;
        int count=0;
        while(x>=0&&y<matrix.length){
            if(target>=matrix[x][y]){
                y++;
                count+=x+1;
            }
            else{
                x--;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		int[][] test={{2000000000}};
		num378 sol=new num378();
		System.out.println(sol.kthSmallest(test, 1));
	}

}
