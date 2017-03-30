package leedcode;

public class num6 {
	static String convert(String s, int numRows) {
		String out="";
		String[] StringArr=new String[numRows];
		for(int i=0;i<numRows;i++)
		{
			StringArr[i]="";
		}
		for(int index=0;index<s.length();index++)
		{
			for(int i=0;i<numRows&&index<s.length();i++,index++)
			{
				StringArr[i]=StringArr[i]+s.charAt(index);
			}
			for(int j=numRows-2;j>0&&index<s.length();j--,index++)
				StringArr[j]=StringArr[j]+s.charAt(index);
			index--;
		}
		for(int i=0;i<numRows;i++)
		{
			out=out+StringArr[i];
		}
		return out;
				
	        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("ABCD", 2));
	}

}
