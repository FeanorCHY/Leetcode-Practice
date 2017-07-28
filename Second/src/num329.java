import java.util.LinkedList;
import java.util.Queue;

public class num329 {

    //dfs do not need visit Time O(n) Space O(n)
    // int res=0;
    // int[] dx={0,1,0,-1};
    // int[] dy={1,0,-1,0};
    // public int longestIncreasingPath(int[][] matrix) {
    //     if(matrix==null||matrix.length==0||matrix[0].length==0)
    //         return 0;
    //     int[][] dp=new int[matrix.length][matrix[0].length];
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             dp[i][j]=search(matrix,dp,matrix[i][j],1,i,j);
    //         }
    //     }
    //     return res;
    // }
    // private int search(int[][] matrix,int[][] dp,int pre,int cur,int x,int y){
    //     if(dp[x][y]>0){
    //         res=Math.max(res,cur+dp[x][y]-1);
    //         return dp[x][y];
    //     }
    //     dp[x][y]=1;   
    //     res=Math.max(res,cur);
    //     for(int i=0;i<4;i++){
    //         int nx=dx[i]+x;
    //         int ny=dy[i]+y;
    //         if(nx>=0&&ny>=0&&nx<matrix.length&&ny<matrix[0].length&&matrix[nx][ny]>pre){
    //             dp[x][y]=Math.max(search(matrix,dp,matrix[nx][ny],cur+1,nx,ny)+1,dp[x][y]);
    //         }
    //     }
    //     return dp[x][y];
    // }
    
    
    
    //topological sort Time O(n) Space O(n)
    int res=0;
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};
    public int longestIncreasingPath(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] matrix=new int[m+2][n+2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i+1][j+1]=grid[i][j];
            }
        }
        int[][] degree=new int[m+2][n+2];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                for(int k=0;k<4;k++){
                    if(matrix[i][j]<matrix[i+dx[k]][j+dy[k]])
                        degree[i][j]++;
                }
            }
        }
        Queue<int[]> q=new LinkedList<int[]>();
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(degree[i][j]==0)
                    q.add(new int[]{i,j});
            }
        }
        int res=0;
        while(!q.isEmpty()){
            res++;
            int size=q.size();
            for(int t=0;t<size;t++){
                int[] node=q.poll();
                int i=node[0];
                int j=node[1];
                for(int k=0;k<4;k++){
                    if(matrix[i][j]>matrix[i+dx[k]][j+dy[k]]){
                        degree[i+dx[k]][j+dy[k]]--;
                        if(degree[i+dx[k]][j+dy[k]]==0){
                            q.add(new int[]{i+dx[k],j+dy[k]});
                        }
                    }
                }
            }
        }
        
        return res;
    }
	public static void main(String[] args) {
		int[][] test=
				{{9,9,4},{6,6,8},{2,1,1}};
		num329 sol=new num329();
		System.out.println(sol.longestIncreasingPath(test));
	}

}
