package leedcode;

public class num191 {
    public int hammingWeight(int n) {
    	int res=0;
    	for(int i=0;i<32;i++){
    		res+=(n>>i)&1;
    	}
    	
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
