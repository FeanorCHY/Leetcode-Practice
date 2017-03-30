
public class num121 {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int min=Integer.MAX_VALUE;
        int res=0;
        for(int each:prices){
            res=Math.max(each-min,res);
            min=Math.min(each,min);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
