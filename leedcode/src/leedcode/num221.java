package leedcode;

public class num221 {
	char[][] char2d;
    public int maximalSquare(char[][] matrix) {
    	char2d=matrix;
    	int large=0;
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			if(matrix[i][j]=='1'){
    				int area=checkSquare(i,j,2);
    				if(area>large)
    					large=area;
    			}
    		}
    	}
        return large;
    }
    public int checkSquare(int i,int j,int dim){
    	if(i+dim-1>char2d.length-1||j+dim-1>char2d[0].length-1)
    		return (dim-1)*(dim-1);
    	for(int l=i;l<=i+dim-1;l++){
    		if(char2d[l][j+dim-1]=='0')
    			return (dim-1)*(dim-1);
    	}
    	for(int l=j;l<j+dim-1;l++){
    		if(char2d[i+dim-1][l]=='0')
    			return (dim-1)*(dim-1);
    	}
    	int larger=checkSquare(i,j,dim+1);
    	return larger;//larger*larger
    }
    
	public static void main(String[] args) {
		char[][] test={"10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()};
		num221 sol=new num221();
		System.out.println(sol.maximalSquare(test));

	}

}
