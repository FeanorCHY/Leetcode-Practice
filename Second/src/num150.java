
public class num150 {
    //union find
    // class UF {
    //     public int count = 0;
    //     public int[] id = null;
        
    //     public UF(int m, int n, char[][] grid) {
    //         for(int i = 0; i < m; i++) {
    //             for(int j = 0; j < n; j++) {
    //                 if(grid[i][j] == '1') count++;
    //             }
    //         }
    //         id = new int[m * n];
    //         for(int i = 0; i < m * n; i++) {
    //             id[i] = i;
    //         }
    //     }
        
    //     public int find(int p) {
    //         while(p != id[p]) {
    //             id[p] = id[id[p]];
    //             p = id[p];
    //         }
    //         return p;
    //     }
        
    //     public boolean isConnected(int p, int q) {
    //         int pRoot = find(p);
    //         int qRoot = find(q);
    //         if(pRoot != qRoot) return false;
    //         else return true;
    //     }
        
    //     public void union(int p, int q) {
    //         int pRoot = find(p);
    //         int qRoot = find(q);
    //         if(pRoot == qRoot) return;
    //         id[pRoot] = qRoot;
    //         count--;
    //     }
    // }
    
    // public int numIslands(char[][] grid) {
    //     if(grid.length == 0 || grid[0].length == 0) return 0;
    //     int m = grid.length, n = grid[0].length;
    //     UF uf = new UF(m , n, grid);
        
    //     for(int i = 0; i < m; i++) {
    //         for(int j = 0; j < n; j++) {
    //             if(grid[i][j] == '0') continue;
    //             int p = i * n + j;
    //             int q;
    //             if(i > 0 && grid[i - 1][j] == '1') {
    //                 q = p - n;
    //                 uf.union(p, q);
    //             }
    //             if(i < m - 1 && grid[i + 1][j] == '1') {
    //                 q = p + n;
    //                 uf.union(p, q);
    //             }
    //             if(j > 0 && grid[i][j - 1] == '1') {
    //                 q = p - 1;
    //                 uf.union(p, q);
    //             }
    //             if(j < n - 1 && grid[i][j + 1] == '1') {
    //                 q = p + 1;
    //                 uf.union(p, q);
    //             }
    //         }
    //     }
    //     return uf.count;
    // }
    
    
    
    
    
    //what if beyong 1 and 0? can I change the input? 
    // O(n^2)
//    char[][] grid;
//    int count=0;
//    int[] dx={0,1,-1,0};
//    int[] dy={1,0,0,-1};
//    public int numIslands(char[][] grid) {
//        this.grid=grid;
//        if(grid==null||grid.length==0)
//            return 0;
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//            	xxx++;
//                if(grid[i][j]=='1'){
//                    count++;
//                    serach(i,j);
//                }
//            }
//        }
//        return count;
//    }
//    private void serach(int x,int  y){
//        for(int i=0;i<4;i++){
//        	xxx++;
//            int x2=x+dx[i];
//            int y2=y+dy[i];
//            if(x2>=0&&x2<grid.length&&y2>=0&&y2<grid[0].length&&grid[x2][y2]=='1'){
//                grid[x2][y2]='0';
//                serach(x2,y2);
//            }
//        }
//    }
    
    //DP
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int[][] islands = new int[grid.length + 1][grid[0].length + 1];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                	xxx++;
                    int up = islands[i][j + 1];
                    int left = islands[i + 1][j];
                    if(left != 0 && up != 0) {
                        islands[i + 1][j + 1] = Math.min(up, left);
                        if(up > left) {
                            fillRight(islands[i], j + 1, left);
                            count--;
                        }
                        if(left > up) {
                            fillLeft(islands[i + 1], j, up);
                            count--;
                        }
                    }
                    else if(left == 0 && up == 0) {
                        islands[i + 1][j + 1] = ++count;
                    }
                    else {
                        islands[i + 1][j + 1] = Math.max(up, left);
                    }
                }
            }
        }
        return count; 
        
    }
    
    private void fillLeft(int[] row, int start, int val) {
        for(int i = start; i >=0; i--) {
        	xxx++;
            if(row[i] == 0) {
                break;
            }
            row[i] = val;
        }
    }
    
    private void fillRight(int[] row, int start, int val) {
        for(int i = start; i < row.length; i++) {
        	xxx++;
            if(row[i] == 0) {
                break;
            }
            row[i] = val;
        }
    }
    int xxx=0;
    
	public static void main(String[] args) {
		char[][] test={{'1','1','0','1','0'},{'1','1','1','1','0'},{'0','0','0','0','0'},{'0','0','0','1','1'}};
		num150 sol=new num150();
		System.out.println(sol.numIslands(test));
		System.out.println(sol.xxx);
	}
}
