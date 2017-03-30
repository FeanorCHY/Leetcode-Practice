package leedcode;

public class num415 {
    public String addStrings(String num1, String num2) {
    	StringBuilder sb=new StringBuilder();
    	char[] arr1=num1.toCharArray();
    	char[] arr2=num2.toCharArray();
    	int idx1=arr1.length-1;
    	int idx2=arr2.length-1;
    	int plus=0;
    	while(idx1>-1||idx2>-1){
    		int cur=(idx1<=-1?0:(arr1[idx1]-'0'))+(idx2<=-1?0:(arr2[idx2]-'0'))+plus;
    		sb.insert(0, cur%10);
    		plus=cur/10;
    		idx1--;
    		idx2--;
    		
    	}
    	if(plus==1)
    		sb.insert(0, 1);
    	
        return sb.toString();
    }
	public static void main(String[] args) {
		num415 sol=new num415();
		System.out.println(sol.addStrings("913", "0"));
	}

}
