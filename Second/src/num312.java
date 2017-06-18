
public class num312 {
    //failed traverse n!
    // class CNode{
    //     int val;
    //     CNode next;
    //     public CNode(int val){
    //         this.val=val;
    //         next=null;
    //     }
    // }
    // public int maxCoins(int[] nums) {
    //     if(nums==null||nums.length==0)
    //         return 0;
    //     CNode head=new CNode(1);
    //     CNode node=head;
    //     for(int each:nums){
    //         CNode tem=new CNode(each);
    //         node.next=tem;
    //         node=tem;
    //     }
    //     return traverse(head,0);
    // }
    // private int traverse(CNode head,int cur){
    //     int tem=cur;
    //     CNode node=head.next;
    //     CNode last=head;
    //     while(node!=null){
    //         last.next=node.next;
    //         tem=Math.max(tem,traverse(head,cur+node.val*last.val*(node.next==null?1:node.next.val)));
    //         last.next=node;
    //         last=node;
    //         node=node.next;
    //     }
    //     return tem;
    // }
    
    
    //Time O(n^3) Space O(n^2)
    public int maxCoins(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int[][] dp=new int[nums.length][nums.length];
        for(int len=1;len<=nums.length;len++){
            for(int start=0;start<=nums.length-len;start++){
                int end=start+len-1;
                for(int i=start;i<=end;i++){
                    int cur=nums[i]*cal(nums,start-1)*cal(nums,end+1);
                    cur+=i==start?0:dp[start][i-1];
                    cur+=i==end?0:dp[i+1][end];
                    dp[start][end]=Math.max(cur,dp[start][end]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
    private int cal(int[] nums,int idx){
        if(idx==-1||idx==nums.length)
            return 1;
        return nums[idx];
    }
	public static void main(String[] args) {
		num312 sol=new num312();
		int[] test={3,1,5,8};
		System.out.println(sol.maxCoins(test));
	}

}
