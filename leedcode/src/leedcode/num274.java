package leedcode;

import java.util.Arrays;

public class num274 {
    public int hIndex(int[] citations) {
    	int[] min=new int[citations.length+1];
    	for(int i=0;i<citations.length;i++){
    		if(citations[i]>=citations.length)
    			min[citations.length]++;
    		else
    			min[citations[i]]++;
    	}
    	int count=0;
    	for(int i=min.length-1;i>=0;i--){
    		count=count+min[i];
    		if(count>=i)
    			return i;
    	}
    	return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//public int hIndex(int[] citations) {
//	Arrays.sort(citations);
//	for(int i=citations.length;i>0;i--){
//		if(citations[citations.length-i]>=i)
//			return i;
//	}
//	return 0;
//}