
public class num361 {

    //Time: O(MN) Space: O(N)
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[] em=new int[n];
        int[] wall=new int[n];
        int res=0;
        for(int i=0;i<m;i++){
            int num=0;
            int rmax=0;
            boolean zero=false;
            for(int j=0;j<n;j++){
                if(i>=wall[j]){
                    int k=i;
                    int tem=0;
                    while(k<m&&grid[k][j]!='W'){
                        if(grid[k++][j]=='E')
                            tem++;
                    }
                    wall[j]=k;
                    em[j]=tem;
                }
                if(grid[i][j]=='0'){
                    rmax=Math.max(rmax,em[j]);
                    zero=true;
                }
                else if(grid[i][j]=='E'){
                    num++;
                }
                else if(grid[i][j]=='W'){
                    if(zero)
                        res=Math.max(res,rmax+num);
                    rmax=0;
                    num=0;
                    zero=false;
                }
            }
            if(zero)
                res=Math.max(res,rmax+num);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
