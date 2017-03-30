package leedcode;

import java.util.Arrays;
import java.util.Stack;

public class num84 {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int[] h = Arrays.copyOf(heights, heights.length+1);           // last one is 0 so it's a pop()
        Stack<Integer> st = new Stack<Integer>();
        int max=0;
        int index=0;
        while(index<h.length){
        	if(st.isEmpty()||h[st.peek()]<=h[index]){
        		st.push(index++);
        	}
        	else{
        		int tem=st.pop();
        		max=Math.max(max, h[tem]*(st.isEmpty()?index:((index-1)-st.peek())));
        	}
        }
        
        return max;
    }
	public static void main(String[] args) {
		int test[]={3,2,5,6,1,3};
		num84 sol=new num84();
		System.out.println(sol.largestRectangleArea(test));
	}

}

//public int largestRectangleArea(int[] heights) {
//	
//	int max=0;
//	for(int inv=1;inv<=heights.length;inv++){
//		for(int i=0;i<=heights.length-inv;i++){
//			if(inv>1)
//				heights[i]=inv*Math.min(heights[i]/(inv-1), heights[i+1]/(inv-1));
//			max=Math.max(max, heights[i]);
//		}
//	}
//	
//	return max;
//}