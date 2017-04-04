import java.util.Arrays;
import java.util.Comparator;

public class num474 {
	//search failed O(2^N)
    // int res=0;
    // int m,n;
    // int[] zeros,ones;
    // // boolean visit[];
    // public int findMaxForm(String[] strs, int m, int n) {
    //     if(strs==null||strs.length==0)
    //         return 0;
    //     Arrays.sort(strs,new Comparator<String>(){
    //         @Override
    //         public int compare(String str1,String str2){
    //             return str1.length()-str2.length();
    //         }
    //     });
    //     this.m=m;
    //     this.n=n;
    //     ones=new int[strs.length];
    //     zeros=new int[strs.length];
    //     for(int i=0;i<strs.length;i++){
    //         int one=0,zero=0;
    //         char[] arr=strs[i].toCharArray();
    //         for(char c:arr){
    //             if(c=='0')
    //                 zero++;
    //             else
    //                 one++;
    //         }
    //         ones[i]=one;
    //         zeros[i]=zero;
    //     }
    //     // visit=new boolean[strs.length];
    //     search(0,0,0,0);
    //     return res;
    // }
    // private void search(int one,int zero,int cur,int idx){
    //     if(idx==ones.length){
    //         res=Math.max(cur,res);
    //         return;
    //     }
    //     if(ones[idx]+one<=n&&zeros[idx]+zero<=m){
    //         search(ones[idx]+one,zeros[idx]+zero,cur+1,idx+1);
    //     }
    //     else if(ones[idx]+one>n&&zeros[idx]+zero>m){
    //         res=Math.max(cur,res);
    //         return;
    //     }
    //     search(one,zero,cur,idx+1);
    // }
    
    
    
    
    //DP Time O(MNK) Space O(MN)
     public int findMaxForm(String[] strs, int m, int n) {
         if(strs==null||strs.length==0)
             return 0;
         int[][] dp=new int[m+1][n+1];
         for(String str:strs){
             int[] zo=tran(str);
             for(int i=m;i>=zo[0];i--)
                 for(int j=n;j>=zo[1];j--)
                     dp[i][j]=Math.max(dp[i][j],1+dp[i-zo[0]][j-zo[1]]);
         }
         return dp[m][n];
     }
     private int[] tran(String str){
         int one=0,zero=0;
         char[] arr=str.toCharArray();
         for(char c:arr){
             if(c=='0')
                 zero++;
             else
                 one++;
         }
         return new int[]{zero,one};
     }
    
    
	public static void main(String[] args) {
		String[] test={"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
		num474 sol=new num474();
		System.out.println(sol.findMaxForm(test, 90, 66));
	}

}
