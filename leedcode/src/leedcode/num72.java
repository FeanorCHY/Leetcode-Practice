package leedcode;

public class num72 {
    public int minDistance(String word1, String word2) {
    	char[] arr1=word1.toCharArray();
    	char[] arr2=word2.toCharArray();
    	int[][] dif=new int[arr1.length+1][arr2.length+1];
    	for(int i=0;i<=arr1.length;i++){
    		dif[i][0]=i;
    	}
    	for(int i=0;i<=arr2.length;i++){
    		dif[0][i]=i;
    	}
    	for(int i=0;i<arr1.length;i++){
    		for(int j=0;j<arr2.length;j++){
    			int f=arr1[i]==arr2[j]?0:1;
    			dif[i+1][j+1]=Math.min(Math.min(dif[i+1][j]+1, dif[i][j+1]+1), dif[i][j]+f);
    		}
    	}
    	
    	return dif[arr1.length][arr2.length];
    }
	public static void main(String[] args) {
		num72 sol=new num72();
		System.out.println(sol.minDistance("mart", "karma"));
	}

}
