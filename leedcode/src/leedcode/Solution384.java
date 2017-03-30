	package leedcode;

import java.util.ArrayList;

public class Solution384 {

	int[] nums;
	boolean[] used;
	ArrayList<int[]> list;
	int[] arr;
    public Solution384(int[] nums) {
        this.nums=nums;
        list=new ArrayList<int[]>();
        used=new boolean[nums.length];
        arr=new int[nums.length];
        per(0);
    }
    void per(int num){
    	if(num==nums.length){
    		list.add(arr.clone());
    		return;
    	}
    	for(int i=0;i<nums.length;i++){
    		if(used[i]==false){
    			arr[num]=nums[i];
    			used[i]=true;
    			per(num+1);
    			used[i]=false;
    		}
    	}
    }
    
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	
    	
        return list.get((int)(Math.random()*list.size()));
    }
}
