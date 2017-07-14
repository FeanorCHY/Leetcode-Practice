import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num084 {

    //divide and conque TLE O(nlogn-n^2)
    // public int largestRectangleArea(int[] heights) {
    //     if(heights==null||heights.length==0)
    //         return 0;
    //     int len=heights.length;
    //     return search(heights,0,len-1);
    // }
    // private int search(int[] nums,int start,int end){
    //     if(start==end)
    //         return nums[start];
    //     else if(start>end)
    //         return 0;
    //     int min=nums[start];
    //     List<Integer> list=new ArrayList<Integer>(nums.length);
    //     for(int i=start;i<=end;i++){
    //         if(nums[i]==min)
    //             list.add(i);
    //         else if(nums[i]<min){
    //             min=nums[i];
    //             list=new ArrayList<Integer>(nums.length);
    //             list.add(i);
    //         }
    //     }
    //     int res=min*(end-start+1);
    //     for(int each:list){
    //         res=Math.max(res,search(nums,start,each-1));
    //         start=each+1;
    //     }
    //     res=Math.max(res,search(nums,start,end));
    //     return res;
    // }
    
    //Stack O(N) fail
    // class LRNode{
    //     int val;
    //     int pos;
    //     public LRNode(int val,int pos){
    //         this.val=val;
    //         this.pos=pos;
    //     }
    // }
    // public int largestRectangleArea(int[] heis) {
    //     if(heis==null||heis.length==0)
    //         return 0;
    //     Stack<LRNode> st=new Stack<LRNode>();
    //     st.push(new LRNode(heis[0],0));
    //     int res=heis[0];
    //     for(int i=1;i<=heis.length;i++){
    //         int h=i<heis.length?heis[i]:0;
    //         if(i<heis.length&&h>st.peek().val)
    //             st.push(new LRNode(heis[i],i));
    //         else{
    //             LRNode node=null;
    //             while(!st.isEmpty()&&st.peek().val>=h){
    //                 node=st.pop();
    //                 if(i==heis.length)
    //                     res=Math.max(res,node.val*(heis.length-node.pos));
    //                 else
    //                     res=Math.max(res,heis[i]*(i-node.pos+1));
    //             }
    //             node.val=h;
    //             st.push(node);
    //         }
    //     }
    //     return res;
    // }
    
    
    
    //Stack O(N)
    // public int largestRectangleArea(int[] heis) {
    //     if(heis==null||heis.length==0)
    //         return 0;
    //     Stack<Integer> st=new Stack<Integer>();
    //     int res=0;
    //     for(int i=0;i<=heis.length;i++){
    //         int h=i<heis.length?heis[i]:0;
    //         if(st.isEmpty()||h>heis[st.peek()])
    //             st.push(i);
    //         else{
    //             int pos=st.pop();
    //             res=Math.max(res,(st.isEmpty()?i:i-st.peek()-1)*heis[pos]);
    //             i--;
    //         }
    //     }
    //     return res;
    // }
    
    
    //better Stack O(N)
    public int largestRectangleArea(int[] heis) {
        if(heis==null||heis.length==0)
            return 0;
        Stack<Integer> st=new Stack<Integer>();
        st.push(-1);
        int res=0;
        for(int i=0;i<=heis.length;i++){
            int h=i<heis.length?heis[i]:0;
            while(st.peek()!=-1&&h<=heis[st.peek()]){
                int pos=st.pop();
                res=Math.max(res,(i-st.peek()-1)*heis[pos]);
            }
            st.push(i);
        }
        return res;
    }
	public static void main(String[] args) {
		int[] test={2,1,5,6,2,3};
		num084 sol=new num084();
		System.out.println(sol.largestRectangleArea(test));
	}

}
