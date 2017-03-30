package leedcode;

public class num58 {

    public int lengthOfLastWord(String s) {
    	String strArr[]=s.split(" ");
    	if(strArr.length==0){
    	    return 0;
    	}
        return strArr[strArr.length-1].length();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
