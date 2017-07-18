
public class num032 {

    public int longestValidParentheses(String s) {//take care of ")((()))("
        if(s==null||s.length()<2)
            return 0;
        char[] arr=s.toCharArray();
        int dp[]=new int[arr.length];
        int res=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==')'&&i-dp[i-1]-1>=0&&arr[i-dp[i-1]-1]=='('){
                dp[i]=dp[i-1]+2+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-1]:0);
                res=Math.max(res,dp[i]);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		num032 sol=new num032();
		System.out.println(sol.longestValidParentheses("()()"));
	}

}
