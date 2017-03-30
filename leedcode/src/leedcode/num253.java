package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class num253 {
    public int minMeetingRooms(Interval[] intervals) {
    	List<Integer> sch=new ArrayList<Integer>();
    	if(intervals==null)
    		return 0;
    	if(intervals.length==0)
    		return 0;
    	if(intervals.length==1)
    		return 1;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });
        sch.add(intervals[0].end);
        for(int i=1;i<intervals.length;i++){
        	boolean find=false;
        	for(int j=0;j<sch.size();j++){
        		if(sch.get(j)<=intervals[i].start){
        			sch.set(j, intervals[i].end);
        			find=true;
        			break;
        		}
        	}
        	if(find==false)
        		sch.add(intervals[i].end);
        }
    	
    	
        return sch.size();
    }
	public static void main(String[] args) {//[[9,14],[5,6],[3,5],[12,19]]
		Interval[] test=new Interval[3];
		test[0]=new Interval(9,14);
		test[1]=new Interval(5,6);
		test[2]=new Interval(3,5);
		test[2]=new Interval(12,19);
		num253 sol=new num253();
		System.out.println(sol.minMeetingRooms(test));
	}

}
