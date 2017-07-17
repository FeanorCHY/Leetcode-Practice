
public class num044 {

    //dp Time O(mn) Space O(mn) 2 dimension
    // public boolean isMatch(String s, String p) {
    //     if(p==null||s==null)
    //         return false;
    //     char[] arrs=s.toCharArray();
    //     char[] arrp=p.toCharArray();
    //     boolean[][] dp=new boolean[arrs.length+1][arrp.length+1];
    //     dp[0][0]=true;
    //     int i=0;
    //     for(;i<arrp.length;i++){
    //         if(arrp[i]=='*'){
    //             for(int j=0;j<=arrs.length;j++)
    //                 dp[j][i+1]=true;
    //         }
    //         else
    //             break;
    //     }
    //     for(;i<arrp.length;i++){
    //         for(int j=0;j<arrs.length;j++){
    //             if(arrp[i]==arrs[j]||arrp[i]=='?'){
    //                 dp[j+1][i+1]=dp[j][i];
    //             }
    //             else if(arrp[i]=='*'){
    //                 dp[j+1][i+1]=dp[j][i+1]|dp[j+1][i];
    //             }
    //         }
    //     }
    //     return dp[arrs.length][arrp.length];
    // }
    
    
    //dp Time O(mn) Space O(m) 1 dimension
    // public boolean isMatch(String s, String p) {
    //     if(p==null||s==null)
    //         return false;
    //     char[] arrs=s.toCharArray();
    //     char[] arrp=p.toCharArray();
    //     boolean[] dp=new boolean[arrs.length+1];
    //     dp[0]=true;
    //     int i=0;
    //     if(arrp.length>0&&arrp[0]=='*'){
    //         for(int j=0;j<=arrs.length;j++)
    //             dp[j]=true;
    //     }
    //     while(i<arrp.length&&arrp[i]=='*')
    //         i++;
    //     for(;i<arrp.length;i++){
    //         boolean last=dp[0];
    //         for(int j=0;j<arrs.length;j++){
    //             boolean tem=dp[j+1];
    //             if(arrp[i]==arrs[j]||arrp[i]=='?'){
    //                 dp[j+1]=last;
    //             }
    //             else if(arrp[i]=='*'){
    //                 dp[j+1]=dp[j]|dp[j+1];
    //             }
    //             else
    //             	dp[j+1]=false;//keep this in mind!!!!
    //             last=tem;
    //         }
    //         dp[0]=false;
    //     }
    //     return dp[arrs.length];
    // }
    
    
    
    
    //good scan Time worst O(mn) best O(max(m,n)) Space O(1)
    public boolean isMatch(String s, String p) {
        if(p==null||s==null)
            return false;
        char[] arrs=s.toCharArray();
        char[] arrp=p.toCharArray();
        int i=0,j=0,lastStart=-1,match=-1;
        while(i<arrs.length){
            if(j<arrp.length&&(arrs[i]==arrp[j]||arrp[j]=='?')){
                i++;
                j++;
            }
            else if(j<arrp.length&&arrp[j]=='*'){
                match=i;
                lastStart=++j;
            }
            else if(lastStart!=-1){
                i=++match;
                j=lastStart;
            }
            else
                return false;
        }
        while(j<arrp.length&&arrp[j]=='*')
            j++;
        return j==arrp.length;
    }
	public static void main(String[] args) {
		num044 sol=new num044();
		System.out.println(sol.isMatch("zacabz", "*a?b*"));
	}

}
