package leedcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class num149 {
    public int maxPoints(Point[] points) {
    	int max=2;
    	if(points.length<=2)
    		return points.length;
//    	double slop[][] =new double[points.length][points.length];
//    	int[] line=new int[points.length];
    	Set<Integer> set[]=new HashSet[points.length];
    	for(int i=0;i<points.length;i++){
    		set[i]=new HashSet<Integer>();
    		set[i].add(i);
    	}
    	for(int i=0;i<points.length;i++){
			int same=1;
			int thismax=0;
    		HashMap<Double,Integer> tem=new HashMap<Double,Integer>();
    		for(int j=0;j<points.length;j++){
				double sl;
    			if(!set[i].contains(j)){
    				if((double)points[j].x==(double)points[i].x&&(double)points[j].y==(double)points[i].y){
    					same++;
    					continue;
    				}
    				if((double)points[j].x==(double)points[i].x)
    					sl=Double.MIN_VALUE;
    				else
    					sl=((double)points[j].y-(double)points[i].y)/(((double)points[j].x-(double)points[i].x));
    				if(tem.containsKey(sl)){
	    				set[j].add(i);
    					tem.put(sl, tem.get(sl)+1);
    					thismax=Math.max(tem.get(sl), thismax);
	    			}
	    			else{
	    				tem.put(sl, 2);
	    			}
    			}
    				
    		}
    		
    		max=Math.max(thismax+same-1, max);
			max=Math.max(max, same);
    	}
        return max;
    }
	public static void main(String[] args) {
		num149 sol=new num149();
		Point[] points=new Point[3];
		points[0]=new Point(1,1);
		points[1]=new Point(1,1);
		points[2]=new Point(1,1);
//		points[3]=new Point(2,2);
		System.out.println(sol.maxPoints(points));
	}

}

//for(int i=0;i<points.length-1;i++){
//	for(int j=i+1;j<points.length;j++){
//		if(i==j)
//			continue;
//		double slop;
//		if(((double)points[j].x-(double)points[i].x)==0)
//			slop=Double.MIN_VALUE;
//		else
//			slop=((double)points[j].y-(double)points[i].y)/(((double)points[j].x-(double)points[i].x));
//		if(hm.containsKey(slop)){
//			hm.put(slop, hm.get(slop)+1);
//			max=Math.max(hm.get(slop), max);
//		}
//		else{
//			hm.put(slop, 2);
//		}
//	}
//}