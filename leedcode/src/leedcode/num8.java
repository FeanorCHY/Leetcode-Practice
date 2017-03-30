package leedcode;

public class num8 {

    static int myAtoi(String str) {
    	boolean begin=false;
    	long value=0;
    	boolean minus=false;
    	boolean end=false;
    	boolean space=true;
    	boolean max=false;
    	for(int i=0;i<str.length();i++)
    	{
    		char charIn=str.charAt(i);
    		if(charIn==32&&space==false)
    			end=true;
    		if(!(charIn==43||charIn==45||(charIn>=48&&charIn<=57)||charIn==32))
    			end=true;
    		if(end==false&&(charIn==43||charIn==45||(charIn>=48&&charIn<=57)))
    		{
    			space=false;
    			if(begin==true&&(charIn==43||charIn==45))
    				end=true;
    			begin=true;
    			if(charIn==45)
    				minus=true;
    			if(charIn>=48&&charIn<=57&&end==false&&max==false)
    			    value=value*10+Long.valueOf(str.charAt(i)+"");
    	    	if(value>Integer.MAX_VALUE&&minus==true)
    	    	    return Integer.MIN_VALUE;
    	    	if(value>Integer.MAX_VALUE)
    	    		return Integer.MAX_VALUE;
    		}
    		
    	}
    	if(value<0)
    		value=0-value;
    	if(minus==true)
    		value=0-value;
    	if(value>Integer.MAX_VALUE)
    		return Integer.MAX_VALUE;
    	if(value<Integer.MIN_VALUE)
    	    return Integer.MIN_VALUE;
    	return (int)value;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="-2147483648";
		System.out.println(myAtoi(str));

	}

}
