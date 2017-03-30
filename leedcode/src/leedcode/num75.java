package leedcode;

public class num75 {
    public void sortColors(int[] nums) {
    	int low=0;
    	int high=nums.length-1;
    	int cur=0;
    	while(cur<=high){
    		if(nums[cur]==0){
    			int tem=nums[low];
    			nums[low]=nums[cur];
    			nums[cur]=tem;
    			cur++;
    			low++;
    		}
    		else if(nums[cur]==1){
    			cur++;
    		}
    		else{
    			int tem=nums[high];
    			nums[high]=nums[cur];
    			nums[cur]=tem;
    			high--;
    		}
    	}
    }
	public static void main(String[] args) {
		int test[]={1,0};
		num75 sol=new num75();
		sol.sortColors(test);

	}

}
