
public class num123 {

    //dynamic programming Time o(n) Space O(n)
    // public int maxProfit(int[] prices) {
    //     if(prices==null||prices.length==0)
    //         return 0;
    //     int[] sell=new int[prices.length];
    //     int[] buy=new int[prices.length];
    //     buy[0]=-prices[0];
    //     for(int i=1;i<prices.length;i++){
    //         buy[i]=Math.max(sell[i-1]-prices[i],buy[i-1]);
    //     }
    //     for(int i=1;i<prices.length;i++){
    //         sell[i]=Math.max(buy[i-1]+prices[i],sell[i-1]);
    //     }
    //     for(int i=1;i<prices.length;i++){
    //         buy[i]=Math.max(sell[i-1]-prices[i],buy[i-1]);
    //     }
    //     for(int i=1;i<prices.length;i++){
    //         sell[i]=Math.max(buy[i-1]+prices[i],sell[i-1]);
    //     }
    //     return Math.max(buy[prices.length-1],sell[prices.length-1]);
        
    // }
    
    //better dynamic programming Time o(n) Space O(1)
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int buy1=-prices[0],sell1=0,buy2=-prices[0],sell2=0;
        for(int i=1;i<prices.length;i++){
            sell2=Math.max(sell2,buy2+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy1=Math.max(buy1,-prices[i]);
        }
        return Math.max(buy2,sell2);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
