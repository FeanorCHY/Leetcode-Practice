package leedcode;

public class num280 {
    public void wiggleSort(int[] nums) {
    	for(int i=0;i<nums.length-1;i++){
    		if(i%2==0&&nums[i]>nums[i+1]){
				int tem=nums[i+1];
				nums[i+1]=nums[i];
				nums[i]=tem;
    		}
    		else if(i%2==1&&nums[i]<nums[i+1]){
				int tem=nums[i+1];
				nums[i+1]=nums[i];
				nums[i]=tem;
    		}
    		
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
