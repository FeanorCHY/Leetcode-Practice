package leedcode;

public class num389 {
    public char findTheDifference(String s, String t) {
    	int[] alp=new int[26];
    	char[] arr=s.toCharArray();
    	for(char each:arr)
    		alp[each-'a']++;
    	arr=t.toCharArray();
    	for(char each:arr){
    		alp[each-'a']--;
    		if(alp[each-'a']<0)
    			return each;
    	}
    	
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
