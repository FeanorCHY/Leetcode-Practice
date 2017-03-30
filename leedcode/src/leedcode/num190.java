package leedcode;

public class num190 {
    public int reverseBits(int n) {
    	int res=0;
    	for(int i=0;i<32;i++){
    		int cur=(n>>i)&1;
    		res+=(cur<<(32-i-1));
    	}
    	
    	
        return res;
    }
	public static void main(String[] args) {
		num190 sol=new num190();
		System.out.print(Integer.toBinaryString(sol.reverseBits(1)));
	}

}
