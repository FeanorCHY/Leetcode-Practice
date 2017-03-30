package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class num73 {
    public void setZeroes(int[][] matrix) {
    	if(matrix.length==0)
    		return;
    	HashSet<Integer> list=new HashSet<Integer>();
//    	for(int i=0;i<matrix.length;i++){
//    		list.add(i);
//    	}
    	boolean remove=false;
        for(int i=0;i<matrix[0].length;i++){
        	remove=false;
//        	ArrayList<Integer> temList=(ArrayList<Integer>)list.clone();
        	for(int j=0;j<matrix.length;j++){
        		if(matrix[j][i]==0){
//    	        	for(int k=0;k<matrix[0].length;k++){
//    	        		matrix[j][k]=0;
//    	        	}
	        		list.add(j);
        			remove=true;
        		}
        	}
//        	list=temList;
        	if(remove)
	        	for(int k=0;k<matrix.length;k++){
	        		matrix[k][i]=0;
	        	}
        }
        for(int i:list){
        	for(int k=0;k<matrix[0].length;k++){
        		matrix[i][k]=0;
        	}
        }
    	
    }
	public static void main(String[] args) {
		int test[][]={{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		num73 sol=new num73();
		sol.setZeroes(test);
		for(int i=0;i<test.length;i++){
			Arrays.toString(test[0]);
		}
	}

}
