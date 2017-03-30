package leedcode;

public class num240 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0 || matrix[0].length==0) return false;  
    	int i=matrix.length-1;
    	int j=0;
    	while(j<=matrix[0].length&&i>=0){
    		int val=matrix[i][j];
    		if(val==target)
    			return true;
    		if(val<target) 
    			j++;
    		else 
    			i--;
    	}
    	
    	
    	
    	return false;
    }
	public static void main(String[] args) {
		int[][] test={{-1,5}};
		num240 sol=new num240();
		System.out.println(sol.searchMatrix(test, 5));

	}

}

//if(matrix==null){
//	return false;
//}
//int low=-1;
//int high=matrix.length;
//for(int i=0;i<matrix.length;i++){
//	if(matrix[i][0]<=target&&matrix[i][matrix[0].length-1]>=target&&low==-1)
//		low=i;
//	if(matrix[i][0]>target&&high==matrix.length)
//		high=i;
//}
//high=high-1;
//if(high==-1||low==-1)
//	return false;
//for(int i=0;i<matrix[0].length;i++){
//	if(matrix[low][i]>target||matrix[high][i]<target)
//		continue;
//	for(int j=low;j<=high;j++){
//		if(matrix[j][i]==target)
//			return true;
//	}
//}
//
//return false;