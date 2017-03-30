package leedcode;

public class num171 {
    public int titleToNumber(String s) {
    	int res=0;
    	char[] arr=s.toCharArray();
    	for(char each:arr){
    		res=res*26+each-'A'+1;
    	}
    	
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
