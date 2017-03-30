package leedcode;

import java.util.Arrays;
import java.util.Comparator;

public class num452 {
    public int findMinArrowShots(int[][] points) {
    	if(points.length==0)
    		return 0;
    	Arrays.sort(points,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
			}
    	});
    	int count=1;
    	int min=points[0][1];
    	for(int i=1;i<points.length;i++){
    		if(points[i][0]>min){
    			count++;
    			min=points[i][1];
    		}
    		else
    			min=Math.min(min, points[i][1]);
    	}
        return count;
    }
	public static void main(String[] args) {
		int[][] test=
				{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
		num452 sol=new num452();
		System.out.println(sol.findMinArrowShots(test));
	}

}
