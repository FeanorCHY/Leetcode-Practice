import java.util.Arrays;

public class num456 {
    //Stack Time O(N) Space O(N)
    // class Pair{
    //     int min;
    //     int max;
    //     public Pair(int val){
    //         min=val;
    //         max=val;
    //     }
    // }
    // public boolean find132pattern(int[] nums) {
    //     if(nums==null||nums.length<3)
    //         return false;
    //     Stack<Pair> st=new Stack<Pair>();
    //     st.push(new Pair(nums[0]));
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]>st.peek().min&&nums[i]<st.peek().max)
    //             return true;
    //         else if(nums[i]>st.peek().max){
    //             st.peek().max=nums[i];
    //             Pair last=st.pop();
    //             while(!st.isEmpty()){
    //                 if(nums[i]>=st.peek().max){
    //                     st.pop();
    //                 }
    //                 else if(nums[i]>st.peek().min&&nums[i]<st.peek().max)
    //                     return true;
    //                 else
    //                     break;
    //             }
    //             st.push(last);
    //         }
    //         else if(nums[i]<st.peek().min){
    //             st.push(new Pair(nums[i]));
    //         }
    //     }
    //     return false;
    // }
    
    
    public boolean find132pattern(int[] nums) {
        if(nums==null||nums.length<3)
            return false;
        int n=nums.length;
        int[] arr = new int[n];
        arr[0]=nums[0];
        for(int i=1;i<n;i++)
            arr[i]=Math.min(arr[i-1],nums[i-1]);
        int top=n;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<=arr[i])
                continue;
            while(top<n&&arr[i]>=arr[top])
                top++;
            if(top<n&&nums[i]>arr[top])
                return true;
            arr[--top]=nums[i];
        }
            
        return false;
    }
	public static void main(String[] args) {
		int[] test={17,19,12,13,4,5,18};
		num456 sol=new num456();
		System.out.println(sol.find132pattern(test));
	}

}
