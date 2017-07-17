
public class num052 {

    int res=0;
    public int totalNQueens(int n) {
        if(n<=0)
            return 0;
        traverse(n,0,new boolean[n],new boolean[n+n],new boolean[n+n]);
        return res;
    }
    private void traverse(int n,int cur,boolean visit[],boolean dia1[],boolean dia2[]){
        if(cur==n){
            res++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]&&!dia1[i+cur]&&!dia2[cur+n-1-i]){
                visit[i]=true;
                dia1[i+cur]=true;
                dia2[cur+n-1-i]=true;
                traverse(n,cur+1,visit,dia1,dia2);
                visit[i]=false;
                dia1[i+cur]=false;
                dia2[cur+n-1-i]=false;
            }
        }
    }
}
