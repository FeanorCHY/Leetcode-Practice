import java.util.Stack;

public class num085 {

    //dynamic programming Time: O(M*N^2)
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int max=0;
        int[] dp=new int[matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[j]++;
                    int len=dp[j];
                    for(int k=j;k>=0&&len>0;k--){
                        len=Math.min(len,dp[k]);
                        max=Math.max(max,len*(j-k+1));
                    }
                }
                else
                	dp[j]=0;
            }
        }
        return max;
    }
    
    
    //dynamic programming with Stack Time: O(M*N) Space: O(N)
    // public int maximalRectangle(char[][] matrix) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return 0;
    //     int max=0;
    //     int[] dp=new int[matrix[0].length+1];
    //     for(int i=0;i<matrix.length;i++){
    //         Stack<Integer> st=new Stack<Integer>();
    //         for(int j=0;j<=matrix[0].length;j++){
    //             if(j<matrix[0].length){
    //                 if(matrix[i][j]=='1'){
    //                     dp[j]++;
    //                 }
    //                 else
    //                 	dp[j]=0;
    //             }
    //         	if(st.isEmpty()||dp[j]>=dp[st.peek()])
    //         	    st.push(j);
    //     	    else{
    //     	        while(!st.isEmpty()&&dp[j]<dp[st.peek()]){
    //     	            int top=st.pop();
    //     	            max=Math.max(max,(st.isEmpty()?j:(j-st.peek()-1))*dp[top]);
    //     	        }
    //         	    st.push(j);
    //     	    }
    //         }
    //     }
    //     return max;
    // }
	public static void main(String[] args) {
		char[][] test={"10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()};
		num085 sol=new num085();
		System.out.println(sol.maximalRectangle(test));
	}

}
