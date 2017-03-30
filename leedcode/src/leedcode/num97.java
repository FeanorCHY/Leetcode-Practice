package leedcode;

import java.util.Stack;

public class num97 {
    public boolean isInterleave(String s1, String s2, String s3) {
    	char[] arr1=s1.toCharArray();
    	char[] arr2=s2.toCharArray();
    	char[] arr3=s3.toCharArray();
    	if(arr1.length+arr2.length!=arr3.length)
    		return false;
    	boolean[][] valid=new boolean[arr1.length+1][arr2.length+1];
    	valid[0][0]=true;
    	for(int i=0;i<=arr1.length;i++){
        	for(int j=0;j<=arr2.length;j++){
				if(i-1>=0&&valid[i-1][j]&&arr3[j+i-1]==arr1[i-1])
					valid[i][j]=true;
				if(j-1>=0&&valid[i][j-1]&&arr3[j+i-1]==arr2[j-1])
					valid[i][j]=true;
        	}
    	}
    	
        return valid[arr1.length][arr2.length];
    }
	public static void main(String[] args) {
		num97 sol=new num97();
		System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

}
