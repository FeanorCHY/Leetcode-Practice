package leedcode;

public class num88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1;
        int index2=n-1;
        int i=m+n-1;
    	for(i=m+n-1;i>=0&&index1>=0&&index2>=0;i--){
        	if(nums1[index1]>nums2[index2]){
        		nums1[i]=nums1[index1];
        		index1--;
        	}
        	else{
        		nums1[i]=nums2[index2];
        		index2--;
        	}
        }
    	if(index2>=0){
    		while(i>=0){
        		nums1[i]=nums2[index2];
	    		i--;
	    		index2--;
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
