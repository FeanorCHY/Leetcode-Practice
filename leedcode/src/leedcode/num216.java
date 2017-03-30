package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num216 {
	List<List<Integer>> listlist=new ArrayList<List<Integer>>();
	int sum;
	int count;
    public List<List<Integer>> combinationSum3(int k, int n) {
        sum=n;
        count=k;
        find(new ArrayList<Integer>(),1,0,0);
        return listlist;
    }
    public void find(List<Integer> list,int index,int curCount,int curSum){
    	if(curCount==count-1){
    		if(sum-curSum>=index&&sum-curSum<=9){
    			list.add(sum-curSum);
    			listlist.add(list);
    		}
    		else
    			return;
    	}
    	else{
    		for(int i=index;i<=9;i++){
    			if(i+i+1+curSum>sum)
    				return;
    			List<Integer> newlist=new ArrayList<Integer>(list);
    			newlist.add(i);
    			find(newlist,i+1,curCount+1,curSum+i);
    		}
    	}
    }
	public static void main(String[] args) {
		num216 sol=new num216();
		System.out.println(sol.combinationSum3(3, 9));
	}

}
