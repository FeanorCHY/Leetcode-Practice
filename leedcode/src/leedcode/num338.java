package leedcode;

import java.util.Arrays;

public class num338 {
    public int[] countBits(int num) {
    	int result[]=new int[num+1];
    	int index=0;
    	int cur=0;
    	for(int i=1;i<=num;i++){
    		result[i]=result[cur]+1;
    		if(cur==index){
    			cur=0;
    			index=i;
    		}
    		else
    			cur++;
    	}
    	
    	
        return result;
    }
	public static void main(String[] args) {
		num338 sol=new num338();
		System.out.println(Arrays.toString(sol.countBits(10)));
	}

}
