package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num401 {
    public List<String> readBinaryWatch(int num) {
    	List<String> res=new ArrayList<String>();
    	for(int i=0;i<=Math.min(num,4);i++){
    		List<Integer> list1=new ArrayList<Integer>();
    		List<Integer> list2=new ArrayList<Integer>();
    		
    		int min=num-i;
    		findmin(0,0,min,list1);
    		findho(0,0,i,list2);
    		for(int ho:list2){
    			for(int mi:list1){
    				res.add(ho+":"+(mi<10?"0":"")+mi);
    			}
    		}
    		
    	}
    	
    	return res;
    }
    private void findmin(int sum,int begin,int cur,List<Integer> list){
    	if(cur==0){
    		list.add(sum);
    		return;
    	}
    	for(int i=begin;i<=5;i++){
    		if(sum+(1<<i)<=59)
    			findmin(sum+(1<<i),i+1,cur-1,list);
    	}
    }
    private void findho(int sum,int begin,int cur,List<Integer> list){
    	if(cur==0){
    		list.add(sum);
    		return;
    	}
    	for(int i=begin;i<=3;i++){
    		if(sum+(1<<i)<=11)
    			findho(sum+(1<<i),i+1,cur-1,list);
    	}
    }
	public static void main(String[] args) {
		num401 sol=new num401();
		System.out.println(sol.readBinaryWatch(2));
	}

}
