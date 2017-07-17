
public class num087 {

    //violent Time o(n!) space O(n)
    public boolean isScramble(String s1, String s2) {
        if(s1==null||s2==null)
            return false;
        if(s1.equals(s2))
            return true;
        int[] alp=new int[26];
        for(int i=0;i<s1.length();i++){
            alp[s1.charAt(i)-'a']++;
            alp[s2.charAt(i)-'a']--;
        }
        for(int each:alp){
            if(each!=0)
                return false;
        }
        for(int i=0;i<s1.length()-1;i++){
            if(isScramble(s1.substring(0,i+1),s2.substring(0,i+1))&&isScramble(s1.substring(i+1),s2.substring(i+1)))
                return true;
            if(isScramble(s1.substring(0,i+1),s2.substring(s2.length()-i-1))&&isScramble(s1.substring(i+1),s2.substring(0,s2.length()-i-1)))
                return true;
        }
        return false;
    }
	public static void main(String[] args) {
		num087 sol=new num087();
		System.out.println(sol.isScramble("ab", "ba"));
	}

}
