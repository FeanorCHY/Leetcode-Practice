import java.util.HashSet;

public class num210 {

    //BFS Time: O(V) Space: O(E+V)
    // public int[] findOrder(int n, int[][] pres) {
    //     if(n<=0)
    //         return new int[0];
    //     int[] res=new int[n];
    //     HashSet<Integer> sets[]=new HashSet[n];
    //     for(int i=0;i<n;i++)
    //         sets[i]=new HashSet<Integer>();
    //     int[] degree=new int[n];
    //     for(int[] pre:pres){
    //         degree[pre[0]]++;
    //         sets[pre[1]].add(pre[0]);
    //     }
    //     Queue<Integer> q=new LinkedList<Integer>();
    //     int idx=0;
    //     for(int i=0;i<n;i++){
    //         if(degree[i]==0){
    //             res[idx++]=i;
    //             q.add(i);
    //         }
    //     }
    //     while(!q.isEmpty()){
    //         int node=q.poll();
    //         for(int to:sets[node]){
    //             degree[to]--;
    //             if(degree[to]==0){
    //                 res[idx++]=to;
    //                 q.add(to);
    //             }
    //         }
    //     }
    //     if(idx==n)
    //         return res;
    //     else
    //         return new int[0];
    // }
    
    
    
    //DFS Time: O(V) Space: O(E+V)
    int[] res;
    HashSet<Integer> sets[];
    int[] degree;
    boolean[] visit;
    int idx=0;
    public int[] findOrder(int n, int[][] pres) {
        if(n<=0)
            return new int[0];
        sets=new HashSet[n];
        res=new int[n];
        degree=new int[n];
        visit=new boolean[n];
        for(int i=0;i<n;i++)
            sets[i]=new HashSet<Integer>();
        for(int[] pre:pres){
            degree[pre[0]]++;
            sets[pre[1]].add(pre[0]);
        }
        for(int i=0;i<n;i++){
            if(!visit[i]&&degree[i]==0){
                visit[i]=true;
                search(i);
            }
        }
        if(idx==n)
            return res;
        else
            return new int[0];
        
    }
    private void search(int cur){
        res[idx++]=cur;
        for(int to:sets[cur]){
            if(visit[to])
                continue;
            degree[to]--;
            if(degree[to]==0){
                visit[to]=true;
                search(to);
            }
        }
    }
	public static void main(String[] args) {

	}

}
