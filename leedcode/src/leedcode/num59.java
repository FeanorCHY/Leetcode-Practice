package leedcode;

import java.util.Arrays;

public class num59 {
    public int[][] generateMatrix(int n) {
    	int[][] matrix=new int[n][n];
    	int x=0;
    	int y=-1;
    	int l=n;
    	int num=1;
//    	int m=n;
    	while(l>0){
    		for(int i=0;i<l;i++){
    			matrix[x][++y]=num++;
    		}
    		for(int i=0;i<l-1;i++){
    			matrix[++x][y]=num++;
    		}
    		for(int i=0;i<l-1;i++){
    			matrix[x][--y]=num++;
    		}
    		for(int i=0;i<l-2;i++){
    			matrix[--x][y]=num++;
    		}
    		l=l-2;
    	}
    	
    	
        return matrix;
    }
	public static void main(String[] args) {
		num59 sol=new num59();
		int[][] test=sol.generateMatrix(10);
		for(int i=0;i<test.length;i++){
			System.out.println(Arrays.toString(test[i]));
		}
	}

}
