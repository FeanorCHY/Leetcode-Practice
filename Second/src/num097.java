
public class num097 {

    //time O(mn) space O(mn)
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s3==null||s1==null||s2==null||s1.length()+s2.length()!=s3.length())
//             return false;
//         if(s3.length()==0)
//             return true;
//         char[] arr1=s1.toCharArray();
//         char[] arr2=s2.toCharArray();
//         char[] arr3=s3.toCharArray();
//         return search(arr1,arr2,arr3,0,0,0,new boolean[arr1.length+1][arr2.length+1]);
//     }
//     private boolean search(char[] arr1,char[] arr2,char[] arr3,int idx1,int idx2,int idx,boolean[][] dp){
//         if(dp[idx1][idx2])
//             return false;
//         int x=idx1,y=idx2;
//         while(idx1<arr1.length||idx2<arr2.length){
//             if(idx1==arr1.length){
//                 if(arr2[idx2]==arr3[idx])
//                     idx2++;
//                 else{
//                     dp[x][y]=true;
//                     return false;
//                 }
//             }
//             else if(idx2==arr2.length){
//                 if(arr1[idx1]==arr3[idx])
//                     idx1++;
//                 else{
//                     dp[x][y]=true;
//                     return false;
//                 }
//             }
//             else{
//                 if(arr2[idx2]==arr3[idx]&&arr1[idx1]==arr3[idx]){
//                     if(search(arr1,arr2,arr3,idx1,idx2+1,idx+1,dp)||search(arr1,arr2,arr3,idx1+1,idx2,idx+1,dp))
//                         return true;
//                     else{
//                         dp[x][y]=true;
//                         return false;
//                     }
//                 }
//                 else if(arr2[idx2]==arr3[idx])
//                     idx2++;
//                 else if(arr1[idx1]==arr3[idx])
//                     idx1++;
//                 else{
//                     dp[x][y]=true;
//                     return false;
//                 }
//             }
            
            
//             idx++;
//         }
//         return true;
//     }
    
    
    //dp Time O(mn) Space O(mn)
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3==null||s1==null||s2==null||s1.length()+s2.length()!=s3.length())
            return false;
        if(s3.length()==0)
            return true;
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        char[] arr3=s3.toCharArray();
        boolean dp[][]=new boolean[arr1.length+1][arr2.length+1];
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]==arr3[i])
                dp[0][i+1]=true;
            else
                break;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==arr3[i])
                dp[i+1][0]=true;
            else
                break;
        }
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if((arr1[i]==arr3[i+j+1]&&dp[i][j+1])||(arr2[j]==arr3[i+j+1]&&dp[i+1][j]))
                    dp[i+1][j+1]=true;
            }
        }
        return dp[arr1.length][arr2.length];
    }
	public static void main(String[] args) {
		String s1="aaaaaaaaaa";
		String s2="aaaab";
		String s3="aaaaaaaaaaaaaab";
		num097 sol=new num097();
		System.out.println(sol.isInterleave(s1, s2, s3));
	}

}
