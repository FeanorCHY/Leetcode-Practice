
public class num200 {
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
    // char[][] grid;
    // int count=0;
    // int[] dx={0,1,-1,0};
    // int[] dy={1,0,0,-1};
    // public int numIslands(char[][] grid) {
    //     this.grid=grid;
    //     if(grid==null||grid.length==0)
    //         return 0;
    //     for(int i=0;i<grid.length;i++){
    //         for(int j=0;j<grid[0].length;j++){
    //             if(grid[i][j]=='1'){
    //                 count++;
    //                 serach(i,j);
    //             }
    //         }
    //     }
    //     return count;
    // }
    // private void serach(int x,int  y){
    //     for(int i=0;i<4;i++){
    //         int x2=x+dx[i];
    //         int y2=y+dy[i];
    //         if(x2>=0&&x2<grid.length&&y2>=0&&y2<grid[0].length&&grid[x2][y2]=='1'){
    //             grid[x2][y2]='0';
    //             serach(x2,y2);
    //         }
    //     }
    // }
    
    //bad answer!!
   public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int[][] status=new int[m+1][n+1];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    int down=status[i+1][j];
                    int right=status[i][j+1];
                    if(down==0&&right==0)
                        status[i+1][j+1]=++count;
                    else if(down!=0&&right!=0){
                        int val=Math.min(down,right);
                        if(down<right){
                            changeR(status[i],val,j+1);
                            count--;
                        }
                        else if(right<down){
                            changeL(status[i+1],val,j);
                            count--;
                        }
                        status[i+1][j+1]=val;
                    }
                    else
                        status[i+1][j+1]=Math.max(down,right);
//	                    System.out.println(i+" "+j+" "+status[i+1][j+1]);
                }
            }
        }
        return count;
    }
    private void changeL(int[] row,int val,int idx){
        for(int i=idx;i>=0;i--){
            if(row[i]==0)
                break;
            row[i]=val;
        }
    }
    private void changeR(int[] row,int val,int idx){
        for(int i=idx;i<row.length;i++){
            if(row[i]==0)
                break;
            row[i]=val;
        }
    }
	public static void main(String[] args) {
		char[][] test=
			{"1010101".toCharArray(),"1010101".toCharArray(),"1010101".toCharArray(),"1010101".toCharArray(),"1110101".toCharArray(),"0000001".toCharArray(),"1111111".toCharArray()};
//			{"1111111".toCharArray(),"0000001".toCharArray(),"1111101".toCharArray(),"1000101".toCharArray(),"1010101".toCharArray(),"1011101".toCharArray(),"1111111".toCharArray()};
//			{"111".toCharArray(),"010".toCharArray(),"111".toCharArray()};
//			{"1111111111".toCharArray(),"0000000001".toCharArray(),"1111111101".toCharArray(),"1000000101".toCharArray(),"1000000101".toCharArray(),"1010000101".toCharArray(),"1011111101".toCharArray(),"1000000001".toCharArray(),"1111111111".toCharArray()};
		for(int i=0;i<test.length;i++){
			System.out.println(new String(test[i]));
		}
		num200 sol=new num200();
		System.out.println(sol.numIslands(test));
	}

}
