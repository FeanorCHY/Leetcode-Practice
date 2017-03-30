package leedcode;

import java.util.Arrays;
import java.util.HashMap;

public class num377 {
	int[] nums;
	int count=0;
	HashMap<Integer,Integer> fre=new HashMap<Integer,Integer>(); 
    public int combinationSum4(int[] nums, int target) {
    	fre.put(0, 1);
    	this.nums=nums;
    	Arrays.sort(nums);
    	tryGo(-1,target);
        return fre.get(target);
    }
    public void tryGo(int last,int target){
    	int tem=0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==target){
    			tem++;
    			fre.put(target, tem);
    			return;
    		}
    		else if(nums[i]<target){
    			if(fre.containsKey(target-nums[i])){
    				tem+=fre.get(target-nums[i]);
    			}
    			else{
    				tryGo(i,target-nums[i]);
    				tem+=fre.get(target-nums[i]);
    			}
    		}
    		else{
    			fre.put(target, tem);
    			return;
    		}
    			
    	}
    	fre.put(target, tem);
    }
	public static void main(String[] args) {
		int[] test={3,1,2};
		num377 sol=new num377();
		System.out.println(sol.combinationSum4(test, 30));

	}

}
