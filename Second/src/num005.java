
public class num005 {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
                if(dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    //O(n^2) calculation number at worst same to the algorithm above
    // public String longestPalindrome(String s) {
    //     if(s==null)
    //         return "";
    //     int l=0,r=1;
    //     char[] arr=s.toCharArray();
    //     boolean[][] dp=new boolean[arr.length][arr.length];
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=0;j<arr.length-i;j++){
    //             if(i==0||(i==1&&arr[j]==arr[i+j]))
    //                 dp[i][j]=true;
    //             else if(i>1&&arr[j]==arr[i+j]){
    //                 if(dp[i-2][j+1]){
    //                     dp[i][j]=true;
    //                 }
    //             }
    //             if(dp[i][j]){
    //                 l=j;
    //                 r=i+j+1;
    //             }
    //         }
    //     }
    //     return s.substring(l,r);
    // }
}
