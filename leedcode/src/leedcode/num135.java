package leedcode;

import java.util.Stack;

public class num135 {
    public int candy(int[] ratings) {
    	int[] candy=new int[ratings.length];
    	candy[0]=1;
    	for(int i=1;i<ratings.length;i++){
    		candy[i]=1;
    		if(ratings[i]>ratings[i-1])
    			candy[i]=candy[i-1]+1;
    	}
    	for(int i=ratings.length-2;i>=0;i--){
    		if(ratings[i]>ratings[i+1])
    			candy[i]=Math.max(candy[i], candy[i+1]+1);
    	}
    	int sum=0;
    	for(int i=0;i<ratings.length;i++){
    		sum+=candy[i];
    	}
        return sum;
    }
	public static void main(String[] args) {
		num135 sol=new num135();
		int test[]={1,2,4,4,3};
		System.out.println(sol.candy(test));
	}

}
