package leedcode;

public class num383 {
    public boolean canConstruct(String ransomNote, String magazine) {
    	int[] alp=new int[26];
    	char[] arr=magazine.toCharArray();
    	for(char each:arr){
    		alp[each-'a']++;
    	}
    	arr=ransomNote.toCharArray();
    	for(char each:arr){
    		alp[each-'a']--;
    		if(alp[each-'a']<0)
    			return false;
    	}
    	
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
