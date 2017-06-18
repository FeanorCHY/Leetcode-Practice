
public class num214 {

    //kmp Time O(N) Space O(N)
    // public String shortestPalindrome(String s) {
    //     if(s==null||s.length()==0)
    //         return "";
    //     String str=s+"^"+((new StringBuilder(s)).reverse().toString());
    //     char[] arr=str.toCharArray();
    //     int[] next=new int[arr.length];
    //     int res=0,idx=0;
    //     for(int i=1;i<arr.length;i++){
    //         if(arr[i]==arr[idx]){
    //             next[i]=++idx;
    //         }
    //         else{
    //             while(idx!=0&&arr[idx]!=arr[i]){
    //                 idx=next[idx-1];
    //             }
    //             if(arr[i]==arr[idx])
    //                 next[i]=++idx;
    //             else
    //                 next[i]=0;
    //         }
    //     }
    //     return ((new StringBuilder(s.substring(next[next.length-1]))).reverse().toString())+s;
    // }
    
    
    
    public String shortestPalindrome(String s) {
            int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + (s.substring(0, j)) + suffix;
    }
	public static void main(String[] args) {
		num214 sol=new num214();
		System.out.println(sol.shortestPalindrome("ababcbababa"));
		
	}

}
