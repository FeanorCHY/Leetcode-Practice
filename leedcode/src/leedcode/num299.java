package leedcode;

public class num299 {
    public String getHint(String secret, String guess) {
    	int A=0;
    	int[] sarr=new int[10];
    	int[] garr=new int[10];
    	char[] s=secret.toCharArray();
    	char[] g=guess.toCharArray();
    	for(int i=0;i<s.length;i++){
    		if(s[i]==g[i])
    			A++;
    		else{
    			sarr[s[i]-'0']++;
    			garr[g[i]-'0']++;
    		}
    	}
    	int B=0;
    	for(int i=0;i<10;i++){
    		B+=Math.min(garr[i], sarr[i]);
    	}
    	
    	
        return A+"A"+B+"B";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
