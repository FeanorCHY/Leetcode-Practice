import java.util.LinkedList;
import java.util.List;

public class num207 {

    //topological sorting O(VE) V:number of nodes E:number of edges
    // public boolean canFinish(int n, int[][] pres) {
    //     if(pres==null||pres.length==0)
    //         return true;
    //     int degree[]=new int[n];
    //     for(int[] pre:pres){
    //         degree[pre[1]]++;
    //     }
    //     Queue<Integer> q=new LinkedList();
    //     for(int i=0;i<n;i++){
    //         if(degree[i]==0)
    //             q.add(i);
    //     }
    //     int size=q.size();
    //     while(!q.isEmpty()){
    //         int node=q.poll();
    //         for(int[] pre:pres){
    //             if(pre[0]==node){
    //                 degree[pre[1]]--;
    //                 if(degree[pre[1]]==0){
    //                     q.add(pre[1]);
    //                     size++;
    //                 }
    //             }
    //         }
    //     }
    //     return size==n;
    // }
    
    
    
    
    //Topological sort with HashSet Time:O(E+V) Space O(E)
    // public boolean canFinish(int n, int[][] pres) {
    //     if(pres==null||pres.length==0)
    //         return true;
    //     HashSet<Integer> edge[]=new HashSet[n];
    //     for(int i=0;i<n;i++)
    //         edge[i]=new HashSet<Integer>();
    //     int[] degree=new int[n];
    //     for(int[] pre:pres){
    //         edge[pre[0]].add(pre[1]);
    //         degree[pre[1]]++;
    //     }
    //     Queue<Integer> q=new LinkedList();
    //     for(int i=0;i<n;i++){
    //         if(degree[i]==0)
    //             q.add(i);
    //     }
    //     int size=q.size();
    //     while(!q.isEmpty()){
    //         int node=q.poll();
    //         for(int each:edge[node]){
    //             degree[each]--;
    //             if(degree[each]==0){
    //                 size++;
    //                 q.add(each);
    //             }
    //         }
                
    //     }
    //     return size==n;
    // }
    
    
    
    
    //DFS Time:O(E+V) Space O(V)
    boolean visit[];
    List<Integer> edge[];
    public boolean canFinish(int n, int[][] pres) {
        if(pres==null||pres.length==0)
            return true;
        edge=new List[n];
        visit=new boolean[n];
        for(int i=0;i<n;i++)
            edge[i]=new LinkedList<Integer>();
        for(int[] pre:pres){
            edge[pre[0]].add(pre[1]);
        }
        for(int i=0;i<n;i++){
            if(!visit[i]&&!search(i,new boolean[n])){
                return false;
            }
        }
        return true;
    }
    private boolean search(int cur,boolean[] got){
        System.out.println(cur);
        visit[cur]=true;
        got[cur]=true;
        for(int next:edge[cur]){
            if(got[next])
                return false;
            if(!visit[next]&&!search(next,got))
                return false;
        }
        got[cur]=false;
        return true;
    }
	public static void main(String[] args) {
		num207 sol=new num207();
		int[][] test=
				{{0,1},{0,2},{1,2}};
		System.out.println(sol.canFinish(3, test));
	}

}
