package leedcode;

public class num87 {

    public boolean isScramble(String s1, String s2) {
    	char[] arr1=s1.toCharArray();
    	char[] arr2=s2.toCharArray();
    	if(s1.equals(s2))
    		return true;
    	char[] let=new char[26];
    	for(int i=0;i<arr1.length;i++){
    		let[arr1[i]-'a']++;
    		let[arr2[i]-'a']--;
    	}
    	for(int i=0;i<26;i++){
    		if(let[i]!=0)
    			return false;
    	}
    	for(int i=0;i<arr1.length-1;i++){
    		if(isScramble(s1.substring(0,i+1),s2.substring(0,i+1))&&isScramble(s1.substring(i+1),s2.substring(i+1)))
    			return true;
    		if(isScramble(s1.substring(0,i+1),s2.substring(arr2.length-i-1))&&isScramble(s1.substring(i+1),s2.substring(0,arr2.length-i-1)))
    			return true;
    	}
    	
    	
    	
        return false;
    }
	public static void main(String[] args) {
		num87 sol=new num87();
		System.out.println(sol.isScramble("abcd", "cabd"));
	}

}
