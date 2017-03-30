package leedcode;

import java.util.HashMap;
import java.util.HashSet;

public class num447 {
    public int numberOfBoomerangs(int[][] points) {
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int count=0;
    	for(int i=0;i<points.length;i++){
    		for(int j=0;j<points.length;j++){
    			if(i==j)
    				continue;
    			int d=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
    			map.put(d, map.getOrDefault(d, 0)+1);
    		}
    		for(int each:map.values()){
    			count+=each*(each-1);
    		}
    		map.clear();
    	}
    	
    	
    	return count;
    }
	public static void main(String[] args) {
//		System.out.println(Integer.toBinaryString(10000<<15));
		System.out.println(Integer.toBinaryString(40001<<16));
		num447 sol=new num447();
		int[][] test=
			{{0,0},{1,0},{2,0}};
//			{{0,0},{1,0},{-1,0},{0,1},{0,-1}};
		System.out.println(sol.numberOfBoomerangs(test));
	}

}





//public int numberOfBoomerangs(int[][] points) {
//	HashSet<Integer> map=new HashSet<Integer>();
//	for(int i=0;i<points.length;i++){
//		map.add(trans((points[i][0]+10000)*2,(points[i][1]+10000)*2));
//	}
//	int count=0;
//	for(int i=0;i<points.length;i++){
//		for(int j=i+1;j<points.length;j++){
//			if(map.contains(trans((points[i][0]+10000+10000+points[j][0]),(points[i][1]+10000+10000+points[j][1]))))
//				count++;
//		}
//	}
//	return count*2;
//}
//private int trans(int x,int y){
//	return (x<<16)+y;
//}