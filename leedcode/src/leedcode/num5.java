package leedcode;

public class num5 {
	static String longestPalindrome(String s) {
		String longest="";
		for(int i=0;i<s.length();i++){
			int length=0;
//			int gap=0;
//			if(i==0){
//				length=1;
//				gap=1;
//			}
//			else if(i>0&&s.charAt(i)==)
			int j=1;
			boolean noFound=true;
			while(i+j<s.length()&&i-j+1>=0&&noFound)
			{
				if(s.charAt(i+j)==s.charAt(i-j+1))
				{
					length=length+2;
					j++;
				}
				else
					noFound=false;
			}
			if(length>longest.length())
			{
				j=j-1;
				longest=s.substring(i-j+1,i+j+1);
			}
			j=1;
			length=1;
			noFound=true;
			while(i+j<s.length()&&i-j>=0&&noFound)
			{
				if(s.charAt(i+j)==s.charAt(i-j))
				{
					length=length+2;
					j++;
				}
				else
					noFound=false;
			}
			if(length>longest.length())
			{
				j=j-1;
				longest=s.substring(i-j,i+j+1);
			}
		}
		return longest;
		  
	}
//    static String longestPalindrome(String s) {
//        String str="";
//        String longest="";
//    	for(int i=0;i<s.length();i++)
//        {
//        	for(int j=i;j<s.length();j++)
//        	{
//        		str=str+s.charAt(j);
//        		if(str.length()>longest.length()&&isPal(str))
//        			longest=str+"";
//        	}
//        	str="";
//        }
//    	return longest;
//    }
//    static boolean isPal(String str)
//    {
//    	String str1;
//    	String str2;
//    	if(str.length()<=1)
//    		return true;
//    	if(str.length()%2==1)
//    	{
//    		str1=str.substring(0, (str.length()-1)/2);
//    		str2=str.substring((str.length()-1)/2+1, str.length());
//    	}
//    	else
//    	{
//    		str1=str.substring(0, (str.length()-1)/2+1);
//    		str2=str.substring((str.length()-1)/2+1, str.length());
//    	}
//    	for(int i=0;i<str1.length();i++)
//    	{
//    		if(str1.charAt(i)!=str2.charAt(str1.length()-1-i))
//    			return false;
//    	}
//    	return true;
//    }

	public static void main(String[] args) {
		String str="abcbe";
		System.out.println(longestPalindrome(str));
	}

}
