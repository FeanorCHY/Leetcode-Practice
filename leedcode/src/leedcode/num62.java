package leedcode;

public class num62 {
    public int uniquePaths(int m, int n) {
    	int[] step=new int[n];
    	for(int i=0;i<n;i++){
    		step[i]=1;
    	}
    	for(int i=0;i<m-1;i++){
    		for(int j=1;j<n;j++){
    			step[j]=step[j]+step[j-1];
    		}
    	}
        return step[n-1];
    }
	public static void main(String[] args) {
		num62 sol=new num62();

	}

}
