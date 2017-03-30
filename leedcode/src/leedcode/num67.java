package leedcode;

public class num67 {

    public String addBinary(String a, String b) {
    	char[] minStr=a.length()>b.length()?b.toCharArray():a.toCharArray();
    	char[] maxStr=a.length()>b.length()?a.toCharArray():b.toCharArray();
    	int diff=maxStr.length-minStr.length;
    	String result="";
    	int over=0;
    	for(int i=minStr.length-1;i>=0;i--)
    	{
    		result=(minStr[i]+maxStr[diff+i]- '0'- '0'+over)%2+result;
    		if(minStr[i]+maxStr[diff+i]- '0'- '0'+over>1){
    			over=1;
    		}
    		else{
    			over=0;
    		}
    	}
    	for(int i=maxStr.length-minStr.length-1;i>=0;i--)
    	{
    		result=(maxStr[i]-'0'+over)%2+result;
    		if(maxStr[i]-'0'+over>1){
    			over=1;
    		}
    		else{
    			over=0;
    		}
    	}
    	if(over==1){
    		result="1"+result;
    	}
        return result;
    }
	public static void main(String[] args) {
//		String a="1";
//		System.out.println(a.substring(0,1));
		num67 sol=new num67();
		System.out.println(sol.addBinary("101111", "10"));
	}

}
