import java.util.Arrays;
import java.util.Comparator;

public class num354 {
    //sort and dfs with memory Time O(n^2) Space O(n)
    // public int maxEnvelopes(int[][] envs) {
    //     if(envs==null||envs.length==0||envs[0].length==0)
    //         return 0;
    //     Arrays.sort(envs,new Comparator<int[]>(){
    //        @Override
    //         public int compare(int[] e1,int[] e2){
    //             if(e1[0]==e2[0])
    //                 return e2[1]-e1[1];
    //             return e2[0]-e1[0];
    //         }
    //     });
    //     int res=0;
    //     int[] dp=new int[envs.length];
    //     for(int i=0;i<envs.length;i++){
    //         if(i>0&&envs[i][0]==envs[i-1][0])
    //             continue;
    //         res=Math.max(res,search(envs,i,dp));
    //     }
    //     return res;
    // }
    // private int search(int[][] envs,int idx,int[] dp){
    //     if(dp[idx]>0)
    //         return dp[idx];
    //     dp[idx]=1;
    //     for(int i=idx+1;i<envs.length;i++){
    //         if(envs[idx][0]>envs[i][0]&&envs[idx][1]>envs[i][1])
    //             dp[idx]=Math.max(dp[idx],search(envs,i,dp)+1);
    //     }
    //     return dp[idx];
    // }
    
    
    //sort and Binary Search Insert Time O(nlogn) Space O(n)
    public int maxEnvelopes(int[][] envs) {
        if(envs==null||envs.length==0||envs[0].length==0)
            return 0;
        Arrays.sort(envs,new Comparator<int[]>(){
           @Override
            public int compare(int[] e1,int[] e2){
                if(e1[0]==e2[0])
                    return e1[1]-e2[1];
                return e2[0]-e1[0];
            }
        });
        int res=0;
        int[] dp=new int[envs.length];
        for(int[] env:envs){
            int index=Bsearch(dp,env[1],res-1);
            dp[index]=env[1];
            if(res==index)
                res++;
        }
        return res;
    }
    private int Bsearch(int[] dp,int target,int r){
        int l=0;
        while(l<=r){
            int mid=(l+r)/2;
            if(dp[mid]>target)
                l=mid+1;
            else
                r=mid-1;
        }
        return l;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
