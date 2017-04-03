import java.util.Stack;

public class num042 {
    //one pass Time: O(N) Space O(N)
    // public int trap(int[] height) {
    //     if(height==null||height.length<=2)
    //         return 0;
    //     int max=height[0];
    //     int n=height.length;
    //     int left[]=new int[n];
    //     for(int i=1;i<n;i++){
    //         left[i]=max;
    //         max=Math.max(max,height[i]);
    //     }
    //     max=height[n-1];
    //     int res=0;
    //     for(int i=n-2;i>0;i--){
    //         res+=Math.max(0,Math.min(max,left[i])-height[i]);
    //         max=Math.max(max,height[i]);
    //     }
    //     return res;
    // }
    
    //two pointers Time: O(N) Space O(1)
    // public int trap(int[] height) {
    //     if(height==null||height.length<=2)
    //         return 0;
    //     int n=height.length;
    //     int left=height[0],right=height[n-1];
    //     int l=1,r=n-2;
    //     int res=0;
    //     while(l<=r){
    //         while(l<=r&&height[l]>=left)
    //             left=height[l++];
    //         while(l<=r&&height[r]>=right)
    //             right=height[r--];
    //         if(l<=r){
    //             if(left<=right)
    //                 res+=left-height[l++];
    //             else
    //                 res+=right-height[r--];
    //         }
    //     }
    //     return res;
    // }
    
    //Stack Time: O(N) Space O(N)
    public int trap(int[] height) {
        if(height==null||height.length<=2)
            return 0;
        Stack<Integer> st=new Stack<Integer>();
        int i=0;
        int n=height.length;
        int res=0;
        while(i<n){
            if(st.isEmpty()||height[i]<=height[st.peek()])
                st.push(i++);
            else{
                int last=st.pop();
                res+=st.isEmpty()?0:((Math.min(height[i],height[st.peek()])-height[last])*(i-st.peek()-1));
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
