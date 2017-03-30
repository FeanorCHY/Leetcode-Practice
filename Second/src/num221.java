
public class num221 {
    //brute force O((MN)^2) Space O(1)
    // char[][] matrix;
    // public int maximalSquare(char[][] matrix) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return 0;
    //     this.matrix=matrix;
    //     int max=0;
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             if(matrix[i][j]=='1')
    //                 max=Math.max(max,search(i,j));
    //         }
    //     }
    //     return max;
    // }
    // private int search(int x,int y){
        
    //     int len=1;
    //     int px=x+1;
    //     int py=y+1;
    //     while(px<matrix.length&&py<matrix[0].length){
    //         boolean suc=true;
    //         for(int i=0;i<=len;i++){
    //             if(matrix[px][y+i]=='0'){
    //                 suc=false;
    //                 break;
    //             }
    //         }
    //         if(!suc)
    //             break;
    //         for(int i=0;i<len;i++){
    //             if(matrix[x+i][py]=='0'){
    //                 suc=false;
    //                 break;
    //             }
    //         }
    //         if(!suc)
    //             break;
    //         len++;
    //         px++;
    //         py++;
    //     }
    //     return len*len;
    // }
    
    
    
    
    
    //dynamic programming O(MN) Space O(MN)
    // public int maximalSquare(char[][] matrix) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return 0;
    //     int max=0;
    //     int[][] dp=new int[matrix.length+1][matrix[0].length+1];
    //     for(int i=1;i<=matrix.length;i++){
    //         for(int j=1;j<=matrix[0].length;j++){
    //             if(matrix[i-1][j-1]=='1'){
    //                 dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
    //                 max=Math.max(max,dp[i][j]);
    //             }
    //         }
    //     }
    //     return max*max;
    // }
    
    
    
    //optimized dynamic programming O(MN) Space O(M)
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int max=0;
        int[] dp=new int[matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++){
            int pre=0;
            for(int j=1;j<=matrix[0].length;j++){
                int tem=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(Math.min(dp[j],dp[j-1]),pre)+1;
                    max=Math.max(max,dp[j]);
                }
                else
                	dp[j]=0;
                pre=tem;
            }
        }
        return max*max;
    }
	public static void main(String[] args) {
		num221 sol=new num221();
		char[][] test={"10111".toCharArray(),"01010".toCharArray(),"11011".toCharArray(),"11011".toCharArray(),"01111".toCharArray()};
		System.out.println(sol.maximalSquare(test));
	}

}
