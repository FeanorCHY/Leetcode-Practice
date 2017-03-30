package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num356 {
    public boolean isReflected(int[][] points) {
    	HashMap<Integer,Set<Integer>> map=new HashMap<Integer,Set<Integer>>();
    	for(int[] each:points){
    		if(map.containsKey(each[1])){
    			map.get(each[1]).add(each[0]);
    		}
    		else{
    			Set<Integer> list=new HashSet<Integer>();
    			list.add(each[0]);
    			map.put(each[1],list);
    		}
    	}
    	boolean begin=false;
    	double avg=0;//the middle line is the same for every point
    	for(int y:map.keySet()){
    		Set<Integer> each=map.get(y);
    		double sum=0;
    		double count=0;
    		for(int x:each){
    			sum+=x;
    			count++;
    		}
    		if(begin==false){
    			avg=sum/count;
    			begin=true;
    		}
    		else if(avg!=sum/count)//check if every mid is the same
				return false;
    	}
    	for(int[] each:points){
    		int ref=(int)(2*avg-(double)each[0]);
    		if(!map.get(each[1]).contains(ref))
    			return false;
    	}
    	
    	
        return true;
    }
	public static void main(String[] args) {
		int[][] test={{2,1},{-1,1},{-2,1}};
		num356 sol=new num356();
		System.out.println(sol.isReflected(test));
	}

}
