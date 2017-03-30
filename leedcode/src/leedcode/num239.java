package leedcode;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
public class num239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int slide[]=new int[nums.length-k+1];
    	if(k==0)
    		return new int[]{};
    	PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
          	  return b - a;
            }
    	});
    	for(int i=0;i<k-1;i++){
    		pq.add(nums[i]);
    	}
    	PriorityQueue<Integer> tem=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
            	  return b - a;
              }
      	});
    	for(int i=0;i<slide.length;i++){
    		if(!pq.isEmpty()&&pq.peek()<nums[i+k-1]){
    			tem.addAll(pq);
    			pq.clear();
    		}
    		pq.add(nums[i+k-1]);
    		slide[i]=pq.peek();
    		if(!tem.isEmpty()){
    			tem.remove();
    		}
    		else
    			pq.remove(nums[i]);
    	}
    	
        return slide;
    }
	public static void main(String[] args) {
		int test[]={-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
		num239 sol=new num239();
		System.out.println(Arrays.toString(sol.maxSlidingWindow(test, 7)));
	}

}
