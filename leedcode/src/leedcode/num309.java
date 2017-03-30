package leedcode;

public class num309 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int[] sell=new int[prices.length];
        int[] buy=new int[prices.length];
        buy[0]=-prices[0];
        sell[0]=0;
        for(int i=1;i<prices.length;i++){
        	sell[i]=Math.max(sell[i-1], buy[i-1]+prices[i]);
        	if(i-2>=0)
        		buy[i]=Math.max(buy[i-1], sell[i-2]-prices[i]);
        	else
        		buy[i]=Math.max(buy[i - 1], -prices[i]);
        }
        return sell[sell.length-1];
    }
//    public int tryGo(int[] dif,int index,int profit){
//    	int cur=profit;
//    	for(int i=index;i<dif.length;i++){
//    		if(dif[i]>0)
//    			cur=cur+dif[i];
//    		else{
//    			int p1=tryGo(dif,i+2,cur+dif[i]);
//    			int p2=0;
//    			if(i!=0&&p[i+1]>p[i-1])
//    				p2=tryGo(dif,i+1,cur)
//    				
//    		}
//    	}
//    	return profit;
//    }
	public static void main(String[] args) {
//		int test[]={1,2,3,4,5};
		int test[]={0,1,3,0,2,6};
		num309 sol=new num309();
		System.out.print(sol.maxProfit(test));
	}

}

//int sell=-1;
//int waste=-1;
//for(int i=prices.length-1;i>=1;i--){
//	if(prices[i]>prices[i-1]){
//		if(sell==-1)
//			sell=prices[i];
//		if(i==1){
//			profit+=sell-prices[0];
//		}
//	}
//	else if(sell!=-1){
//		if(i-1==0)
//			profit+=sell-prices[i];
//		else{
//			if(prices[i-1]-prices[i-2]>prices[i+1]-prices[i]){
//				if(waste)
//				profit+=sell-prices[i+1];
//				waste=-prices[i+1]-prices[i];
//				sell=-1;
//			}
//			else{
//				prices[i-1]=prices[i];//don't sell
////				profit+=sell-prices[i];
////				sell=-1;
////				i--;
//			}
//		}
//	}
//}