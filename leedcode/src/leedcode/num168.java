package leedcode;

public class num168 {
    public String convertToTitle(int n) {
    	n--;
    	StringBuilder sb=new StringBuilder();
    	while(n>=0){
    		int cur=n%26;
    		n=n/26-1;
    		sb.insert(0, (char)(cur+'A'));
    	}
    	
    	return sb.toString();
    }
	public static void main(String[] args) {
		num168 sol=new num168();
		System.out.println(sol.convertToTitle(26*26+26));
	}

}
