package leedcode;

public class num322 {
    public int coinChange(int[] coins, int amount) {
    	int dp[]=new int[amount+1];
    	for(int each:coins){
    		if(each>amount)
    			continue;
    		dp[each]=1;
    	}
    	boolean one=false;;
    	for(int i=1;i<dp.length;i++){
    		if(dp[i]==1){
    			one=true;
    			continue;
			}
    		if(one==false){
    			dp[i]=-1;
    			continue;
    		}
    		int lowest=Integer.MAX_VALUE;
    		for(int j=0;j<coins.length;j++){
    			if(i>coins[j]&&dp[i-coins[j]]>0&&dp[i-coins[j]]+1<lowest)
    				lowest=dp[i-coins[j]]+1;
    		}
    		if(lowest==Integer.MAX_VALUE)
    			dp[i]=-1;
    		else
    			dp[i]=lowest;
    	}
        return dp[amount];
    }
	public static void main(String[] args) {
		num322 sol=new num322();
		int[] test={1,3,5};
//		System.out.println(0x7fffffff);
		System.out.println(sol.coinChange(test, 11));
		
	}

}
