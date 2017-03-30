package leedcode;

public class NumArray {
	int[] sum;
	int[] arr;
	int[] nums;
    public NumArray(int[] nums) {
    	if(nums.length==0)
    		return;
    	this.nums=nums;
    	sum=new int[nums.length+1];
    	for(int i=1;i<sum.length;i++){
    		int s=0;
    		int index=i;
    		while(index<sum.length){
    			sum[index]+=nums[i-1];
    			index+=lowbit(index);
    		}
    	}
    }

    void update(int i, int val) {
    	int diff=val-nums[i];
    	nums[i]=val;
    	int index=i+1;
    	while(index<sum.length){
    		sum[index]+=diff;
    		index+=lowbit(index);
    	}
    }
    
    public int sumRange(int i, int j) {

    	return sumUp(j+1)-sumUp(i);
    }
    public int sumUp(int index){
    	int result=0;
    	while(index>=1){
    		result+=sum[index];
    		index-=lowbit(index);
    	}
    	return result;
    }
    
    public int lowbit(int i){
    	return i&(-i);
    }
}