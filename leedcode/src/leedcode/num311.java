package leedcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class num311 {
    public int[][] multiply(int[][] A, int[][] B) {
    	
    	if(B.length==0||A.length==0)
    		return null;
    	if(B[0].length==0||A[0].length==0)
    		return null;
    	ArrayList<Integer> setA=new ArrayList<Integer>();
    	ArrayList<Integer> setB=new ArrayList<Integer>();
    	for(int i=0;i<A.length;i++){
    		for(int j=0;j<A[0].length;j++){
    			if(A[i][j]!=0)
    				setA.add(i);
    		}
    	}
    	for(int i=0;i<B[0].length;i++){
    		for(int j=0;j<B.length;j++){
    			if(B[i][j]!=0)
    				setB.add(i);
    		}
    	}
    	int[][] result=new int[A.length][B[0].length];
    	for(int x:setA){
    		for(int y:setB){
    			int sum=0;
    	    	for(int i=0;i<A[0].length;i++){
	    			sum+=A[x][i]*B[i][y];
//    	    		for(int j=y;j<A[0].length;j++){
//    	    		}
    	    	}
    	    	result[x][y]=sum;
    		}
    	}
    	
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
