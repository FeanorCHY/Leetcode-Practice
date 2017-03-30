
public class num309 {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int[] sell=new int[prices.length];
        int[] buy=new int[prices.length];
        buy[0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            if(i>1)
                buy[i]=Math.max(sell[i-2]-prices[i],buy[i-1]);
            else
                buy[i]=Math.max(-prices[i],buy[i-1]);
        }
        return sell[prices.length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
