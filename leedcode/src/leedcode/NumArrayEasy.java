package leedcode;

public class NumArrayEasy {
	int sum[];
    public NumArrayEasy(int[] nums) {
    	sum=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
        	int index=i;
//        	sum[i]+=nums[i-1];
        	while(index<sum.length){
        		sum[index]+=nums[i-1];
        		index+=lowbit(index);
        	}
        }
    }

    public int sumRange(int i, int j) {
        return sumUp(j+1)-sumUp(i);
    }
    private int sumUp(int index){
    	int res=0;
    	while(index>0){
    		res+=sum[index];
    		index-=lowbit(index);
    	}
    	return res;
    }
    private int lowbit(int index){
    	return index&(-index);
    }
}
