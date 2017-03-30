package leedcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class num435 {
    public int eraseOverlapIntervals(Interval[] intvs) {
    	if(intvs.length==0)
    		return 0;
    	Arrays.sort(intvs,new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start==o2.start?(o2.end-o1.end):(o1.start-o2.start);
			}
    	});
    	int count=0;
    	for(int i=intvs.length-2;i>=0;i--){
    		if(intvs[i].end>intvs[i+1].start){
    			count++;
    			intvs[i].start=intvs[i+1].start;
    		}
    			
    	}
    	
    	return count;
    }
	public static void main(String[] args) {
		int test[][]=
				{ {1,2}, {2,3}, {3,4}, {1,3} };
		Interval[] intvs=new Interval[test.length];
		for(int i=0;i<test.length;i++){
			intvs[i]=new Interval(test[i][0],test[i][1]);
		}
		num435 sol=new num435();
		System.out.println(sol.eraseOverlapIntervals(intvs));
	}

}
