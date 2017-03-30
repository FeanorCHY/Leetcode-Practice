package leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num123 {
    public int maxProfit(int[] prices) {
    	if(prices.length<2)
    		return 0;
    	List<Integer> list=new ArrayList<Integer>();
    	boolean ins=true;
    	for(int i=1;i<prices.length;i++){
    		if(ins&&prices[i]>prices[i-1]){
    			list.add(prices[i-1]);
    			ins=false;
    		}
    		else if(!ins&&(prices[i]<prices[i-1]||i==prices.length-1)){
    			if(i==prices.length-1)
    				list.add(prices[i]);
    			else
    				list.add(prices[i-1]);
    			ins=true;
    		}
    	}
    	int[] buy1=new int[prices.length];
    	int[] sell1=new int[prices.length];
    	int[] buy2=new int[prices.length];
    	int[] sell2=new int[prices.length];
    	buy1[0]=-prices[0];
    	buy2[0]=-prices[0];
    	for(int i=1;i<prices.length;i++){
    		buy1[i]=Math.max(-prices[i], buy1[i-1]);
    		sell1[i]=Math.max(buy1[i-1]+prices[i], sell1[i-1]);
    		buy2[i]=Math.max(buy2[i-1], sell1[i-1]-prices[i]);
    		sell2[i]=Math.max(buy2[i-1]+prices[i], sell2[i-1]);
    	}
    	
    	
        return sell2[sell2.length-1];//Math.max(sell2[sell2.length-1], buy2[buy2.length-1]);
    }
	public static void main(String[] args) {
		int[] test={7,1,5,3,6};
		num123 sol=new num123();
		System.out.println(sol.maxProfit(test));
	}

}
