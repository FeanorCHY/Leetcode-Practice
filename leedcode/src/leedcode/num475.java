package leedcode;

import java.util.Arrays;

public class num475 {
	int[] houses;
	int[] heaters;
    public int findRadius(int[] houses, int[] heaters) {
    	this.heaters=heaters;
    	long max=0;
    	Arrays.sort(heaters);
    	for(int each:houses){
    		max=Math.max(max, find(each));
    	}
    	
    	
        return (int)max;
    }
    private long find(long pos){
    	int l=0;
    	int r=heaters.length-1;
    	while(l<=r){
    		int mid=(l+r)/2;
    		if(heaters[mid]>pos)
    			r=mid-1;
    		else if(heaters[mid]==pos)
    			return 0;
    		else
    			l=mid+1;
    	}
    	if(l==heaters.length)
    		return pos-(long)heaters[r];
    	if(r==-1)
    		return (long)heaters[l]-pos;
    	
    	return Math.min(pos-heaters[r], heaters[l]-pos);
    }
	public static void main(String[] args) {
		int test1[]={282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
		int test2[]={823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
		num475 sol=new num475();
		System.out.println(sol.findRadius(test1, test2));
	}

}
