package leedcode;

public class num122 {

    public int maxProfit(int[] prices) {
    	if(prices.length<=1)
    		return 0;
    	int low=prices[0];
    	int result=0;
    	int i=0;
    	for(;i<prices.length-1;i++){
    		if(prices[i]>prices[i+1]&&low!=-1){
    			result=result+prices[i]-low;
    			low=-1;
    		}
    		if(prices[i]<prices[i+1]&&low==-1){
    			low=prices[i];
    		}
    	}
    	if(low!=-1){
    		result=result+prices[i]-low;
    	}
    	
        return result;
    }
	public static void main(String[] args) {
		int test[]={4,2,3,1,4,6,7,2};
		num122 sol=new num122();
		System.out.println(sol.maxProfit(test));
	}

}
