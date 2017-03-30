package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class num56 {
    public List<Interval> merge(List<Interval> intervals) {
    	Collections.sort(intervals,new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
    		
    	});
    	List<Interval> result=new ArrayList<Interval>();
    	for(int i=0;i<intervals.size();i++){
    		if(result.isEmpty()){
    			result.add(intervals.get(i));
    		}
    		else{
    			Interval last=result.get(result.size()-1);
    			Interval each=intervals.get(i);
    			if(each.start<=last.end&&each.end>last.end){
    				last.end=each.end;
    			}
    			else if(each.start>last.end){
    				result.add(each);
    			}
    			
    		}
    	}
    	
        return result;
    }

	public static void main(String[] args) {
	}

}
