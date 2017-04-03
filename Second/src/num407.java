import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class num407 {
    //what if negative value?
    //traditional way failed!
    // int m;
    // int n;
    // int[] dx={1,0,-1,0};
    // int[] dy={0,1,0,-1};
    // public int trapRainWater(int[][] heightMap) {
    //     if(heightMap==null||heightMap.length<=2||heightMap[0].length<=2)
    //         return 0;
    //     m=heightMap.length;
    //     n=heightMap[0].length;
    //     int[][] col=new int[m][n];
    //     for(int i=1;i<n-1;i++){
    //         int left=0;
    //         int right=0;
    //         int l=0,r=m-1;
    //         while(l<=r){
    //             left=Math.max(left,heightMap[l][i]);
    //             right=Math.max(right,heightMap[r][i]);
    //             // int teml=l,temr=r;
    //             if(left<=right)
    //                 col[l++][i]=left;
    //             else
    //                 col[r--][i]=right;
    //         }
    //     }
    //     boolean sink[][]=new boolean[m][n];
    //     removeSink(heightMap,sink);
    //     int res=0;
    //     for(int i=1;i<m-1;i++){
    //         int left=0,right=0;
    //         int l=0,r=n-1;
    //         while(l<=r){
    //             left=Math.max(left,heightMap[i][l]);
    //             right=Math.max(right,heightMap[i][r]);
    //             if(left<=right){
    //                 if(!sink[i][l])
    //                     res+=Math.max(0,Math.min(col[i][l],left)-heightMap[i][l]);
    //                 l++;
    //             }
    //             else{
    //                 if(!sink[i][r])
    //                     res+=Math.max(0,Math.min(col[i][r],right)-heightMap[i][r]);
    //                 r--;
    //             }
    //         }
    //     }
    //     return res;
    // }
    // private void removeSink(int[][] heightMap,boolean[][] sink){
    //     for(int i=0;i<m;i++){
    //         findSink(heightMap,sink,i,0);
    //         findSink(heightMap,sink,i,n-1);
    //     }
    //     for(int i=1;i<n-1;i++){
    //         findSink(heightMap,sink,0,i);
    //         findSink(heightMap,sink,m-1,i);
    //     }
    // }
    // private void findSink(int[][] heightMap,boolean[][] sink,int x,int y){
    //     sink[x][y]=true;
    //     for(int i=0;i<4;i++){
    //         int nx=x+dx[i];
    //         int ny=y+dy[i];
    //         if(nx>0&&ny>0&&nx<m-1&&ny<n-1&&heightMap[nx][ny]>=heightMap[x][y]&&!sink[nx][ny]){
    //             findSink(heightMap,sink,nx,ny);
    //         }
    //     }
    // }
    
    
    
    
    
    //Priority Queue Time O(MN) Space(MN)
    int[] dx={1,0,-1,0};
    int[] dy={0,1,0,-1};
    class Sink{
        int x;
        int y;
        int h;
        public Sink(int x,int y,int h){
            this.x=x;
            this.y=y;
            this.h=h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length<=2||heightMap[0].length<=2)
            return 0;
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean[][] visit=new boolean[m][n];
        PriorityQueue<Sink> pq=new PriorityQueue<Sink>(new Comparator<Sink>(){
            @Override
            public int compare(Sink s1,Sink s2){
                return s1.h-s2.h;
            }
        });
        for(int i=1;i<m-1;i++){
            visit[i][0]=true;
            visit[i][n-1]=true;
            pq.add(new Sink(i,0,heightMap[i][0]));
            pq.add(new Sink(i,n-1,heightMap[i][n-1]));
        }
        for(int i=1;i<n-1;i++){
            visit[0][i]=true;
            visit[m-1][i]=true;
            pq.add(new Sink(0,i,heightMap[0][i]));
            pq.add(new Sink(m-1,i,heightMap[m-1][i]));
        }
        int res=0;
        while(!pq.isEmpty()){
            Sink node=pq.poll();
            for(int i=0;i<4;i++){
                int nx=node.x+dx[i];
                int ny=node.y+dy[i];
                if(nx>0&&ny>0&&nx<m-1&&ny<n-1&&!visit[nx][ny]){
                    visit[nx][ny]=true;
                    res+=Math.max(0,node.h-heightMap[nx][ny]);
                    pq.add(new Sink(nx,ny,Math.max(node.h,heightMap[nx][ny])));
                }
            }
        }
        return res;
    }   
	public static void main(String[] args) {
		int[][] test=
//			{{3,2,5},{4,1,8},{1,3,2}};
//			{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
			{{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
		num407 sol=new num407();
		System.out.println(sol.trapRainWater(test));
	}

}
