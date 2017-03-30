package leedcode;

import java.util.Arrays;
import java.util.Comparator;

public class num474 {
    public int findMaxForm(String[] strs, int m, int n) {
    	int[][] dp=new int[m+1][n+1];
    	for(String str:strs){
    		int Bin[]=btran(str);
    		for(int i=m;i>=Bin[0];i--){
    			for(int j=n;j>=Bin[1];j--){
    				dp[i][j]=Math.max(dp[i][j], 1+dp[i-Bin[0]][j-Bin[1]]);
    			}
    		}
    	}
    	return dp[m][n];
    }
    private int[] btran(String str){
    	char[] arr=str.toCharArray();
    	int[] res=new int[2];
    	for(int i=0;i<arr.length;i++){
    		res[arr[i]-'0']++;
    	}
    	return res;
    }
	public static void main(String[] args) {
		String[] test={"10", "0001", "111001", "1", "0"};
		num474 sol=new num474();
		System.out.println(sol.findMaxForm(test, 5, 3));
	}

}
