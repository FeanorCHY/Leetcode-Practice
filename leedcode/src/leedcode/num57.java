package leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class num57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals.size()==0){
    		intervals.add(newInterval);
    		return intervals;
    	}
    	List<Interval> res=new LinkedList<Interval>();
    	boolean filled=false;
    	for(int i=0;i<intervals.size();i++){
    		Interval cur=intervals.get(i);
    		if(!filled&&cur.start>=newInterval.start){
    			cur=newInterval;
    			i--;
    			filled=true;
    		}
    		if(!filled){
    			res.add(cur);
    		}
    		else{
    			if(i==-1){
    				res.add(newInterval);
    				continue;
    			}
    			Interval last=res.get(res.size()-1);
    			if(last.end>=cur.start){
    				last.end=Math.max(cur.end, last.end);
    			}
    			else
    				res.add(cur);
    		}
    	}
    	if(!filled){
			Interval last=res.get(res.size()-1);
			if(last.end>=newInterval.start){
				last.end=Math.max(newInterval.end, last.end);
			}
			else
				res.add(newInterval);
    		
    	}
    	
    	return res;
    }
	public static void main(String[] args) {
		List<Interval> intervals=new ArrayList<Interval>();// [1,2],[3,5],[6,7],[8,10],[12,16]
		Interval i1=new Interval(0,5);
		intervals.add(i1);
		i1=new Interval(8,9);
		intervals.add(i1);
		i1=new Interval(10,11);
		intervals.add(i1);
//		i1=new Interval(8,10);
//		intervals.add(i1);
//		i1=new Interval(12,16);
//		intervals.add(i1);
		num57 sol=new num57();
		intervals=sol.insert(intervals, new Interval(0,10));
		for(int i=0;i<intervals.size();i++){
			System.out.println(intervals.get(i).start+"  "+intervals.get(i).end);
		}
	}

}




//int less=0;
//while(less<intervals.size()&&intervals.get(less).start<newInterval.start){
//	less++;
//}
//if(less==intervals.size()){
//	if(intervals.get(less-1).end<newInterval.start){
//		intervals.add(newInterval);
//	}
//	else if(intervals.get(less-1).end<newInterval.end){
//		intervals.get(less-1).end=newInterval.end;
//	}
//	return intervals;
//}
//else if(less==0){
//	intervals.add(0, newInterval);
//	less++;
//	if(intervals.get(0).end>=intervals.get(less).start&&intervals.get(0).end<intervals.get(less).end)
//		intervals.get(0).end=intervals.get(less).end;
//	while(1<intervals.size()&&newInterval.end>=intervals.get(1).end){
//		intervals.remove(1);
//	}
//	if(1<intervals.size()&&intervals.get(0).end>=intervals.get(1).start){
//		intervals.get(0).end=intervals.get(1).end;
//		intervals.remove(1);
//	}
//	return intervals;
//}
//else 
//{
//	if(intervals.get(less-1).end>=newInterval.start){
//		if(intervals.get(less-1).end>=newInterval.end)
//			return intervals;
//		intervals.get(less-1).end=newInterval.end;
//		while(less<intervals.size()&&intervals.get(less).end<=newInterval.end)
//			intervals.remove(less);
//		if(less<intervals.size()){
//			if(intervals.get(less).start<=newInterval.end){
//				intervals.get(less-1).end=intervals.get(less).end;
//				intervals.remove(less);
//			}
//		}
//	}
//	else{
//		intervals.add(less, newInterval);
//		int end=less+1;
//		while(end<intervals.size()&&intervals.get(end).end<=newInterval.end){
//			intervals.remove(end);
//		}
//		if(end<intervals.size()){
//			if(intervals.get(end).start<=intervals.get(less).end){
//				intervals.get(less).end=intervals.get(end).end;
//				intervals.remove(end);
//			}
//		}
//		
//	}
//	return intervals;
//}