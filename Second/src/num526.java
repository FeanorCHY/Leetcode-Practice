
public class num526 {
    //brute force Time O(N!) Space O(N)
    // int res=0;
    // public int countArrangement(int N) {
    //     if(N<=3)
    //         return N;
    //     boolean visit[]=new boolean[N];
    //     dfs(visit,1,N);
    //     return res;
    // }
    // private void dfs(boolean[] visit,int cur,int N){
    //     if(cur==N+1){
    //         res++;
    //         return;
    //     }
    //     for(int i=1;i<=N;i++){
    //         if(!visit[i-1]&&(cur%i==0||i%cur==0)){
    //             visit[i-1]=true;
    //             dfs(visit,cur+1,N);
    //             visit[i-1]=false;
    //         }
    //     }
    // }
    
    
    //swap Time O(N!) Space O(N)
    int res = 0;
    public int countArrangement(int N) {
        if(N<=3)
            return N;
        int[] nums=new int[N];
        for(int i=1;i<=N;i++)
            nums[i-1]=i;
        traverse(nums,0);
        return res;
    }
    private void traverse(int[] nums,int start){
        if(start==nums.length)
            res++;
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            if(nums[start]%(start+1)==0||(start+1)%nums[start]==0)
                traverse(nums,start+1);
            swap(nums,i,start);
        }
    }
    private void swap(int[] nums,int l,int r){
        if(l!=r){
            nums[l]^=nums[r];
            nums[r]^=nums[l];
            nums[l]^=nums[r];
        }
    }
    
	public static void main(String[] args) {
		num526 sol=new num526();
		System.out.println(sol.countArrangement(4));
	}

}
