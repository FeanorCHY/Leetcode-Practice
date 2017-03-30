package leedcode;

public class num242 {
    public boolean isAnagram(String s, String t) {
    	if(s.length()!=t.length())
    		return false;
    	int[] is=new int[26];
    	int[] it=new int[26];
    	char[] arrs=s.toCharArray();
    	char[] arrt=t.toCharArray();
    	for(int i=0;i<arrs.length;i++){
    		is[arrs[i]-'a']++;
    		it[arrt[i]-'a']++;
    	}
    	for(int i=0;i<26;i++){
    		if(is[i]!=it[i])
    			return false;
    	}
    	
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
