package leedcode;

public class num42 {
    public int trap(int[] height) {
    	if(height.length<=2)
    		return 0;
    	int sum=0;
    	int[] left=new int[height.length];
    	int[] right=new int[height.length];
    	int max=0;
    	for(int i=0;i<height.length;i++){

    		left[i]=Math.max(max, height[i]);
    		max=left[i];
    	}
    	max=0;
    	for(int i=height.length-1;i>=0;i--){
    		right[i]=Math.max(max, height[i]);
    		max=right[i];
    	}
    	for(int i=1;i<height.length-1;i++){
    		sum+=Math.min(left[i-1], right[i+1])>height[i]?Math.min(left[i-1], right[i+1])-height[i]:0;
    	}
    	
    	
    	return sum;
    }
	public static void main(String[] args) {
		int test[]={9,6,8,8,5,6,3};
		num42 sol=new num42();
		System.out.println(sol.trap(test));
	}

}
