package leedcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class num391 {
    public boolean isRectangleCover(int[][] rec) {
    	if(rec.length==0)
    		return false;
    	int x1=Integer.MAX_VALUE;
    	int y1=Integer.MAX_VALUE;
    	int x2=Integer.MIN_VALUE;
    	int y2=Integer.MIN_VALUE;
    	int area=0;
    	HashSet<String> set=new HashSet<String>(); 
    	for(int[] each:rec){
    		x1=Math.min(x1, each[0]);
    		y1=Math.min(y1, each[1]);
    		x2=Math.max(x2, each[2]);
    		y2=Math.max(y2, each[3]);
    		area+=(each[2]-each[0])*(each[3]-each[1]);
    		String p1=each[0]+" "+each[1];
    		String p2=each[0]+" "+each[3];
    		String p3=each[2]+" "+each[1];
    		String p4=each[2]+" "+each[3];
    		if(set.contains(p1))
    			set.remove(p1);
    		else
    			set.add(p1);
    		if(set.contains(p2))
    			set.remove(p2);
    		else
    			set.add(p2);
    		if(set.contains(p3))
    			set.remove(p3);
    		else
    			set.add(p3);
    		if(set.contains(p4))
    			set.remove(p4);
    		else
    			set.add(p4);
    	}
		String p1=x1+" "+y1;
		String p2=x1+" "+y2;
		String p3=x2+" "+y1;
		String p4=x2+" "+y2;
    	if(!set.contains(p1)||!set.contains(p2)||!set.contains(p3)||!set.contains(p4)||set.size()!=4||(area!=(x2-x1)*(y2-y1)))
    		return false;
    	return true;
    }
	public static void main(String[] args) {
		int[][] test={{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		num391 sol=new num391();
		System.out.println(sol.isRectangleCover(test));
	}

}




//PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
//	@Override
//	public int compare(int[] o1, int[] o2) {
//		return o1[1]==o2[1]?(o1[0]-o2[0]):(o1[1]-o2[1]);
//	}
//});
//for(int[] each:rec)
//	pq.add(each);
//int end=-1;
//int begin=-1;
//int curx=-1;
//int cury=-1;
//while(pq.isEmpty()){
//	int[] each=pq.poll();
//	if(each[1]+1!=each[3]){
//		for(int i=each[1]+1;i<each[3];i++){
//			pq.add(new int[]{each[0],i,each[2],i+1});
//		}
//	}
//	if(!pq.isEmpty()&&pq.peek()[0]==begin&&end==-1){
//		end=each[3];
//	}
//	if(begin==-1){
//		begin=each[0];
//		if(!pq.isEmpty()&&pq.peek()[0]==begin&&end==-1){
//			end=each[3];
//		}
//		curx=each[2];
//		cury=each[1];
//	}
//	if((begin!=-1&&each[0]<begin)||(end!=-1&&each[3]>end)){
//		return false;
//	}
//	if(each[1]-cury>1){
//		return false;
//	}
//	else if(each[1]-cury==1){
//		cury++;
//		if(each[])
//	}
//}
//
//return true;