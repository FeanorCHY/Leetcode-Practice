package leedcode;

public class num215 {
	int[] arr;
    public int findKthLargest(int[] nums, int k) {
    	arr=nums;
    	int low=0;
    	int high=nums.length-1;
    	while(true){
        	int pos=quickSort(low,high);
	    	if(k-1==pos){
	    		return nums[pos];
	    	}
	    	else if(pos>k-1){
	    		high=pos-1;
	    	}
	    	else{
	    		low=pos+1;
	    	}
    	}
    }
    public int quickSort(int low,int high){
    	while(high>low){
	    	while(high>low){
	    		if(arr[high]<arr[low])
	    			high--;
	    		else
	    			break;
	    	}
	    	if(high==low)
	    		return low;
	    	int tem=arr[low];
	    	arr[low++]=arr[high];
	    	arr[high]=tem;
	    	while(high>low){
	    		if(arr[low]>arr[high])
	    			low++;
	    		else
	    			break;
	    	}
	    	tem=arr[low];
	    	arr[low]=arr[high];
	    	arr[high]=tem;
    	}
    	return high;
    }
	public static void main(String[] args) {
		int[] test={3,2,3,1,2,4,5,5,6};
		num215 sol=new num215();
		System.out.println(sol.findKthLargest(test, 4));
	}

}
