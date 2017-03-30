package leedcode;

public class num188 {
    private int max(int[] prices) {
        int max = 0;
        for(int i=1; i<prices.length; i++) {
            max += Math.max(0, prices[i] - prices[i-1]);
        }
        return max;
    }
    public int maxProfit(int k, int[] prices) {
    	if(k<1)
    		return 0;
    	if(prices.length==0)
    		return 0;
        int n = prices.length;
        if (k >= n/2) return max(prices);
    	int[] buy=new int[prices.length];
    	int[] sell=new int[prices.length];
//    	int[] nextbuy=new int[prices.length];
    	int[] nextsell=new int[prices.length];
    	int sold=prices.length-1;
    	buy[0]=-prices[0];
    	for(int i=1;i<prices.length;i++){
    		buy[i]=Math.max(-prices[i], buy[i-1]);
    		nextsell[i]=Math.max(buy[i-1]+prices[i], nextsell[i-1]);
    		if(nextsell[i]>0&&sold==prices.length-1)
    			sold=i;
    	}
    	if(k==1)
    		return nextsell[prices.length-1];
    	for(int t=2;t<=k;t++){
        	sell=nextsell;
        	nextsell=new int[prices.length];
    		if(sold+1>=prices.length)
    			return sell[prices.length-1];
			buy[sold+1]=sell[sold]-prices[sold+1];
			nextsell[sold+1]=sell[sold+1];
    		for(int i=sold+2;i<prices.length;i++){
    			buy[i]=Math.max(sell[i-1]-prices[i], buy[i-1]);
    			nextsell[i]=Math.max(sell[i],Math.max(nextsell[i-1], buy[i-1]+prices[i]));
    		}
    		if(sell[prices.length-1]==nextsell[prices.length-1])
    			return nextsell[prices.length-1];
    	}
    	return nextsell[prices.length-1];
    }
	public static void main(String[] args) {
		int[] test={1,2,0,3,6,7,6,2};
		num188 sol=new num188();
		System.out.println(sol.maxProfit(4, test));
	}

}
