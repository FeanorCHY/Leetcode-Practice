
public class num074 {

    //O(logm+logn) double Binary Search
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return false;
    //     int up=0,down=matrix.length-1;
    //     while(up<=down){
    //         int mid=(up+down)/2;
    //         if(matrix[mid][0]==target)
    //             return true;
    //         else if(matrix[mid][0]>target)
    //             down=mid-1;
    //         else
    //             up=mid+1;
    //     }
    //     if(down<0)
    //         return false;
    //     int l=0,r=matrix[down].length-1;
    //     while(l<=r){
    //         int mid=(l+r)/2;
    //         if(matrix[down][mid]==target)
    //             return true;
    //         else if(matrix[down][mid]>target)
    //             r=mid-1;
    //         else
    //             l=mid+1;
    //     }
    //     return false;
    // }
    
    
    //O(m+n) sequential search
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return false;
    //     int i=0,j=matrix[0].length-1;
    //     while(i<matrix.length&&j>=0){
    //         if(matrix[i][j]==target)
    //             return true;
    //         else if(matrix[i][j]>target)
    //             j--;
    //         else
    //             i++;
    //     }
    //     return false;
    // }
    
    
    //search as single array O(log(m+n))
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int l=0,r=matrix.length*matrix[0].length-1;
        while(l<=r){
            int mid=(l+r)/2;
            int x=mid/matrix[0].length;
            int y=mid%matrix[0].length;
            if(matrix[x][y]==target)
                return true;
            else if(matrix[x][y]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
