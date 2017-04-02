import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num310 {
    //is here cycle in the graph? 
    //BFS Time O(K+N) Space O(K+N)
    // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //     if(n<=0||edges==null)
    //         return new LinkedList<Integer>();
    //     int degree[]=new int[n];
    //     int pen=n;
    //     HashSet<Integer> map[]=new HashSet[n];
    //     for(int[] edge:edges){
    //         degree[edge[0]]++;
    //         degree[edge[1]]++;
    //         if(map[edge[0]]==null)
    //             map[edge[0]]=new HashSet<Integer>();
    //         if(map[edge[1]]==null)
    //             map[edge[1]]=new HashSet<Integer>();
    //         map[edge[1]].add(edge[0]);
    //         map[edge[0]].add(edge[1]);
    //     }
    //     Queue<Integer> q=new LinkedList<Integer>();
    //     for(int i=0;i<n;i++){
    //         if(degree[i]<=1){//take care of only one node input whose degree is zero
    //             degree[i]--;
    //             q.add(i);
    //         }
    //     }
    //     while(pen>2){
    //         int size=q.size();
    //         pen-=size;
    //         for(int i=0;i<size;i++){
    //             int node=q.poll();
    //             for(int each:map[node]){
    //                 degree[each]--;
    //                 if(degree[each]==1){
    //                     q.add(each);
    //                 }
    //             }
    //         }
    //     }
    //     return new LinkedList<Integer>(q);
    // }
    
    //optimize using ArrayList to store the edges
    // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //     if(n<=0||edges==null)
    //         return new LinkedList<Integer>();
    //     int degree[]=new int[n];
    //     int pen=n;
    //     List<Integer> map[]=new List[n];
    //     for(int i=0;i<n;i++)
    //         map[i]=new ArrayList<Integer>();
    //     for(int[] edge:edges){
    //         degree[edge[0]]++;
    //         degree[edge[1]]++;
    //         map[edge[1]].add(edge[0]);
    //         map[edge[0]].add(edge[1]);
    //     }
    //     Queue<Integer> q=new LinkedList<Integer>();
    //     for(int i=0;i<n;i++){
    //         if(degree[i]<=1){//take care of only one node input whose degree is zero
    //             degree[i]--;
    //             q.add(i);
    //         }
    //     }
    //     while(pen>2){
    //         int size=q.size();
    //         pen-=size;
    //         for(int i=0;i<size;i++){
    //             int node=q.poll();
    //             for(int each:map[node]){
    //                 degree[each]--;
    //                 if(degree[each]==1){
    //                     q.add(each);
    //                 }
    //             }
    //         }
    //     }
    //     return new LinkedList<Integer>(q);
    // }


    //DFS Time O(K+N) Space O(K+N)
    int[] height1,height2,dp;
    int n;
    List<Integer> map[];
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<=0||edges==null)
            return new LinkedList<Integer>();
        if(n==1){
            return Arrays.asList(0);
        }
        this.n=n;
        this.map=new List[n];
        for(int i=0;i<n;i++)
            map[i]=new ArrayList<Integer>();
        for(int[] edge:edges){
            map[edge[1]].add(edge[0]);
            map[edge[0]].add(edge[1]);
        }
        height1=new int[n];
        height2=new int[n];
        dp=new int[n];
        dfs(0,-1);
        dfs(0,-1,0);
        int min=dp[0];
        for(int i:dp){
            min=Math.min(i,min);
        }
        List<Integer> res=new ArrayList<Integer>(2);
        for(int i=0;i<n;i++){
            if(dp[i]==min)
                res.add(i);
        }
        return res;
    }
    private int dfs(int cur,int pre){
        height1[cur]=-1;
        height2[cur]=-1;
        for(int next:map[cur]){
            if(next==pre)
                continue;
            int tem=dfs(next,cur);
            if(tem>height1[cur]){
                height2[cur]=height1[cur];
                height1[cur]=tem;
            }
            else if(tem>height2[cur])
                height2[cur]=tem;
            
        }
        height1[cur]=Math.max(height1[cur],0);
        return height1[cur]+1;
    }
    private void dfs(int cur,int pre,int deg){
        dp[cur]=Math.max(deg,height1[cur]);
        for(int next:map[cur]){
            if(next==pre)
                continue;
            int nextdeg=Math.max(deg+1,(height1[cur]==height1[next]+1?height2[cur]:height1[cur])+1);
            dfs(next,cur,nextdeg);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
