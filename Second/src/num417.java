import java.util.LinkedList;
import java.util.List;

public class num417 {

    //DFS O(mn) Space: O(mn)
    int[] dx={0,1,-1,0};
    int[] dy={1,0,0,-1};
    int m;
    int n;
    int[][] matrix;
    int[][] grid;
    List<int[]> res=new LinkedList<int[]>();
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return res;
        this.m=matrix.length;
        this.n=matrix[0].length;
        this.grid=new int[m][n];
        this.matrix=matrix;
        for(int i=0;i<m;i++){
            if(grid[i][0]==0)
                search1(i,0);
        }
        for(int i=1;i<n;i++){
            if(grid[0][i]==0)
                search1(0,i);
        }
        for(int i=0;i<m;i++){
            if(grid[i][n-1]>=0)
                search2(i,n-1);
        }
        for(int i=0;i<n-1;i++){
            if(grid[m-1][i]>=0)
                search2(m-1,i);
        }
        return res;
    }
    private void search1(int x,int y){
        grid[x][y]=1;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]==0&&matrix[nx][ny]>=matrix[x][y])
                search1(nx,ny);
        }
    }
    private void search2(int x,int y){
        if(grid[x][y]>0)
            res.add(new int[]{x,y});
        grid[x][y]=-1;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]>=0&&matrix[nx][ny]>=matrix[x][y])
                search2(nx,ny);
        }
    }
	public static void main(String[] args) {
		int[][] matrix=
				{{3,3,3},{3,1,3},{0,2,4}};
		num417 sol=new num417();
		sol.pacificAtlantic(matrix);
	}

}
