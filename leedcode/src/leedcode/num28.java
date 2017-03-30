package leedcode;

public class num28 {
    public int strStr(String haystack, String needle) {
    	int index =0;
    	for(int i=0;i<=haystack.length()-needle.length();i++){
    		if(haystack.substring(i,needle.length()+i).equals(needle))
    			return i;
    	}
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num28 sol=new num28();
		String str="1234567890";
		System.out.println(str.substring(1,1));
	}

}
