package leedcode;

public class num74 {

    public boolean searchMatrix(int[][] matrix, int target) {
    	int low=0;
    	int high=matrix.length-1;
    	int mid=(high+low)/2;
    	while(low<=high){
    		if(matrix[mid][0]==target)
    			return true;
    		else if(matrix[mid][0]>target){
    			high=mid-1;
    		}
    		else{
    			low=mid+1;
    		}
    		mid=(high+low)/2;
    	}
    	int loc=mid;
    	low=0;
    	high=matrix[0].length-1;
    	mid=(high+low)/2;
    	while(low<=high){
    		if(matrix[loc][mid]==target)
    			return true;
    		else if(matrix[loc][mid]>target){
    			high=mid-1;
    		}
    		else{
    			low=mid+1;
    		}
    		mid=(high+low)/2;
    	}
    	
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
