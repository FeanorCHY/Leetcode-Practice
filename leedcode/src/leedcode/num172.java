package leedcode;

public class num172 {
    public int trailingZeroes(int n) {
    	int res=0;
    	long idx=10;
//    	while((long)n>=idx){
//    		res+=n/idx;
//    		idx=idx*10;
//    	}
    	idx=5;
    	while((long)n>=idx){
    		res+=n/idx;
    		idx=idx*5;
    	}
    	
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
