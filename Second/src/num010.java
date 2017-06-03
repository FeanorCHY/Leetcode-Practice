
public class num010 {
    //recursive Time: WorstO(Ns^Np)
    // public boolean isMatch(String s, String p) {
    //     if(s==null||p==null)
    //         return false;
    //     char[] arrs=s.toCharArray();
    //     char[] arrp=p.toCharArray();
    //     int idx=0;
    //     while(idx<arrs.length&&idx<arrp.length){
    //         if(arrs[idx]==arrp[idx]||arrp[idx]=='.')
    //             idx++;
    //         else if(arrp[idx]=='*'){
    //             if(idx==0)
    //                 return false;
    //             else if(arrp[idx-1]=='.'){//still need to search
    //                 for(int i=idx-1;i<=arrs.length;i++){
    //                     if(isMatch(s.substring(i),p.substring(idx+1)))
    //                         return true;
    //                 }
    //                 return false;
    //             }
    //             for(int i=idx-1;i<=arrs.length;i++){
    //                 if(i>idx-1&&arrs[i-1]!=arrp[idx-1])//remember the match of last character
    //                     break;  
    //                 if(isMatch(s.substring(i),p.substring(idx+1)))
    //                     return true;
    //             }
    //             return false;
    //         }
    //         else{
    //             if(idx+1<arrp.length&&arrp[idx+1]=='*')
    //                 return isMatch(s.substring(idx),p.substring(idx+2));
    //             return false;
    //         }
    //     }
    //     if(arrs.length==arrp.length&&idx==arrs.length)
    //         return true;
    //     else if(idx<arrs.length)
    //         return false;
    //     else{
    //         if(arrp[idx]=='*'){
    //             if(isMatch(s.substring(s.length()-1),p.substring(idx+1)))
    //                 return true;
    //             idx++;
    //         }
    //         for(;idx<arrp.length;idx+=2){
    //             if(arrp[idx]=='*'||idx+1==arrp.length||arrp[idx+1]!='*')
    //                 return false;
    //         }
    //         return true;
    //     }
    // }
    
    
    //dynamic programming Time O(Na*Nb) Space O(Na*Nb)
    public boolean isMatch(String s, String p) {
        if(s==null||p==null)
            return false;
        char[] arrs=s.toCharArray();
        char[] arrp=p.toCharArray();
        boolean dp[][]=new boolean[arrs.length+1][arrp.length+1];
        dp[0][0]=true;
        for(int i=0;i+1<arrp.length;i+=2){
            if(arrp[i]=='*'||arrp[i+1]!='*')
                break;
            dp[0][i+1]=true;
            dp[0][i+2]=true;
        }
        for(int i=0;i<arrs.length;i++){
            for(int j=0;j<arrp.length;j++){
                if(arrs[i]==arrp[j]||arrp[j]=='.'){
                        dp[i+1][j+1]=dp[i][j];
                }
                else if(arrp[j]=='*'){
                    if(j==0)
                        return false;
                    else{
                    	if(arrs[i]==arrp[j-1]||arrp[j-1]=='.')
                    		dp[i+1][j+1]=dp[i][j+1]|dp[i+1][j-1];
                    	else
                			dp[i+1][j+1]=dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[arrs.length][arrp.length];
    }
	public static void main(String[] args) {
		num010 sol=new num010();
		System.out.println(sol.isMatch("aaa", "ab*a*c*a"));

	}

}



//else if(i==0){
//    if(arrs[i]==arrp[j-1]||arrp[j-1]=='.')
//        dp[i+1][j+1]=dp[i][j-1];
//}
//else{
//    if(arrp[j-1]=='.')
//        dp[i+1][j+1]=dp[i][j+1];
//    else if(arrs[i]==arrs[i-1]){
//        if(arrs[i]==arrp[j-1])
//            dp[i+1][j+1]=dp[i][j+1];
//        else
//            dp[i+1][j+1]=dp[i+1][j-1];
//    }
//    else if(arrs[i]==arrp[j-1])
//        dp[i+1][j+1]=dp[i][j-1];
//}