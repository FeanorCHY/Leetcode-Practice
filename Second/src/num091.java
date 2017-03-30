
public class num091 {

    //what for character other than digit? what if invalid one? such as '09' or '30'
    public int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        int dp[]=new int[s.length()];
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!='0'){
                dp[i]+=(i-1)>=0?dp[i-1]:1;
            }
            if(i>0){
                int num=arr[i]-'0'+(arr[i-1]-'0')*10;
                if(num>=10&&num<=26)
                    dp[i]+=(i-2)>=0?dp[i-2]:1;
            }
        }
        return dp[arr.length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
