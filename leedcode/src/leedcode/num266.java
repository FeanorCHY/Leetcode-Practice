package leedcode;

public class num266 {
    public boolean canPermutePalindrome(String s) {
    	int[] alp=new int[256];
    	char[] arr=s.toCharArray();
    	for(char each:arr){
    		alp[each]++;
    	}
    	boolean odd=false;
    	for(int i=0;i<256;i++){
    		if(alp[i]%2==1){
    			if(odd)
    				return false;
    			else
    				odd=true;
    		}
    	}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
