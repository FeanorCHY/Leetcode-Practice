package leedcode;

public class num43 {
    public String multiply(String num1, String num2) {
    	if(num1.length()==1)
    		if(Integer.parseInt(num1)==0)
    			return"0";
    	if(num2.length()==1)
    		if(Integer.parseInt(num2)==0)
    			return"0";
    	int maxPos=num1.length()+num2.length()-1;
    	String result="";
    	StringBuffer sb=new StringBuffer(num1);
    	num1=(new StringBuffer(num1)).reverse().toString();
    	num2=(new StringBuffer(num2)).reverse().toString();
    	String minStr=num1.length()>num2.length() ?num2:num1;
    	String maxStr=num1.length()<=num2.length() ?num2:num1;
    	int over=0;
    	for(int i=0;i<maxPos;i++)
    	{
    		int Indexmax;
    		int Indexmin;
    		if(i>maxStr.length()-1){
    			Indexmax=maxStr.length()-1;
    			Indexmin=i-Indexmax;
    		}
    		else{
    			Indexmax=i;
    			Indexmin=0;
    		}
    		while(Indexmax>=0&&Indexmin<minStr.length()){
    			int i1=maxStr.charAt(Indexmax)-'0';
    			int i2=(minStr.charAt(Indexmin)-'0');
    			over=(maxStr.charAt(Indexmax)-'0')*(minStr.charAt(Indexmin)-'0')+over;
    			Indexmax--;
    			Indexmin++;
    		}
    		
    		result=(over-(over/10)*10)+result;
    		over=over/10;
    	}
    	if(over!=0)
    		return over+result;
    	else
            return result;
    }
	public static void main(String[] args) {
		num43 sol=new num43();
		System.out.println(sol.multiply("2", "3"));
	}

}
