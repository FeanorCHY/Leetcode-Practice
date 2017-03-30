package leedcode;

public class num66 {
    public int[] plusOne(int[] digits) {
		boolean over=true;
    	for(int i=digits.length-1;i>=0&&over;i--)
    	{
    		if(digits[i]==9){
    			over=true;
    		}
    		else
    			over=false;
    		digits[i]=(digits[i]+1)%10;
    	}
    	if(over==true)
    	{
    		int[] newone=new int[digits.length+1];
    		newone[0]=1;
    		for(int i=0;i<digits.length;i++)
    		{
    			newone[i+1]=digits[i];
    		}
            return newone;
    	}
        return digits;
    }
	public static void main(String[] args) {
		num66 sol=new num66();
		int[] test={9};
		sol.plusOne(test);
	}

}
