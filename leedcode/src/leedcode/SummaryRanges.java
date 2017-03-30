package leedcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class SummaryRanges {
	TreeSet<Interval> set;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        set=new TreeSet<Interval>(new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
        	
        });
    }
    
    public void addNum(int val) {
    	Iterator<Interval> it=set.iterator();
    	Interval last=null;
    	Interval delete=null;
    	boolean add=false;
        while(it.hasNext()){
        	Interval each=it.next();
        	if(val>=each.start&&val<=each.end)
        		return;
        	else if(val<each.start){
        		add=true;
        		if(last==null){
        			if(val==each.start-1)
        				each.start=val;
    				else
    					set.add(new Interval(val,val));
        			return;
        		}
        		else{
        			if(val==each.start-1&&val==last.end+1){
        				delete=each;
        				last.end=each.end;
        			}
        			else if(val==each.start-1){
        				each.start=val;
        			}
        			else if(val==last.end+1)
        				last.end=val;
        			else
        				add=false;
        			
        		}
        		break;
        	}
        		last=each;
        }
        if(delete!=null)
        	set.remove(delete);
        if(!add){
			if(last!=null&&val==last.end+1)
				last.end=val;
			else
				set.add(new Interval(val,val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(set);
    }
}
