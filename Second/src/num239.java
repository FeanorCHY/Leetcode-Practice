
public class num239 {

    //Dequeue Time O(n) Space O(k)
    // class SWNode{
    //     int val;
    //     int idx;
    //     public SWNode(int val,int idx){
    //         this.val=val;
    //         this.idx=idx;
    //     }
    // }
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if(nums==null||nums.length==0||k>nums.length)
    //         return new int[0];
    //     int[] res=new int[nums.length-k+1];
    //     LinkedList<SWNode> st=new LinkedList<SWNode>();
    //     for(int i=0;i<nums.length;i++){
    //         while(!st.isEmpty()&&st.getLast().val<nums[i]){
    //             st.removeLast();
    //         }
    //         st.addLast(new SWNode(nums[i],i));
    //         while(!st.isEmpty()&&i-st.getFirst().idx>=k){
    //             st.removeFirst();
    //         }
    //         if(i>=k-1)
    //             res[i-k+1]=st.getFirst().val;
    //     }
    //     return res;
    // }
    
    
    
    //two array Time O(n) Space O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0||k>nums.length)
            return new int[0];
        int[] res=new int[nums.length-k+1];
        int[] right=new int[nums.length],left=new int[nums.length];
        left[0]=nums[0];
        right[right.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            if(i%k==0){
                left[i]=nums[i];
            }
            else{
                left[i]=Math.max(nums[i],left[i-1]);
            }
            if(i%k==k-1)
                right[right.length-1-i]=nums[nums.length-1-i];
            else
                right[right.length-1-i]=Math.max(nums[right.length-1-i],right[right.length-i]);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        for(int i=0;i<res.length;i++){
            res[i]=Math.max(right[i],left[i+k-1]);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
