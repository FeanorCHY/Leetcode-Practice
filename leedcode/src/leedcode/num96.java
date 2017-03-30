package leedcode;

public class num96 {

    public int numTrees(int n) {
    	int[] step=new int[n+1];
    	step[0]=1;
    	step[1]=1;
    	for(int i=2;i<=n;i++){
    		for(int j=0;j<=i-1;j++){
    			step[i]=step[i]+step[j]*step[i-1-j];
    		}
    	}
    	
    	
    	
        return step[n];
    }
	public static void main(String[] args) {
		num96 sol=new num96();
		System.out.println(sol.numTrees(4));
	}

}
