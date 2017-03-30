package leedcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class num370 {
    public int[] getModifiedArray(int length, int[][] updates) {
//    	HashMap<Integer,Integer> end=new HashMap<Integer,Integer>();
    	int[] end=new int[length];
    	int[] result=new int[length];
    	Arrays.sort(updates,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
    		
    	});
    	int sum=0;
    	int index=0;
    	for(int i=0;i<length;i++){
			while(index<updates.length&&updates[index][0]==i){
				sum+=updates[index][2];
				if(updates[index][1]+1<length)
					end[updates[index][1]+1]-=updates[index][2];
				index++;
			}
    		sum+=end[i];
    		result[i]+=sum;
    	}
    	return result;
    }
	public static void main(String[] args) {
		int test[][]={{1,  3,  2},{2,  4,  3},{0,  2, -2}};
		num370 sol=new num370();
		System.out.println(Arrays.toString(sol.getModifiedArray(5, test)));
	}

}
